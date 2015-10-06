package com.springapp.service;

import com.springapp.model.ProductInfoVO;

import java.util.List;

/**
 * Created by yimingwym on 15/9/23.
 */
public interface ProductInfoService {
    public ProductInfoVO insert(ProductInfoVO productInfoVO);

    public ProductInfoVO get(String id);

    public List<ProductInfoVO> query(String query);
}
