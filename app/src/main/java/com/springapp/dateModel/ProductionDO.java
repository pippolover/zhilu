package com.springapp.dateModel;

import java.util.Date;

/**
 * Created by yimingwym on 15/12/6.
 */
public class ProductionDO {
    private int id;
    //入库流水号
    private String productionTransaction;
    //入库数量
    private int num;
    private Date gmtCreate;
    private String productId;
    private String memo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductionTransaction() {
        return productionTransaction;
    }

    public void setProductionTransaction(String productionTransaction) {
        this.productionTransaction = productionTransaction;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
