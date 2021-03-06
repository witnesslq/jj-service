package com.cdkj.service.bo;

import java.util.List;

import com.cdkj.service.bo.base.IPaginableBO;
import com.cdkj.service.domain.Demand;

/**
 * @author: xieyj 
 * @since: 2016年10月7日 下午5:07:54 
 * @history:
 */
public interface IDemandBO extends IPaginableBO<Demand> {

    public boolean isDemandExist(String code);

    public String saveDemand(Demand data);

    public int removeDemand(String code);

    public int refreshDemand(Demand data);

    public int refreshDemandStatus(String code, String dealer, String dealNote);

    public List<Demand> queryDemandList(Demand condition);

    public Demand getDemand(String code);

}
