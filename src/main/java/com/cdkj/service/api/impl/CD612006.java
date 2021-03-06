package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IServeArtAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.api.converter.ServeConverter;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.domain.ServeArt;
import com.cdkj.service.dto.req.CD612006Req;
import com.cdkj.service.dto.res.PKCodeRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/** 
 * 新增美工外包
 * @author: zuixian 
 * @since: 2016年10月7日 下午4:06:14 
 * @history:
 */
public class CD612006 extends AProcessor {

    private IServeArtAO serveArtAO = SpringContextHolder
        .getBean(IServeArtAO.class);

    private CD612006Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        ServeArt data = ServeConverter.converter(req);
        String code = serveArtAO.addServeArt(data);
        return new PKCodeRes(code);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, CD612006Req.class);
        StringValidater.validateBlank(req.getName(), req.getCompanyCode(),
            req.getQuoteMin(), req.getQuoteMax(), req.getQualityCode(),
            req.getDesignNum(), req.getSclm(), req.getHomeDays(),
            req.getHomePrice(), req.getDetailDays(), req.getDetailPrice(),
            req.getBannerDays(), req.getBannerPrice(), req.getAllDays(),
            req.getAllPrice(), req.getWorks(), req.getPublisher());
    }
}
