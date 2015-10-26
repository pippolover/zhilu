package com.springapp.model;

import java.util.Date;

/**
 * 订单模型
 * Created by yimingwym on 15/10/26.
 */
public class OrderVO {
    private int id;
    private int vendorId;

    private int    num;
    private String productId;
    private Date   gmtCreate;
    private Date   gmtModified;

    private VenderVO vendor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public VenderVO getVendor() {
        return vendor;
    }

    public void setVendor(VenderVO vendor) {
        this.vendor = vendor;
    }
}
