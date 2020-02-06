package com.xy.service;

import com.xy.DTO.CartDTO;
import com.xy.Exception.SellException;
import com.xy.domain.ProductInfo;
import com.xy.enums.ProductStatusEnum;
import com.xy.enums.SellExceptionEnum;
import com.xy.repository.ProductInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by wxy on 2017/9/19.
 */
@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;


    @Override
    public ProductInfo findOne(String productId) {
        return productInfoRepository.findOne(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.up.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoRepository.findAll(pageable);
    }


    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoRepository.save(productInfo);
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO:cartDTOList){
            ProductInfo productInfo=productInfoRepository.findOne(cartDTO.getProductId());
            if (productInfo==null){
                throw new SellException(SellExceptionEnum.PRODUCT_NO_EXIST);
            }
            Integer count=productInfo.getProductStock()+cartDTO.getProductQuantity();
            productInfo.setProductStock(count);
            productInfoRepository.save(productInfo);
        }


    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO:cartDTOList){
            ProductInfo productInfo=productInfoRepository.findOne(cartDTO.getProductId());
            if (productInfo==null){
                throw new SellException(SellExceptionEnum.PRODUCT_NO_EXIST);
            }
            Integer count=productInfo.getProductStock()-cartDTO.getProductQuantity();//当前库存与订单数量相比较
            if (count<0){
                throw new SellException(SellExceptionEnum.PRODUCT_STOCK_NOT_ENOUGH);
            }
            productInfo.setProductStock(count);
            productInfoRepository.save(productInfo);
        }


    }
}
