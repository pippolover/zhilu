package com.springapp.service.impl;

import com.springapp.dao.ProductInfoDAO;
import com.springapp.dateModel.ProductInfoDO;
import com.springapp.model.ProductInfoVO;
import com.springapp.service.ProductInfoService;
import com.springapp.utils.ConverterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yimingwym on 15/9/23.
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {
    @Autowired
    ProductInfoDAO productInfoDAO;
    @Override public ProductInfoVO insert(ProductInfoVO productInfoVO) {
        ProductInfoDO productInfoDO = ConverterUtils.covert(productInfoVO,ProductInfoDO.class);
        productInfoDAO.insertProductInfo(productInfoDO);
        return null;
    }

    @Override public ProductInfoVO get(String id) {
        ProductInfoDO productInfoDO = productInfoDAO.get(id);
        return ConverterUtils.covert(productInfoDO,ProductInfoVO.class);
    }

    public void setProductInfoDAO(ProductInfoDAO productInfoDAO) {
        this.productInfoDAO = productInfoDAO;
    }
}
