package com.cdkj.service.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.service.ao.IServeTrainAO;
import com.cdkj.service.bo.IServeBO;
import com.cdkj.service.bo.IServeTrainBO;
import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.ServeTrain;
import com.cdkj.service.exception.BizException;

@Service
public class ServeTrainAOImpl implements IServeTrainAO {

    @Autowired
    private IServeBO serveBO;

    @Autowired
    private IServeTrainBO serveTrainBO;

    @Transactional
    @Override
    public String addServeTrain(ServeTrain data) {
        String code = serveBO.saveServe(data.getServe());
        data.setServeCode(code);
        serveTrainBO.saveServeTrain(data);
        return code;
    }

    @Transactional
    @Override
    public int editServeTrain(ServeTrain data) {
        if (!serveTrainBO.isServeTrainExist(data.getServeCode())) {
            throw new BizException("xn0000", "该编号不存在");
        }
        serveBO.refreshServe(data.getServe());
        return serveTrainBO.refreshServeTrain(data);
    }

    @Override
    public int dropServeTrain(String code) {
        if (!serveTrainBO.isServeTrainExist(code)) {
            throw new BizException("xn0000", "该编号不存在");
        }
        return serveTrainBO.removeServeTrain(code);
    }

    @Override
    public Paginable<ServeTrain> queryServeTrainPage(int start, int limit,
            ServeTrain condition) {
        return serveTrainBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<ServeTrain> queryServeTrainList(ServeTrain condition) {
        return serveTrainBO.queryServeTrainList(condition);
    }

    @Override
    public ServeTrain getServeTrain(String code) {
        return serveTrainBO.getServeTrain(code);
    }
}
