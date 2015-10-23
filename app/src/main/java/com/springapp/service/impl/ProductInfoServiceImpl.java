package com.springapp.service.impl;

import com.springapp.dao.AccessoryDAO;
import com.springapp.dao.MaterialDAO;
import com.springapp.dao.ProductInfoDAO;
import com.springapp.dao.ProductRelationDAO;
import com.springapp.dateModel.AccessoryDO;
import com.springapp.dateModel.MaterialDO;
import com.springapp.dateModel.ProductInfoDO;
import com.springapp.dateModel.ProductRelationDO;
import com.springapp.model.AccessoryVO;
import com.springapp.model.MaterialVO;
import com.springapp.model.ProductInfoVO;
import com.springapp.service.ProductInfoService;
import com.springapp.service.SequenceService;
import com.springapp.utils.ConverterUtils;
import com.springapp.utils.DateHelper;
import com.springapp.utils.ProductInfoGenerater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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
    MaterialDAO materialDAO;

    @Autowired
    ProductRelationDAO productRelationDAO;

    @Autowired
    SequenceService sequenceService;

    @Override public ProductInfoVO insert(ProductInfoVO productInfoVO) {
        String year = DateHelper.getCurrentYear();
        String sequeceName = year+productInfoVO.getSeason();
        String sequence = sequenceService.getSequenceValue(sequeceName);
        productInfoVO.setSequence(sequence);
        String id = ProductInfoGenerater.generateId(productInfoVO);
        productInfoVO.setId(id);
        productInfoVO.setGmtCreate(new Date());
        ProductInfoDO productInfoDO = ConverterUtils.covert(productInfoVO,ProductInfoDO.class);
        productInfoDAO.insertProductInfo(productInfoDO);

        //添加面料
        if (productInfoVO.getMaterials()!= null) {
            for (String maId: productInfoVO.getMaterials().split(",")) {
                productRelationDAO.addProductMaterial(id,maId);
            }
        }
        if (productInfoVO.getAccessorys()!= null){
            for (String accId: productInfoVO.getAccessorys().split(",")) {
                productRelationDAO.addProductAccessory(id, accId);
            }
        }

        //添加辅料
        return productInfoVO;
    }

    @Override public ProductInfoVO get(String id) {
        ProductInfoDO productInfoDO = productInfoDAO.get(id);
        List<ProductRelationDO> productRelationDOs = productRelationDAO.query(id);
        List<MaterialVO> materialVOs = new ArrayList<>();
        List<AccessoryVO> accessoryVOs = new ArrayList<>();
        for (ProductRelationDO productRelationDO : productRelationDOs){
            if (productRelationDO.getAccessoryUniqueId() != null){
                accessoryVOs.add(ConverterUtils.covert(accessoryDAO.get(productRelationDO.getAccessoryUniqueId()),AccessoryVO.class));
            }
            if (productRelationDO.getMaterialUniqueId() != null){
                materialVOs.add(ConverterUtils.covert(materialDAO.get(productRelationDO.getMaterialUniqueId()),MaterialVO.class));
            }
        }
        ProductInfoVO productInfoVO = ConverterUtils.covert(productInfoDO, ProductInfoVO.class);
        productInfoVO.setAccessoryVOs(accessoryVOs);
        productInfoVO.setMaterialVOs(materialVOs);
        return productInfoVO;
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

    @Override public List<ProductInfoVO> queryAll() {
        List<ProductInfoDO> productInfoDOs = productInfoDAO.queryAll();
        return ConverterUtils.convertList(productInfoDOs,ProductInfoVO.class);
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

    @Override public MaterialVO addMaterial(MaterialVO materialVO) {
        MaterialDO materialDO = ConverterUtils.covert(materialVO,MaterialDO.class);
        materialDAO.insert(materialDO);
        return ConverterUtils.covert(materialDO,MaterialVO.class);
    }

    @Override public Boolean checkMaterialUniqueIdValid(List<String> ids) {
        StringBuffer stringBuffer = new StringBuffer();
        Boolean trigger = true;
        for (String uniqueId: ids){
            if (null == materialDAO.get(uniqueId)){
                trigger = false;
                stringBuffer.append(uniqueId);
                stringBuffer.append(";");
            }
        }
        if (!trigger){
            stringBuffer.append("不存在");
            throw  new RuntimeException(stringBuffer.toString());
        }
        return Boolean.TRUE;
    }

    @Override public Boolean checkAccessoryUniqueIdValid(List<String> ids) {
        StringBuffer stringBuffer = new StringBuffer();
        Boolean trigger = true;
        for(String uniqueId: ids){
            if (null == accessoryDAO.get(uniqueId)){
                trigger = false;
                stringBuffer.append(uniqueId);
                stringBuffer.append(";");
            }
        }
        if (!trigger){
            stringBuffer.append("不存在");
            throw  new RuntimeException(stringBuffer.toString());
        }
        return Boolean.TRUE;
    }

    @Override public List<AccessoryVO> queryAllAccessory() {
        List<AccessoryDO> accessoryDOs = new ArrayList<>();
        return ConverterUtils.convertList(accessoryDOs, AccessoryVO.class);
    }

    @Override public List<MaterialVO> queryAllMaterial() {
        List<MaterialDO> materialDOs = new ArrayList<>();
        return ConverterUtils.convertList(materialDOs,MaterialVO.class);
    }

    public void setProductInfoDAO(ProductInfoDAO productInfoDAO) {
        this.productInfoDAO = productInfoDAO;
    }

    public void setAccessoryDAO(AccessoryDAO accessoryDAO) {
        this.accessoryDAO = accessoryDAO;
    }

    public void setProductRelationDAO(ProductRelationDAO productRelationDAO) {
        this.productRelationDAO = productRelationDAO;
    }

    public void setMaterialDAO(MaterialDAO materialDAO) {
        this.materialDAO = materialDAO;
    }
}
