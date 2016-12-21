package com.cardpay.controller.datadictionary;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.datadictionary.model.TDataDictionary;
import com.cardpay.mgt.datadictionary.service.TDataDictionaryService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 数据字典Controller
 *
 * @author yanwe 2016/12/21 14:10
 */
@Controller
@RequestMapping("/dataDictionary")
public class DataDictionaryController extends BaseController<TDataDictionary,Integer>{

    @Autowired
    private TDataDictionaryService dataDictionaryService;

    @ResponseBody
    @RequestMapping(value = "/testPageList",method = RequestMethod.GET)
    public ResultTo pageList(Integer page,Integer size){
        TDataDictionary dataDictionary = new TDataDictionary();
        dataDictionary.setDataType("type1");
        List<TDataDictionary> tDataDictionaries = dataDictionaryService.pageList(dataDictionary, page, size);
        PageInfo pageInfo = new PageInfo(tDataDictionaries);
        ResultTo resultTo = new ResultTo();
        resultTo.setDataMap("data",tDataDictionaries).setDataMap("total",pageInfo.getTotal());
        return resultTo;
    }
}
