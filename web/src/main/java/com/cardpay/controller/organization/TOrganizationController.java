package com.cardpay.controller.organization;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.organization.model.TOrganization;
import com.cardpay.mgt.organization.model.vo.TOrganizationVo;
import com.cardpay.mgt.organization.service.TOrganizationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 机构Controller类
 * Created by chenkai on 2016/11/24.
 */
@Api(value = "/organization", description = "机构Controller类")
@Controller
@RequestMapping("/organization")
public class TOrganizationController extends BaseController<TOrganization, Integer> {
    @Autowired
    @Qualifier("TOrganizationServiceImpl")
    private TOrganizationService tOrganizationService;

    @Autowired
    private static LogTemplate logger;

    /**
     * 查询机构层级信息接口
     * @param id 要查询的顶级层级ID
     * @param level 查询层级信息数量
     * @return 机构层级信息
     */
    @ResponseBody
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ApiOperation(value = "查询机构层级信息接口", notes = "查询机构层级信息",  httpMethod = "GET")
    public ResultTo queryOrganization(@ApiParam(value = "要查询的顶级层级ID")
                                          @RequestParam(value = "id", defaultValue = "0") int id
            , @ApiParam(value = "查询层级信息数量") @RequestParam(value = "level", defaultValue = "0") int level){
        List<TOrganizationVo> organization = tOrganizationService.queryOrganization(id, level);
        return new ResultTo().setData(organization);
    }

    /**
     * 递归删除层级信息
     * @param id 层级id
     * @return 1成功, 0失败
     */

    @RequestMapping(value = "/deleteOrganization", method = RequestMethod.DELETE)
    @ResponseBody
    @ApiOperation(value = "递归删除层级接口", notes = "递归删除层级信息",  httpMethod = "DELETE")
    public ResultTo deleteOrganization(@ApiParam(value = "层级id", required = true) @RequestParam int id){
        int flag = tOrganizationService.deleteOrganization(id);
        logger.info(TOrganizationController.class, "递归删除层级信息", "层级id:"+id);
        return new ResultTo().setData(flag);
    }

}
