package com.xy.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by wxy on 2017/9/18.
 * 商品
 */
@Entity
@Data
public class ProductInfo {

    @Id
    private String productId;//主键id
    private String productName;//商品名
    private BigDecimal productPrice;//商品价格
    private Integer productStock;//库存
    private String productDescription;//商品描述
    private String productIcon;//商品图片  小图
    private Integer productStatus;//商品状态 0正常 1下架
    private Integer categoryType;//类目编号


}
