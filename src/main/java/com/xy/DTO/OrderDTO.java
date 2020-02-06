package com.xy.DTO;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.xy.domain.OrderDetail;
import com.xy.enums.OrderStatusEnum;
import com.xy.enums.PayStatusEnum;
import com.xy.util.serializer.Date2LongSerializer;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by wxy on 2017/10/21.
 */
@Data
@DynamicUpdate
public class OrderDTO {

    private String orderId;//订单表主键
    private String buyerName;//买家姓名
    private String buyerPhone;//买家手机号码
    private String buyerAddress;//买家地址
    private String buyerOpenid;//买家微信号
    private BigDecimal orderAmount;//订单数量
    private Integer orderStatus= OrderStatusEnum.NEW.getCode();//订单状态
    private Integer payStatus= PayStatusEnum.WAIT.getCode();//支付状态
    List<OrderDetail> orderDetailList;
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    public OrderDTO() {

    }
}
