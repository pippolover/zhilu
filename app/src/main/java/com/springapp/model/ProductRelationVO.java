package com.springapp.model;

/**
 * Created by yimingwym on 15/10/22.
 */
public class ProductRelationVO {
    int id;

    String productId;
    String materialUniqueId;
    String accessoryUniqueId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getMaterialUniqueId() {
        return materialUniqueId;
    }

    public void setMaterialUniqueId(String materialUniqueId) {
        this.materialUniqueId = materialUniqueId;
    }

    public String getAccessoryUniqueId() {
        return accessoryUniqueId;
    }

    public void setAccessoryUniqueId(String accessoryUniqueId) {
        this.accessoryUniqueId = accessoryUniqueId;
    }
}
