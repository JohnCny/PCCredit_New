package com.cardpay.controller.system;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.annotation.SystemControllerLog;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.basic.util.datatable.DataTablePage;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.system.model.TSysParameter;
import com.cardpay.mgt.system.service.TSysParameterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 系统参数配置Controller
 *
 * @author chenkai
 */
@RestController
@RequestMapping("/api/system")
@Api(value = "/api/system", description = "系统参数配置")
public class SysParameterController extends BaseController<TSysParameter> {
    @Autowired
    private TSysParameterService tSysParameterService;

    @Autowired
    private static LogTemplate logger;

    /**
     * 根据id查询系统配置参数信息
     *
     * @param id 主键
     * @return 编辑系统参数配置页面
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据id查询系统配置参数信息", notes = "根据id查询系统配置参数信息", httpMethod = "GET")
    public ResultTo returnUpdate(@ApiParam(value = "主键", required = true) @PathVariable("id") int id) {
        TSysParameter tSysParameter = tSysParameterService.selectByPrimaryKey(id);
        return new ResultTo().setData(tSysParameter);
    }

    /**
     * 获取所有系统参数配置
     *
     * @return 所有系统参数配置.
     */
    @RequestMapping
    @SystemControllerLog(description = "获取所有系统参数配置")
    @ApiOperation(value = "获取所有系统参数配置", notes = "所有系统参数配置", httpMethod = "GET")
    public DataTablePage queryAll() {
        return dataTablePage("queryAll");
    }

    /**
     * 更新系统参数配置
     *
     * @param tSysParameter 系统参数实体信息
     * @return 数据库变记录
     */
    @PutMapping
    @SystemControllerLog(description = "更新系统参数配置")
    @ApiOperation(value = "更新系统参数配置", notes = "更新系统参数配置", httpMethod = "PUT")
    public ResultTo update(@ApiParam("系统参数实体信息") @ModelAttribute TSysParameter tSysParameter) {
        tSysParameter.setModifyBy(ShiroKit.getUserId());
        tSysParameter.setModifyTime(new Date());
        Integer count = tSysParameterService.updateSelectiveByPrimaryKey(tSysParameter);
        logger.info("更新系统参数配置", "用户id:" + ShiroKit.getUserId() + ",更新了参数" + tSysParameter);
        return count != 0 ? new ResultTo().setData(count) : new ResultTo(ResultEnum.SERVICE_ERROR);
    }

    /**
     * 添加系统参数配置
     *
     * @param tSysParameter 系统参数实体信息
     * @return 主键
     */
    @PostMapping
    @SystemControllerLog(description = "添加系统参数配置")
    @ApiOperation(value = "新增系统参数配置", notes = "新增系统参数配置", httpMethod = "POST")
    public ResultTo insert(@ApiParam("系统参数实体信息") @ModelAttribute TSysParameter tSysParameter) {
        tSysParameter.setCreateBy(ShiroKit.getUserId());
        Integer count = tSysParameterService.insertSelective(tSysParameter);
        logger.info("新增系统参数配置", "用户id:" + ShiroKit.getUserId() + ",添加了参数" + tSysParameter);
        return count != 0 ? new ResultTo().setData(tSysParameter.getId()) : new ResultTo(ResultEnum.SERVICE_ERROR);
    }

}
