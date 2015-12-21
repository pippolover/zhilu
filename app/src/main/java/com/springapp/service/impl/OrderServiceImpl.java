package com.springapp.service.impl;

import com.springapp.dao.OrderDAO;
import com.springapp.dao.VenderDAO;
import com.springapp.dateModel.OrderDO;
import com.springapp.dateModel.VenderDO;
import com.springapp.model.OrderVO;
import com.springapp.model.VenderVO;
import com.springapp.service.DeliveryGoodsService;
import com.springapp.service.OrderService;
import com.springapp.service.ProductionService;
import com.springapp.utils.ConverterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yimingwym on 15/10/26.
 */

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDAO orderDAO;

    @Autowired
    VenderDAO venderDAO;

    @Autowired
    ProductionService productionService;

    @Autowired
    DeliveryGoodsService deliveryGoodsService;

    @Override public OrderVO add(OrderVO orderVO) {
        OrderDO orderDO = ConverterUtils.covert(orderVO,OrderDO.class);
        orderDO.setGmtCreate(new Date());
        orderDAO.insert(orderDO);
        return ConverterUtils.covert(orderDO,OrderVO.class);
    }

    @Override public List<OrderVO> getOrderNums() {
        List<OrderDO> orderDOs=  orderDAO.getProductNum();
        List<OrderVO> orderVOs = ConverterUtils.convertList(orderDOs,OrderVO.class);
        return orderVOs;
    }

    @Override public List<OrderVO> getOrderNumByVendor(String productId) {
        List<OrderVO> orderVOs = new ArrayList<>();
        List<OrderDO> orderDOs = orderDAO.getProductNumByVendor(productId);
        for (OrderDO orderDO: orderDOs){
            OrderVO orderVO = ConverterUtils.covert(orderDO,OrderVO.class);
            VenderDO venderDO = venderDAO.get(orderDO.getVendorId());
            orderVO.setVendor(ConverterUtils.covert(venderDO,VenderVO.class));
            orderVO.setDeliveryNum(deliveryGoodsService.getDeliveryNumByVender(String.valueOf(venderDO.getId())));
            orderVOs.add(orderVO);
        }
        return orderVOs;
    }

    @Override public List<OrderVO> getOrderTransaction(String productId) {
        List<OrderVO> orderVOs = new ArrayList<>();
        List<OrderDO> orderDOs = orderDAO.getOrderTransaction(productId);
        for (OrderDO orderDO: orderDOs){
            OrderVO orderVO = ConverterUtils.covert(orderDO,OrderVO.class);
            VenderDO venderDO = venderDAO.get(orderDO.getVendorId());
            orderVO.setVendor(ConverterUtils.covert(venderDO,VenderVO.class));
            orderVOs.add(orderVO);
        }
        return orderVOs;
    }

    @Override public List<OrderVO> getOrderTransactionByVendor(String vendorId) {
        List<OrderDO> orderDOs  = orderDAO.getOrderTransactionByVendor(Integer.valueOf(vendorId));
        return ConverterUtils.convertList(orderDOs,OrderVO.class);
    }

    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public void setVenderDAO(VenderDAO venderDAO) {
        this.venderDAO = venderDAO;
    }
}
