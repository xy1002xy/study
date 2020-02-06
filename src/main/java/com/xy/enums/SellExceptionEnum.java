package com.xy.enums;

import lombok.Getter;

/**
 * 商品状态
 * Created by wxy on 2017/9/23.
 */

@Getter
public enum SellExceptionEnum {

    PARAM_ERROR(999,"参数不正确"),
    PRODUCT_NO_EXIST(0,"未查到该商品！！！！！"),
    PRODUCT_STOCK_NOT_ENOUGH(1,"商品库存不足！！！！！"),
    ORDER_NOT_EXIST(2,"订单不存在！！！！！"),
    ORDER_DETAIL_NOT_EXIST(3,"订单详情不存在！！！！！"),
    ORDER_STATUS_ERROR(4,"订单状态不是预期的状态！！！！！"),
    ORDER_STATUS_UPDATE_ERROR(5,"订单状态修改失败！！！！！"),
    PAY_STATUS_ERROR(6,"支付状态不是预期的状态！！！！！"),
    CART_ERROR(7,"购物车不能为空！！！！！"),
    ORDER_OWNER_ERROR(8,"登录的微信号与订单所属的微信号不一致！！！！！"),
    WECHAT_MP_ERROR(9,"微信公众号方面错误")



    ;

    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    SellExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message=message;
    }
}
