package com.springapp.service;

import com.springapp.model.OrderVO;

import java.util.List;

/**
 * Created by yimingwym on 15/10/26.
 */
public interface OrderService {
    public OrderVO add(OrderVO orderVO);

    /**
     * 获得每个款式对应的总的订单量
     * @return
     */
    public List<OrderVO> getOrderNums();

    /**
     * 根据款号获得每个订货商对应的订单量
     * @param productId
     * @return
     */
    public List<OrderVO> getOrderNumByVendor(String productId);

    /**
     * 获得每个款式的订单流水
     * @param productId
     * @return
     */
    public List<OrderVO> getOrderTransaction(String productId);

    /**
     * 获得每个订货商的流水
     * @param vendorId
     * @return
     */
    public List<OrderVO> getOrderTransactionByVendor(String vendorId);
}
