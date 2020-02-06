package com.xy.converter;

import com.xy.DTO.OrderDTO;
import com.xy.domain.OrderMaster;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wxy on 2017/10/22.
 */
public class OrderMaster2OrderDTOconvert {

    public static OrderDTO convert(OrderMaster orderMaster){

        OrderDTO orderDTO=new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){

        return orderMasterList.stream()
                .map(e-> convert(e))
                .collect(Collectors.toList());

    }
}
