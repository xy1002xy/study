package com.xy.vo;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by wxy on 2017/9/23.
 */
@Data
public class ProductInfoVo {

    @JsonProperty("id")
    private String productId;//主键id
    @JsonProperty("name")
    private String productName;//商品名
    @JsonProperty("price")
    private BigDecimal productPrice;//商品价格
    @JsonProperty("description")
    private String productDescription;//商品描述
    @JsonProperty("icon")
    private String productIcon;//商品图片  小图


}
