package com.xy.service;

import com.xy.DTO.OrderDTO;

/**
 * Created by wxy on 2017/10/25.
 */
public interface BuyerService {

    //查询订单
    public OrderDTO findOrderOne(String openid,String orderId);

    //取消订单
    public OrderDTO cancelOrderOne(String openid,String orderId);
}
