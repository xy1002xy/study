package com.xy.repository;

import com.xy.domain.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by wxy on 2017/9/18.
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {

    public List<OrderDetail>findByOrderId(String orderId);


    }
