package com.cardpay.controller.datadictionary;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.util.datatable.DataTablePage;
import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.datadictionary.model.TDataDictionary;
import com.cardpay.mgt.datadictionary.service.TDataDictionaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 数据字典Controller
 *
 * @author yanwe
 */
@RestController
@RequestMapping("/api/dataDictionary")
@Api(value = "/api/dataDictionary", description = "数据字典")
public class DataDictionaryController extends BaseController<TDataDictionary> {

    @Autowired
    private TDataDictionaryService dataDictionaryService;

    /**
     * 获取数据字典分页数据
     *
     * @return 分页数据
     */
    @RequestMapping(value = "/pageList", method = RequestMethod.POST)
    @ApiOperation(value = "获取数据字典分页数据", notes = "获取数据字典分页数据", httpMethod = "GET")
    public DataTablePage pageList() {
        return dataTablePage();
    }


    /**
     * 添加数据字典接口
     *
     * @param dataDictionary 数据字典信息
     * @return 页面
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "添加数据字典接口", notes = "添加数据字典", httpMethod = "POST")
    public ResultTo add(@ApiParam("数据字典信息") @ModelAttribute TDataDictionary dataDictionary) {
        Integer count = dataDictionaryService.insert(dataDictionary);
        return count != 0 ? new ResultTo().setData(count) : new ResultTo(ResultEnum.SERVICE_ERROR);
    }

    /**
     * 删除数据字典接口
     *
     * @param dataId 数据字典id
     * @return 删除结果
     */
    @DeleteMapping("/{dataId}")
    public ResultTo delete(@PathVariable("dataId") Integer dataId) {
        Integer count = dataDictionaryService.deleteByPrimaryKey(dataId);
        return count !=0 ? new ResultTo().setData(count) : new ResultTo(ResultEnum.SERVICE_ERROR);
    }

    /**
     * 按id查询数据字典信息
     *
     * @param dataId 数据字典id
     * @return 页面和数据
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "前往更新数据字典接口", notes = "根据ID获取数据字典信息,前往更新数据字典", httpMethod = "GET")
    public ResultTo toUpdate(@PathVariable("id") Integer dataId) {
        TDataDictionary dataDictionary = dataDictionaryService.selectByPrimaryKey(dataId);
        return new ResultTo().setData(dataDictionary);
    }

    /**
     * 更新数据字典接口
     *
     * @param dataDictionary 数据字典信息
     * @return 数据库变记录
     */
    @RequestMapping(method = RequestMethod.PUT)
    @ApiOperation(value = "更新数据字典接口", notes = "根据ID更新数据字典信息", httpMethod = "PUT")
    public ResultTo update(@ModelAttribute TDataDictionary dataDictionary) {
        Integer count = dataDictionaryService.updateSelectiveByPrimaryKey(dataDictionary);
        return count != 0 ? new ResultTo().setData(count) : new ResultTo(ResultEnum.SERVICE_ERROR);
    }

}
