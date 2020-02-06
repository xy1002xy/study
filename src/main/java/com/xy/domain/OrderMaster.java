package com.xy.domain;

import com.xy.enums.OrderStatusEnum;
import com.xy.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by wxy on 2017/10/21.
 * 订单表
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {

    @Id
    private String orderId;//订单表主键
    private String buyerName;//买家姓名
    private String buyerPhone;//买家手机号码
    private String buyerAddress;//买家地址
    private String buyerOpenid;//买家微信号
    private BigDecimal orderAmount;//订单数量
    private Integer orderStatus= OrderStatusEnum.NEW.getCode();//订单状态
    private Integer payStatus= PayStatusEnum.WAIT.getCode();//支付状态
    private Date createTime;
    private Date updateTime;

    @Transient
    List<OrderDetail>orderDetailList;


}
