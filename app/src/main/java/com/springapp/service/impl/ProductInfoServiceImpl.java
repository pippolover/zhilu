package com.springapp.service.impl;

import com.springapp.dao.ProductInfoDAO;
import com.springapp.dateModel.ProductInfoDO;
import com.springapp.model.ProductInfoVO;
import com.springapp.service.ProductInfoService;
import com.springapp.service.SequenceService;
import com.springapp.utils.ConverterUtils;
import com.springapp.utils.DateHelper;
import com.springapp.utils.ProductInfoGenerater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yimingwym on 15/9/23.
 */
@Service("productInfoService")
public class ProductInfoServiceImpl implements ProductInfoService {
    @Autowired
    ProductInfoDAO productInfoDAO;

    @Autowired
    SequenceService sequenceService;

    @Override public ProductInfoVO insert(ProductInfoVO productInfoVO) {
        String year = DateHelper.getCurrentYear();
        String sequeceName = year+productInfoVO.getSeason();
        String sequence = sequenceService.getSequenceValue(sequeceName);
        productInfoVO.setSequence(sequence);
        String id = ProductInfoGenerater.generateId(productInfoVO);
        productInfoVO.setId(id);
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
