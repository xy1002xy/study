package com.xy.repository;

import com.xy.domain.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by wxy on 2017/9/18.
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {


    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeLst);
}
