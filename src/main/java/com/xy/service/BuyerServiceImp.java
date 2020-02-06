package com.xy.service;

import com.xy.DTO.OrderDTO;
import com.xy.Exception.SellException;
import com.xy.enums.SellExceptionEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wxy on 2017/10/25.
 */
@Slf4j
@Service
public class BuyerServiceImp implements BuyerService{

    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {

        OrderDTO orderDTO=checkOwnerOrder(openid,orderId);
        return orderDTO;
    }

    @Override
    public OrderDTO cancelOrderOne(String openid, String orderId) {
        OrderDTO orderDTO=checkOwnerOrder(openid,orderId);
        if (orderDTO==null){
            log.error("【取消订单】未查到该订单的相关信息！ orderId={}",orderId);
            throw new SellException(SellExceptionEnum.ORDER_NOT_EXIST);
        }
        orderService.cancel(orderDTO);
        return orderDTO;
    }


    public OrderDTO checkOwnerOrder(String openid, String orderId){

        OrderDTO orderDTO=orderService.findOne(orderId);
        if (orderDTO==null){
            return null;
        }
        //判断是否是自己的订单
        if (!orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)){
            log.error("【查询订单】==查询订单的买家微信号与登录的微信号不一致！！！！ openid={},orderDTO={}",openid,orderDTO);
            throw new SellException(SellExceptionEnum.ORDER_OWNER_ERROR);
        }

        return orderDTO;

    }
}
