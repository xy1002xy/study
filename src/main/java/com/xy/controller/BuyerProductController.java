package com.xy.controller;

import com.xy.domain.ProductCategory;
import com.xy.domain.ProductInfo;
import com.xy.service.CategoryService;
import com.xy.service.ProductService;
import com.xy.util.ResultVOUtil;
import com.xy.vo.ProductInfoVo;
import com.xy.vo.ProductVo;
import com.xy.vo.ResultVo;
import org.apache.ibatis.io.ResolverUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品
 * Created by wxy on 2017/9/23.
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {


    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;




    @GetMapping("/list")
    public ResultVo list(){


        // 查询所有的上架商品
        List<ProductInfo> productInfoList=productService.findUpAll();
        // 查询类目（一次性查询）
        //List<Integer> catagoryTypeList=new ArrayList<>();
        // 传统方法
//        for (ProductInfo productInfo:productInfoList){
//            catagoryTypeList.add(productInfo.getCategoryType());
//        }

        //精简方法（java8，lambda）
        List<Integer>catagoryTypeList=productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategory= categoryService.findByCategoryType(catagoryTypeList);
        // 数据拼接

       List<ProductVo>productVoList=new ArrayList<>();
        for (ProductCategory productCategoryList:productCategory ){
            ProductVo productVo=new ProductVo();
            productVo.setCategoryName(productCategoryList.getCategoryName());
            productVo.setCategoryType(productCategoryList.getCategoryType());
            List<ProductInfoVo>productInfoVoList=new ArrayList<>();
            for (ProductInfo productInfo:productInfoList){
                if (productInfo.getCategoryType().equals(productCategoryList.getCategoryType())){
                    ProductInfoVo productInfoVo=new ProductInfoVo();
                    productInfoVo.setProductId(productInfo.getProductId());
                    productInfoVo.setProductName(productInfo.getProductName());
                    productInfoVo.setProductPrice(productInfo.getProductPrice());
                    productInfoVo.setProductDescription(productInfo.getProductDescription());
                    productInfoVo.setProductIcon(productInfo.getProductIcon());
                    productInfoVoList.add(productInfoVo);
                }
            }
            productVo.setProductInfoVoList(productInfoVoList);
            productVoList.add(productVo);
        }
       return ResultVOUtil.success(productVoList);
    }
}
