package com.xy.enums;

import lombok.Getter;

/**
 * 商品状态
 * Created by wxy on 2017/9/23.
 */

@Getter
public enum PayStatusEnum {
    WAIT(0,"未支付"),
    SUCCESS(1,"支付成功"),
     CANCEL(9,"取消成功")

    ;

    private Integer code;
    private String message;


    PayStatusEnum(Integer code, String message) {
        this.code = code;
    }
}
