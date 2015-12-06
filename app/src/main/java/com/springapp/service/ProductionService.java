package com.springapp.service;

import com.springapp.model.ProductionVO;

/**
 * Created by yimingwym on 15/12/6.
 */
public interface ProductionService {
    /**
     * 添加入库信息
     * @param productionVO
     * @return
     */
    public ProductionVO add(ProductionVO productionVO);

    /**
     * 获得每个款式的入库总和
     * @param productId
     * @return
     */
    public int getNumByProductId(String productId);
}
