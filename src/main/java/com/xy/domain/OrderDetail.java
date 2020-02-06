package com.xy.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by wxy on 2017/10/21.
 * 订单详情表
 */
@Entity
@Data
public class OrderDetail {
    @Id
    private String detailId;//订单详情表主键
    private String orderId;//订单主键
    private String productId;//商品号
    private String productName;//商品名称
    private BigDecimal productPrice;//订单价格
    private Integer productQuantity;//商品数量
    private String productIcon;//商品小图


}
