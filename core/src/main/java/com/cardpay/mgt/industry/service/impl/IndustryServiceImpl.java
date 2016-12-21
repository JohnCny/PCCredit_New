package com.cardpay.mgt.industry.service.impl;

import com.cardpay.basic.base.model.SelectModel;
import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.mgt.industry.dao.TIndustryMapper;
import com.cardpay.mgt.industry.model.po.TIndustry;
import com.cardpay.mgt.industry.service.IndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 行业信息实现类
 * @author yanweichen
 */
@Service
public class IndustryServiceImpl extends BaseServiceImpl<TIndustry> implements IndustryService {
    @Autowired
    private TIndustryMapper industryMapper;

    @Override
    public Object getIndustryInfo(){
        List<SelectModel> selects = new ArrayList<>();

        List<TIndustry> industries = industryMapper.selectAll();
        for (TIndustry value : industries){
            SelectModel selectModel=new SelectModel();
            selectModel.setId(value.getId());
            selectModel.setValue(value.getIndustryName());
            selects.add(selectModel);
        }
        return selects;
    }
}
