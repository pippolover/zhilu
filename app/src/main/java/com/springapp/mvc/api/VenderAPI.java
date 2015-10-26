package com.springapp.mvc.api;

import com.springapp.model.VenderVO;
import com.springapp.mvc.APIExceptionHandler;
import com.springapp.service.VenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by yimingwym on 15/10/23.
 */
@Controller
public class VenderAPI extends APIExceptionHandler {

    @Autowired
    VenderService venderService;

    @RequestMapping(value = "/webapi/vendor",method = RequestMethod.POST)
    @ResponseBody
    public APIResult<VenderVO> add(@RequestBody VenderVO venderVO){
        venderService.add(venderVO);
        return new APIResult<>(venderVO);
    }

    @RequestMapping(value = "/webapi/vendor",method = RequestMethod.PUT)
    @ResponseBody
    public APIResult<Boolean> update(@RequestBody VenderVO venderVO){
        Boolean result = venderService.update(venderVO);
        return  new APIResult<>(result);
    }

    @RequestMapping(value = "/webapi/vendor/all",method = RequestMethod.GET)
    @ResponseBody
    public APIResult<List<VenderVO>> queryAll(){
        return  new APIResult<>(venderService.queryAll());
    }

}
