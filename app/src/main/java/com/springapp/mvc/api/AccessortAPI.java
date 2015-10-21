package com.springapp.mvc.api;

import com.springapp.model.AccessoryVO;
import com.springapp.mvc.APIExceptionHandler;
import com.springapp.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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
    @RequestMapping(value = "/webapi/accessory",method = RequestMethod.POST)
    @ResponseBody
    public APIResult<AccessoryVO> addAccessory(@RequestBody AccessoryVO accessoryVO){
        productInfoService.addAccessory(accessoryVO);
        return new APIResult<AccessoryVO>(accessoryVO);
    }

    /**
     * 查询某个款式的辅料
     * @param productId
     * @return
     */
    @RequestMapping(value = "/webapi/accessory/{accessoryId}",method = RequestMethod.GET)
    @ResponseBody
    public APIResult<List<AccessoryVO>> getAccessorysByProduct(@PathVariable("accessoryId") String accessoryId){
        List<AccessoryVO> accessoryVOs = productInfoService.getAccessory(accessoryId);
        return new APIResult<List<AccessoryVO>>(accessoryVOs);
    }

    @RequestMapping(value = "/webapi/accessory/isValid",method = RequestMethod.GET)
    @ResponseBody
    public APIResult<Boolean> checkUniqueIds(String idString){
        List<String> ids = Arrays.asList(idString.split(","));
        APIResult<Boolean> apiResult = new APIResult<>();
        try {
            apiResult.setSuccess(true);
            apiResult.setResult(productInfoService.checkAccessoryUniqueIdValid(ids));
        }catch(Exception e){
            apiResult.setSuccess(false);
            apiResult.setErrorMessage(e.getMessage());
        }
        return apiResult;
    }
}
