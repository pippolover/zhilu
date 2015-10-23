package com.springapp.service;

import com.springapp.model.AccessoryVO;
import com.springapp.model.MaterialVO;
import com.springapp.model.ProductInfoVO;

import java.util.List;

/**
 * Created by yimingwym on 15/9/23.
 */
public interface ProductInfoService {
    public ProductInfoVO insert(ProductInfoVO productInfoVO);

    public ProductInfoVO get(String id);

    public List<ProductInfoVO> query(String query);

    public List<ProductInfoVO> queryAll();

    public AccessoryVO addAccessory(AccessoryVO accessoryVO);

    public List<AccessoryVO> getAccessory(String productId);

    public MaterialVO addMaterial(MaterialVO materialVO);

    public Boolean checkMaterialUniqueIdValid(List<String> ids);

    public Boolean checkAccessoryUniqueIdValid(List<String> ids);

    /**
     * 查询所有的辅料
     * @return
     */
    public List<AccessoryVO> queryAllAccessory();

    /**
     * 查询所有的面料
     * @return
     */
    public List<MaterialVO> queryAllMaterial();
}
