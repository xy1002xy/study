package com.xy.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by wxy on 2017/10/24.
 */
@Data
public class OrderForm {

    @NotEmpty(message = "姓名不可为空")
    private String name;//买家姓名
    @NotEmpty(message = "手机号码不可为空")
    private String phone;//买家手机号码
    @NotEmpty(message = "地址不可为空")
    private String address;//买家地址
    @NotEmpty(message = "微信号不可为空")
    private String openid;//买家微信号
    @NotEmpty(message = "购物车不可为空")
    private String items;//购物车
}
