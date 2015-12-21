package com.springapp.service.impl;

import com.springapp.dao.ProductionDAO;
import com.springapp.dateModel.ProductionDO;
import com.springapp.model.ProductionVO;
import com.springapp.service.ProductionService;
import com.springapp.utils.ConverterUtils;
import com.springapp.utils.ProductInfoGenerater;
import com.springapp.utils.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 入库的service，也就是生产的service
 * Created by yimingwym on 15/12/6.
 */
@Service
public class ProductionServiceImpl implements ProductionService {

    @Autowired
    private ProductionDAO productionDAO;

    @Override public ProductionVO add(ProductionVO productionVO) {
        productionVO.setGmtCreate(new Date());
        productionVO.setProductionTransaction(ProductInfoGenerater.genTransactionBytime());
        ProductionDO productionDO = ConverterUtils.covert(productionVO,ProductionDO.class);
        productionDAO.add(productionDO);
        productionVO.setId(productionDO.getId());
        return productionVO;
    }

    @Override public int getNumByProductId(String productId) {
        Integer num = productionDAO.getTotalNumByProduct(productId);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public void setProductionDAO(ProductionDAO productionDAO) {
        this.productionDAO = productionDAO;
    }

}
