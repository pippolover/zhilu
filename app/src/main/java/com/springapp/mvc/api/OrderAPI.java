package com.springapp.mvc.api;

import com.springapp.model.OrderVO;
import com.springapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by yimingwym on 15/10/26.
 */
@Controller
public class OrderAPI {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/webapi/order",method = RequestMethod.POST)
    @ResponseBody
    public APIResult<OrderVO> add(@RequestBody OrderVO orderVO){
        return new APIResult<>(orderService.add(orderVO));
    }

    @RequestMapping(value = "/webapi/order/all",method = RequestMethod.GET)
    @ResponseBody
    public APIResult<List<OrderVO>> getOrderNum(){
        return new APIResult<>(orderService.getOrderNums());
    }

    @RequestMapping(value = "/webapi/order",method = RequestMethod.GET)
    @ResponseBody
    public APIResult<List<OrderVO>> getOrderNumByVendor(String productId){
        return new APIResult<>(orderService.getOrderNumByVendor(productId));
    }

    @RequestMapping(value = "/webapi/order/transaction",method = RequestMethod.GET)
    @ResponseBody
    public APIResult<List<OrderVO>> getOrderTransaction(String productId){
        return new APIResult<>(orderService.getOrderTransaction(productId));
    }
}
