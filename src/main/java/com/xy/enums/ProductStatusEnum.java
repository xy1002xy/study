package com.xy.enums;

import lombok.Getter;

/**
 * 商品状态
 * Created by wxy on 2017/9/23.
 */

@Getter
public enum  ProductStatusEnum {
    up(0,"在架"),
    down(1,"下架")

    ;

    private Integer code;
    private String message;

    ProductStatusEnum(Integer code,String message) {
        this.code = code;
    }
}
