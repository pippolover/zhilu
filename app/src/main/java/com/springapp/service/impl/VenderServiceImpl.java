package com.springapp.service.impl;

import com.springapp.dao.VenderDAO;
import com.springapp.dateModel.VenderDO;
import com.springapp.model.VenderVO;
import com.springapp.service.VenderService;
import com.springapp.utils.ConverterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yimingwym on 15/10/23.
 */
@Service
public class VenderServiceImpl implements VenderService {
    @Autowired
    private VenderDAO venderDAO;

    @Override public VenderVO add(VenderVO venderVO) {
        VenderDO venderDO = ConverterUtils.covert(venderVO,VenderDO.class);
        venderDAO.insert(venderDO);
        return ConverterUtils.covert(venderDO,VenderVO.class);
    }

    @Override public Boolean update(VenderVO venderVO) {
        VenderDO venderDO = ConverterUtils.covert(venderVO,VenderDO.class);
        int affectRow = venderDAO.update(venderDO);
        return affectRow == 1;
    }

    @Override public VenderVO get(int id) {
        VenderDO venderDO = venderDAO.get(id);
        if (venderDO!= null) {
            return ConverterUtils.covert(venderDO,VenderVO.class);
        }
        return null;
    }

    @Override public List<VenderVO> queryAll() {
        List<VenderDO> venderDOs = venderDAO.queryAll();
        if (venderDOs!= null && venderDOs.size()>0){
            return ConverterUtils.convertList(venderDOs,VenderVO.class);
        }
        return null;
    }

    public void setVenderDAO(VenderDAO venderDAO) {
        this.venderDAO = venderDAO;
    }
}
