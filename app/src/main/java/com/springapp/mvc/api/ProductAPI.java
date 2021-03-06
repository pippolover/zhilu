package com.springapp.mvc.api;

import com.springapp.model.ProductInfoVO;
import com.springapp.mvc.APIExceptionHandler;
import com.springapp.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by yimingwym on 15/9/23.
 */
@Controller
public class ProductAPI extends APIExceptionHandler {

    @Autowired
    ProductInfoService productInfoService;

    /**
     * 添加款式
     * @param httpServletRequest
     * @param productInfoVO : batch, color,season,category,orderNum, price 必填
     * @return
     */
    @RequestMapping(value = "/webapi/product",method = RequestMethod.POST)
    @ResponseBody
    public APIResult<Boolean> insert(HttpServletRequest httpServletRequest,@RequestBody ProductInfoVO productInfoVO){
        productInfoService.insert(productInfoVO);
        return new APIResult<Boolean>(true);
    }

    @RequestMapping(value = "/webapi/product/{id}",method = RequestMethod.GET)
    @ResponseBody
    public APIResult<ProductInfoVO> get(@PathVariable("id") String id){
        ProductInfoVO productInfoVO = productInfoService.get(id);
        return new APIResult<ProductInfoVO>(productInfoVO);
    }

    @RequestMapping(value = "/webapi/product/all",method = RequestMethod.GET)
    @ResponseBody
    public APIResult<List<ProductInfoVO>> queryAll(){
        List<ProductInfoVO> productInfoVOs = productInfoService.queryAll();
        return new APIResult<List<ProductInfoVO>>(productInfoVOs);
    }

    /**
     * 模糊查询
     * @param query
     * @return
     */
    @RequestMapping(value = "/webapi/product/fuzzy",method = RequestMethod.GET)
    @ResponseBody
    public APIResult<List<ProductInfoVO>> query(String query){
        List<ProductInfoVO> productInfoVOs = productInfoService.query(query);
        return new APIResult<List<ProductInfoVO>>(productInfoVOs);
    }
}
