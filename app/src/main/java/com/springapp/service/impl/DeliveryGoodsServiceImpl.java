package com.springapp.service.impl;

import com.springapp.dao.DeliveryInfoDAO;
import com.springapp.dateModel.DeliveryInfoDO;
import com.springapp.model.DeliveryInfoVO;
import com.springapp.service.DeliveryGoodsService;
import com.springapp.utils.ConverterUtils;
import com.springapp.utils.ProductInfoGenerater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by yimingwym on 15/12/21.
 */
@Service
public class DeliveryGoodsServiceImpl implements DeliveryGoodsService {
    @Autowired
    DeliveryInfoDAO deliveryInfoDAO;
    @Override public DeliveryInfoVO delivery(DeliveryInfoVO deliveryInfoVO) {
        deliveryInfoVO.setDeliveryId(ProductInfoGenerater.genTransactionBytime());
        deliveryInfoVO.setGmtCreate(new Date());
        DeliveryInfoDO deliveryInfoDO = ConverterUtils.covert(deliveryInfoVO,DeliveryInfoDO.class);
        deliveryInfoDAO.addDeliveryInfo(deliveryInfoDO);
        deliveryInfoVO.setId(deliveryInfoDO.getId());
        return deliveryInfoVO;
    }

    @Override public int getDeliveryNumByVender(String venderId) {
        Integer num = deliveryInfoDAO.getTotalDeliveriedByVender(venderId);
        if ( num == null){
            return 0;
        }
        return num ;
    }

    @Override public int getDeliveryNumByProduct(String productId) {
        Integer num =deliveryInfoDAO.getTotalDeliveriedByProduct(productId);
        if ( num == null){
            return 0;
        }
        return num ;
    }

    public void setDeliveryInfoDAO(DeliveryInfoDAO deliveryInfoDAO) {
        this.deliveryInfoDAO = deliveryInfoDAO;
    }
}
