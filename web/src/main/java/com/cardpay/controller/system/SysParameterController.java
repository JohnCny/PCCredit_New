package com.cardpay.controller.system;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.util.datatable.DataTablePage;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.system.model.TSysParameter;
import com.cardpay.mgt.system.service.TSysParameterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * 系统参数配置Controller
 *
 * @author chenkai
 *         createTime 2016-12-2016/12/27 10:02
 */
@Controller
@RequestMapping("/system")
@Api(value = "/organization", description = "系统参数配置")
public class SysParameterController extends BaseController<TSysParameter> {
    @Autowired
    private TSysParameterService tSysParameterService;

    /**
     * 跳转系统参数配置主页
     *
     * @return 统参数配置主页
     */
    @GetMapping("/index")
    @ApiOperation(value = "跳转系统参数配置主页", notes = "系统参数配置主页", httpMethod = "GET")
    public ModelAndView index() {
        return new ModelAndView("/system/index");
    }

    /**
     * 跳转编辑系统参数配置页面
     *
     * @param id 主键
     * @return 编辑系统参数配置页面
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "跳转编辑系统参数配置页面", notes = "编辑系统参数配置页面", httpMethod = "GET")
    public ModelAndView returnUpdate(@ApiParam(value = "主键", required = true) @PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("/system/update");
        TSysParameter tSysParameter = tSysParameterService.selectByPrimaryKey(id);
        modelAndView.addObject(tSysParameter);
        return modelAndView;
    }

    /**
     * 获取所有系统参数配置
     *
     * @return 所有系统参数配置.
     */
    @GetMapping
    @ResponseBody
    @ApiOperation(value = "获取所有系统参数配置", notes = "所有系统参数配置", httpMethod = "GET")
    public DataTablePage queryAll() {
        return dataTablePage();
    }

    /**
     * 更新系统参数配置
     *
     * @param tSysParameter 系统参数实体信息
     * @return 数据库变记录
     */
    @PutMapping
    @ResponseBody
    @ApiOperation(value = "更新系统参数配置", notes = "更新系统参数配置", httpMethod = "PUT")
    public ResultTo update(@ApiParam("系统参数实体信息") @ModelAttribute TSysParameter tSysParameter) {
        tSysParameter.setModifyBy(ShiroKit.getUserId());
        Integer count = tSysParameterService.updateByPrimaryKey(tSysParameter);
        return count != 0 ? new ResultTo().setData(count) : new ResultTo(ResultEnum.SERVICE_ERROR);
    }

    /**
     * 添加系统参数配置
     *
     * @param tSysParameter 系统参数实体信息
     * @return 主键
     */
    @PostMapping
    @ResponseBody
    @ApiOperation(value = "新增系统参数配置", notes = "新增系统参数配置", httpMethod = "POST")
    public ResultTo insert(@ApiParam("系统参数实体信息") @ModelAttribute TSysParameter tSysParameter) {
        tSysParameter.setCreateBy(ShiroKit.getUserId());
        Integer count = tSysParameterService.insertSelective(tSysParameter);
        return count != 0 ? new ResultTo().setData(tSysParameter.getId()) : new ResultTo(ResultEnum.SERVICE_ERROR);
    }

}
