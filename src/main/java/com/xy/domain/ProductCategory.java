package com.xy.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by wxy on 2017/9/18.
 */
@Entity
@Data
public class ProductCategory {

    @Id
    @GeneratedValue
    private Integer categoryId;//主键id
    private String categoryName;//类目名字
    private Integer categoryType;//类目编号


}
