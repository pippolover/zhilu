package com.springapp.model;

import java.util.Date;
import java.util.List;

/**
 * Created by yimingwym on 15/9/23.
 */
public class ProductInfoVO {
    //款号
    private String id;

    //批次(波段) 1位
    private String batch;
    //颜色
    private String color;
    //流水号
    private String sequence;
    //季度
    private String season;
    //品类
    private String category;
    //定量
    private String orderNum;

    private Double price;

    String accessorys;

    String materials;

    List<AccessoryVO> accessoryVOs;

    List<MaterialVO> materialVOs;

    private Date gmtCreate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAccessorys() {
        return accessorys;
    }

    public void setAccessorys(String accessorys) {
        this.accessorys = accessorys;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public List<AccessoryVO> getAccessoryVOs() {
        return accessoryVOs;
    }

    public void setAccessoryVOs(List<AccessoryVO> accessoryVOs) {
        this.accessoryVOs = accessoryVOs;
    }

    public List<MaterialVO> getMaterialVOs() {
        return materialVOs;
    }

    public void setMaterialVOs(List<MaterialVO> materialVOs) {
        this.materialVOs = materialVOs;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}
