package com.xy.repository;

import com.xy.domain.OrderMaster;
import com.xy.domain.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by wxy on 2017/9/18.
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {

    Page<OrderMaster>findByBuyerOpenid(String buyerOpenid, Pageable pageable);

    }
