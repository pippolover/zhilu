package com.springapp.service.impl;

import com.springapp.dao.SequenceDAO;
import com.springapp.service.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yimingwym on 15/10/6.
 */
@Service("sequenceService")
public class SequenceServiceImpl implements SequenceService {

    @Autowired
    private SequenceDAO sequenceDAO;

    @Override public String getSequenceValue(String name) {
        Integer current = sequenceDAO.getCurrent(name);
        if (current == null){
            sequenceDAO.init(name);
            return String.format("%1$03d",1);
        }
        sequenceDAO.lock(name);
        int next = current+1;
        sequenceDAO.updateCurrent(name);
        return  String.format("%1$03d",next);
    }

    public void setSequenceDAO(SequenceDAO sequenceDAO) {
        this.sequenceDAO = sequenceDAO;
    }
}
