package com.springapp.service;

import com.springapp.model.DeliveryInfoVO;

/**
 * 出库的service
 * Created by yimingwym on 15/12/21.
 */
public interface DeliveryGoodsService {
    /**
     * 出库
     * @return
     */
    public DeliveryInfoVO delivery(DeliveryInfoVO deliveryInfoVO);

    public int getDeliveryNumByProduct(String productId);

    public int getDeliveryNumByVender(String venderId);
}
