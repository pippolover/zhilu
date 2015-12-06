package com.springapp.mvc.api;

import com.springapp.model.ProductionVO;
import com.springapp.service.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yimingwym on 15/12/6.
 */
@Controller
public class ProductionAPI {
    @Autowired
    ProductionService productionService;

    @RequestMapping(value = "/webapi/production",method = RequestMethod.POST)
    @ResponseBody
    public APIResult<ProductionVO> add(@RequestBody ProductionVO productionVO){
        return new APIResult<>(productionService.add(productionVO));
    }

    @RequestMapping(value = "/webapi/production/{productId}",method = RequestMethod.GET)
    @ResponseBody
    public APIResult<Integer> query(@PathVariable("productId")String productId){
        return new APIResult<>(productionService.getNumByProductId(productId));
    }
}
