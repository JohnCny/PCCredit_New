package com.cardpay.controller.log;

import com.alibaba.fastjson.JSON;
import com.cardpay.basic.util.datatable.DataTablePage;
import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.log.model.LoginLog;
import com.cardpay.mgt.log.service.LoginLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import tk.mybatis.mapper.entity.Example;

import java.util.Map;

/**
 * 日志controller
 *
 * @author rankai
 * @create 2016-12-2016/12/21 10:22
 */

@Controller
@RequestMapping("/loginLog")
@Api(value = "/loginLog", description = "登陆日志日志操作")
public class LoginLogController extends BaseController<LoginLog> {

    private final static String LOGIN_LOG_PAGE = "/log/loginLog";

    @Autowired
    private LoginLogService loginLogService;

    /**
     * 登陆日志的跳转页面
     *
     * @return 登陆日志的页面
     */
    @ApiResponses({@ApiResponse(code = 405, message = "请求类型错误"), @ApiResponse(code = 500, message = "服务器异常")})
    @ApiOperation(value = "登陆日志的跳转页面", httpMethod = "GET")
    @GetMapping()
    public String loginLogPage() {
        return LOGIN_LOG_PAGE;
    }

    /**
     * 获取日志分页列表数据
     *
     * @return 日志分页列表数据
     */
    @ApiResponses({@ApiResponse(code = 405, message = "请求类型错误"), @ApiResponse(code = 500, message = "服务器异常")})
    @ApiOperation(value = "获取日志分页列表数据", httpMethod = "GET")
    @GetMapping("/pageList")
    @ResponseBody
    public DataTablePage loginLog(WebRequest request) {
        return dataTablePage(loginLogService.pageList(request));
    }
}
