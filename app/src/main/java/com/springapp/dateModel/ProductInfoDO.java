package com.springapp.dateModel;

/**
 * Created by yimingwym on 15/9/23.
 */
public class ProductInfoDO {
    //款号
    private String id;

    //批次
    private String batch;
    //颜色
    private String color;
    //序号
    private String sequence;
    //季度
    private String season;
    //定量
    private String orderNum;

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
}
