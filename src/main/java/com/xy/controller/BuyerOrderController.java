package com.xy.controller;

import com.xy.DTO.CartDTO;
import com.xy.DTO.OrderDTO;
import com.xy.Exception.SellException;
import com.xy.converter.OrderForm2OrderDTOconvert;
import com.xy.enums.SellExceptionEnum;
import com.xy.form.OrderForm;
import com.xy.service.BuyerService;
import com.xy.service.OrderService;
import com.xy.util.ResultVOUtil;
import com.xy.vo.ResultVo;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wxy on 2017/10/24.
 */

@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private BuyerService buyerService;

    //创建订单
    @PostMapping("/create")
    public ResultVo<Map<String,String>>create(@Valid OrderForm orderForm,
                                              BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("【创建订单】orderForm ="+orderForm);
            throw new SellException(SellExceptionEnum.PARAM_ERROR.getCode(),
                          bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO= OrderForm2OrderDTOconvert.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("【创建订单==】购物车不能为空 ");
            throw new SellException(SellExceptionEnum.CART_ERROR);
        }
        orderService.create(orderDTO);
        Map<String,String>map=new HashMap<>();
        map.put("orderId",orderDTO.getOrderId());

       return ResultVOUtil.success(map);
    }

    //订单列表

    @GetMapping("/list")
    public ResultVo<List<OrderDTO>>list(@RequestParam("openid")String openid,
                                        @RequestParam(value = "page",defaultValue = "0")Integer page,
                                        @RequestParam(value = "size",defaultValue = "10")Integer size){
        if (StringUtils.isEmpty(openid)){
            log.error("【查询订单列表】openid为空！！！！！");
            throw new SellException(SellExceptionEnum.PARAM_ERROR);
        }

        PageRequest request=new PageRequest(page,size);
        Page<OrderDTO> orderDTOPageable=orderService.findList(openid,request);
        return ResultVOUtil.success(orderDTOPageable.getContent());

    }
    //订单详情

    @GetMapping("/detail")
    public ResultVo<OrderDTO>detail(@RequestParam("openid")String openid,
                                    @RequestParam("orderId")String orderId){
        OrderDTO orderDTO=buyerService.findOrderOne(openid,orderId);
        return ResultVOUtil.success(orderDTO);

    }
    //取消订单
    @PostMapping("/cancel")
    public ResultVo<OrderDTO>cancel(@RequestParam("openid")String openid,
                                    @RequestParam("orderId")String orderId){

        buyerService.cancelOrderOne(openid,orderId);
        return ResultVOUtil.success();

    }
}
