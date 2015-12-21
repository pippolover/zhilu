package com.springapp.mvc.api;

import com.springapp.model.DeliveryInfoVO;
import com.springapp.service.DeliveryGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yimingwym on 15/12/21.
 */
@Controller
public class DeliveryAPI {
    @Autowired
    DeliveryGoodsService deliveryGoodsService;

    @RequestMapping(value = "/webapi/delivery",method = RequestMethod.POST)
    @ResponseBody
    public APIResult<DeliveryInfoVO> add(@RequestBody DeliveryInfoVO deliveryInfoVO){
        return new APIResult<>(deliveryGoodsService.delivery(deliveryInfoVO));
    }

    @RequestMapping(value = "/webapi/delivery/{productId}",method = RequestMethod.GET)
    @ResponseBody
    public APIResult<Integer> getDeliveryInfoByProduct(@PathVariable("productId") String productId){
        return new APIResult<>(deliveryGoodsService.getDeliveryNumByProduct(productId));
    }
}
