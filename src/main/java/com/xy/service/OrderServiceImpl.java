package com.xy.service;

import com.xy.DTO.CartDTO;
import com.xy.DTO.OrderDTO;
import com.xy.Exception.SellException;
import com.xy.converter.OrderMaster2OrderDTOconvert;
import com.xy.domain.OrderDetail;
import com.xy.domain.OrderMaster;
import com.xy.domain.ProductInfo;
import com.xy.enums.OrderStatusEnum;
import com.xy.enums.PayStatusEnum;
import com.xy.enums.SellExceptionEnum;
import com.xy.repository.OrderDetailRepository;
import com.xy.repository.OrderMasterRepository;
import com.xy.util.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wxy on 2017/10/21.
 */
@Service
@Transactional
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductService productService;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {

        String orderId= KeyUtil.getUniqueKey();//订单号 ,每次创建订单会自动生成一个订单号
        BigDecimal orderAmount=new BigDecimal(0);
        //1.查询商品（数量，价格）
        for (OrderDetail orderDetail:orderDTO.getOrderDetailList()){
            ProductInfo productInfo=productService.findOne(orderDetail.getProductId());
            if (productInfo==null){
                throw new SellException(SellExceptionEnum.PRODUCT_NO_EXIST);
            }

            //2.计算总价
            orderAmount=productInfo.getProductPrice()
                    .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                    .add(orderAmount);

            //订单详情入库
            orderDetail.setDetailId(KeyUtil.getUniqueKey());
            orderDetail.setOrderId(orderId);
            BeanUtils.copyProperties(productInfo,orderDetail);
            orderDetailRepository.save(orderDetail);
        }

        //3.写入订单数据库（orderMaster和orderDetail）
        OrderMaster orderMaster=new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO,orderMaster);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterRepository.save(orderMaster);

        //4.扣库存
        List<CartDTO>cartDTOList=orderDTO.getOrderDetailList().stream()
                .map(e-> new CartDTO(e.getProductId(),e.getProductQuantity()))
                .collect(Collectors.toList());
        productService.decreaseStock(cartDTOList);
        return orderDTO;
    }

    @Override
    public OrderDTO findOne(String orderId) {

        OrderMaster orderMaster=orderMasterRepository.findOne(orderId);
        if (orderMaster==null){
            throw new SellException(SellExceptionEnum.ORDER_NOT_EXIST);
        }
        List<OrderDetail>orderDetailList=orderDetailRepository.findByOrderId(orderId);
        if (CollectionUtils.isEmpty(orderDetailList));

        OrderDTO orderDTO=new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {

        Page<OrderMaster>orderMasterPage=orderMasterRepository.findByBuyerOpenid(buyerOpenid, pageable);
        List<OrderDTO>orderDTOList= OrderMaster2OrderDTOconvert.convert(orderMasterPage.getContent());
        Page<OrderDTO>orderDTOPage=new PageImpl<OrderDTO>(orderDTOList,pageable,orderMasterPage.getTotalElements());
        return orderDTOPage;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {

        //判断订单状态
        if (!orderDTO.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())){
            log.error("【取消订单】,订单状态不正确，该订单id的状态分别为：orderId={},orderStatus={}",orderDTO.getOrderId(),orderDTO.getOrderStatus());
            throw new SellException(SellExceptionEnum.ORDER_STATUS_ERROR);

        }

        //修改订单状态
        OrderMaster orderMaster=new OrderMaster();
        orderDTO.setOrderStatus(OrderStatusEnum.CANCEL.getCode());//将订单状态改为取消状态
        BeanUtils.copyProperties(orderDTO,orderMaster);
        OrderMaster result=orderMasterRepository.save(orderMaster);
        if (result==null){
            log.error("【取消订单】,订单状态更新失败，该订单为：orderMaster="+orderMaster);
            throw new SellException(SellExceptionEnum.ORDER_STATUS_UPDATE_ERROR);
        }

        //返回库存
        //判断该订单号下的订单详情表是否存在
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("【取消订单】,订单详情表不存在，orderDTO"+orderDTO);
            throw new SellException(SellExceptionEnum.ORDER_DETAIL_NOT_EXIST);
        }
        List<CartDTO>cartDTOList=orderDTO.getOrderDetailList()
                .stream()
                .map(e-> new CartDTO(e.getProductId(),e.getProductQuantity()))
                .collect(Collectors.toList());

        productService.increaseStock(cartDTOList);
        //如果已支付，要退款
        if (orderDTO.getOrderStatus().equals(PayStatusEnum.SUCCESS.getCode())){
            //TODO
        }

        return orderDTO;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        //查询订单状态
        if (!orderDTO.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())){
            log.error("【完结订单】,订单状态不正确，该订单id的状态分别为：orderId={},orderStatus={}",orderDTO.getOrderId(),orderDTO.getOrderStatus());
            throw new SellException(SellExceptionEnum.ORDER_STATUS_ERROR);
        }
        //修改订单状态
        OrderMaster orderMaster=new OrderMaster();
        orderDTO.setOrderStatus(OrderStatusEnum.FINISH.getCode());//将订单状态改为完结状态
        BeanUtils.copyProperties(orderDTO,orderMaster);
        OrderMaster result=orderMasterRepository.save(orderMaster);
        if (result==null){
            log.error("【完结订单】,订单状态更新失败，该订单为：orderMaster="+orderMaster);
            throw new SellException(SellExceptionEnum.ORDER_STATUS_UPDATE_ERROR);
        }
        return orderDTO;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {

        //查询订单状态
        if (!orderDTO.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())){
            log.error("【订单支付】,订单状态不正确，该订单id的状态分别为：orderId={},orderStatus={}",orderDTO.getOrderId(),orderDTO.getOrderStatus());
            throw new SellException(SellExceptionEnum.ORDER_STATUS_ERROR);
        }
        //查询订单的支付状态
        if (!orderDTO.getPayStatus().equals(PayStatusEnum.WAIT.getCode())){
            log.error("【订单支付】,订单状态不正确，该订单支付的状态为：payStatus={}",orderDTO.getPayStatus());
            throw new SellException(SellExceptionEnum.PAY_STATUS_ERROR);
        }

        //修改订单状态
        OrderMaster orderMaster=new OrderMaster();
        orderDTO.setPayStatus(PayStatusEnum.SUCCESS.getCode());//将订单状态改为完结状态
        BeanUtils.copyProperties(orderDTO,orderMaster);
        OrderMaster result=orderMasterRepository.save(orderMaster);

        if (result==null){
            log.error("【订单支付】,订单状态更新失败，该订单为：orderMaster="+orderMaster);
            throw new SellException(SellExceptionEnum.ORDER_STATUS_UPDATE_ERROR);
        }
        return orderDTO;

    }
}
