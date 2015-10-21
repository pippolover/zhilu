package com.springapp.mvc.api;

import com.springapp.model.MaterialVO;
import com.springapp.mvc.APIExceptionHandler;
import com.springapp.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yimingwym on 15/10/21.
 */
@Controller
public class MaterialAPI extends APIExceptionHandler{
    @Autowired
    ProductInfoService productInfoService;

    @RequestMapping(value = "/webapi/material",method = RequestMethod.POST)
    @ResponseBody
    public APIResult<MaterialVO> addMaterial(@RequestBody MaterialVO materialVO){
        MaterialVO result = productInfoService.addMaterial(materialVO);
        return new APIResult<>(result);
    }

    @RequestMapping(value = "/webapi/material/isValid",method = RequestMethod.GET)
    @ResponseBody
    public APIResult<Boolean> checkUniqueIds(String idString){
        List<String> ids = Arrays.asList(idString.split(","));
        APIResult<Boolean> apiResult = new APIResult<>();
        try {
            apiResult.setSuccess(true);
            apiResult.setResult(productInfoService.checkMaterialUniqueIdValid(ids));
        }catch(Exception e){
            apiResult.setSuccess(false);
            apiResult.setErrorMessage(e.getMessage());
        }
        return apiResult;
    }
}
