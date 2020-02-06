package com.xy.service;

import com.xy.domain.ProductCategory;

import java.util.List;

/**
 * Created by wxy on 2017/9/19.
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);
    List<ProductCategory>findAll();
    List<ProductCategory>findByCategoryType(List<Integer> categoryTypeLst);
    ProductCategory save(ProductCategory productCategory);

}
