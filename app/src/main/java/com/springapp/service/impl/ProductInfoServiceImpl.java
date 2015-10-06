package com.springapp.service.impl;

import com.springapp.dao.AccessoryDAO;
import com.springapp.dao.ProductInfoDAO;
import com.springapp.dateModel.AccessoryDO;
import com.springapp.dateModel.ProductInfoDO;
import com.springapp.model.AccessoryVO;
import com.springapp.model.ProductInfoVO;
import com.springapp.service.ProductInfoService;
import com.springapp.service.SequenceService;
import com.springapp.utils.ConverterUtils;
import com.springapp.utils.DateHelper;
import com.springapp.utils.ProductInfoGenerater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yimingwym on 15/9/23.
 */
@Service("productInfoService")
public class ProductInfoServiceImpl implements ProductInfoService {
    @Autowired
    ProductInfoDAO productInfoDAO;

    @Autowired
    AccessoryDAO accessoryDAO;

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

    @Override public List<ProductInfoVO> query(String query) {
        List<ProductInfoVO> result = new ArrayList<>();
        List<ProductInfoDO> productInfoDOs = productInfoDAO.query(query);
        for (ProductInfoDO productInfoDO : productInfoDOs){
            if (productInfoDO != null){
                result.add(ConverterUtils.covert(productInfoDO,ProductInfoVO.class));
            }
        }
        return result;
    }

    @Override public AccessoryVO addAccessory(AccessoryVO accessoryVO) {
        AccessoryDO accessoryDO = ConverterUtils.covert(accessoryVO,AccessoryDO.class);
        accessoryDAO.insert(accessoryDO);
        return accessoryVO;
    }

    @Override public List<AccessoryVO> getAccessory(String productId) {
        List<AccessoryDO> accessoryDOs = accessoryDAO.getByProduct(productId);
        return ConverterUtils.convertList(accessoryDOs,AccessoryVO.class);
    }

    public void setProductInfoDAO(ProductInfoDAO productInfoDAO) {
        this.productInfoDAO = productInfoDAO;
    }

    public void setAccessoryDAO(AccessoryDAO accessoryDAO) {
        this.accessoryDAO = accessoryDAO;
    }
}
