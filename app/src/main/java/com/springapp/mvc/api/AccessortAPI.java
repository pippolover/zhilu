package com.springapp.mvc.api;

import com.springapp.model.AccessoryVO;
import com.springapp.mvc.APIExceptionHandler;
import com.springapp.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by yimingwym on 15/10/6.
 */
@Controller
public class AccessortAPI extends APIExceptionHandler{
    @Autowired
    ProductInfoService productInfoService;

    /**
     * 给某个款式添加辅料信息
     * @param productId
     * @param accessoryVO
     * @return
     */
    @RequestMapping(value = "/webapi/product/{productId}/accessory",method = RequestMethod.POST)
    @ResponseBody
    public APIResult<AccessoryVO> addAccessory(@PathVariable String productId,@RequestBody AccessoryVO accessoryVO){
        accessoryVO.setProductId(productId);
        productInfoService.addAccessory(accessoryVO);
        return new APIResult<AccessoryVO>(accessoryVO);
    }

    /**
     * 查询某个款式的辅料
     * @param productId
     * @return
     */
    @RequestMapping(value = "/webapi/product/{productId}/accessory",method = RequestMethod.GET)
    @ResponseBody
    public APIResult<List<AccessoryVO>> getAccessorysByProduct(@PathVariable("productId") String productId){
        List<AccessoryVO> accessoryVOs = productInfoService.getAccessory(productId);
        return new APIResult<List<AccessoryVO>>(accessoryVOs);
    }
}
