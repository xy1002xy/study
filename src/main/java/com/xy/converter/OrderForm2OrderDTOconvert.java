package com.xy.converter;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.xy.DTO.OrderDTO;
import com.xy.Exception.SellException;
import com.xy.domain.OrderDetail;
import com.xy.domain.OrderMaster;
import com.xy.enums.SellExceptionEnum;
import com.xy.form.OrderForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wxy on 2017/10/22.
 */
@Slf4j
public class OrderForm2OrderDTOconvert {

    public static OrderDTO convert(OrderForm orderForm){

        Gson gson=new Gson();

        OrderDTO orderDTO=new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        orderDTO.setBuyerAddress(orderForm.getAddress());

        //将字符串转换成集合类型
        List<OrderDetail>orderDetailList=new ArrayList<>();


        try {
            orderDetailList=gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>(){}.getType());
        } catch (JsonSyntaxException e) {
            log.error("【对象转换】==失败 String={}",orderForm.getItems());
            throw new SellException(SellExceptionEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}
