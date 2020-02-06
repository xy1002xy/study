package com.xy.DTO;

import lombok.Data;

/**
 * 购物车
 * Created by wxy on 2017/10/22.
 */
@Data
public class CartDTO {

    private String productId;//商品编号
    private Integer productQuantity;//商品数量

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
