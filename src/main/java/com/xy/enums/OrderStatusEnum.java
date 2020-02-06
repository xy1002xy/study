package com.xy.enums;

import lombok.Getter;

/**
 * 商品状态
 * Created by wxy on 2017/9/23.
 */

@Getter
public enum OrderStatusEnum {
    NEW(0,"未下单"),
    FINISH(1,"订单完成"),
    CANCEL(9,"订单取消")


    ;

    private Integer code;
    private String message;



    OrderStatusEnum(Integer code, String message) {
        this.code = code;
    }
}
