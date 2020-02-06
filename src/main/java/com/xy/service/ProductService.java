package com.xy.service;

import com.xy.DTO.CartDTO;
import com.xy.domain.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by wxy on 2017/9/19.
 */
public interface ProductService {

    ProductInfo findOne(String productId);

    /**
     * 查询所有的在架商品列表
     * @return
     */
    List<ProductInfo>findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo ProductInfo);

    //加库存
    void increaseStock(List<CartDTO>cartDTOList);

    //减库存
    void decreaseStock(List<CartDTO>cartDTOList);

}
