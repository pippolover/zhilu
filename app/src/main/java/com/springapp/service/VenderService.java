package com.springapp.service;

import com.springapp.model.VenderVO;

import java.util.List;

/**
 * Created by yimingwym on 15/10/23.
 */
public interface VenderService {
    public VenderVO add(VenderVO venderVO);

    public Boolean update(VenderVO venderVO);

    public VenderVO get(int id);

    public List<VenderVO> queryAll();
}
