package com.cardpay.controller.application.basic;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.util.datatable.DataTablePage;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.core.shiro.enums.ShiroEnum;
import com.cardpay.mgt.application.basic.model.TApplication;
import com.cardpay.mgt.application.basic.model.vo.TApplicationVo;
import com.cardpay.mgt.application.basic.service.TApplicationService;
import com.cardpay.mgt.application.ipc.basic.service.ApplicationIPCBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.cardpay.mgt.application.enums.ApplicationStatus.APP_UNFINISHED;


/**
 * 进件管理
 *
 * @author chenkai
 */

@RestController
@RequestMapping("/api/application")
public class ApplicationController extends BaseController<TApplication> {
    /**
     * 进件基本信息Service
     */
    @Autowired
    private TApplicationService tApplicationService;

    /**
     * ipc模板
     */
    @Autowired
    private ApplicationIPCBasicService applicationIPCBasicService;

    /**
     * 查询此产品是否可进行进件申请
     *
     * @param productId 产品Id
     * @return true/false
     */
    @GetMapping("/ifProduct/{productId}")
    public ResultTo queryProductIfOk(@PathVariable int productId) {
        Map<String, Object> map = tApplicationService.queryProductIfOk(ShiroKit.getUserId(), productId);
        return new ResultTo().setData(map);
    }

    /**
     * 新建进件
     *
     * @param productId  产品id
     * @param customerId 客户id
     * @return 进件Id
     */
    @PostMapping("/{productId}/{customerId}")
    public ResultTo insertApplication(@PathVariable int productId, @PathVariable int customerId) {
        boolean flag = tApplicationService.queryCustomerIfHaveProduct(customerId, productId);
        if (true) {
            Integer managerId = ShiroKit.getUserId();
            TApplication tApplication = new TApplication();
            tApplication.setCreateTime(new Date());
            tApplication.setProductId(productId);
            tApplication.setCustomerId(customerId);
            tApplication.setCustomerManagerId(managerId);
            tApplication.setApplicationStatus(APP_UNFINISHED.getValue());
            tApplicationService.insertSelective(tApplication);
            Integer mark = applicationIPCBasicService.initTemplate(tApplication.getId());
            return mark != 0 ? new ResultTo().setData(tApplication.getId()) : new ResultTo(ResultEnum.SERVICE_ERROR);
        }
        return new ResultTo().setData(flag);
    }

    /**
     * 查询客户经理下的所有进件
     * @param request
     * @return 进件列表
     */
    @RequestMapping("/pageList")
    public DataTablePage queryByManagerId(final HttpServletRequest request) {
        Integer userId = ShiroKit.getUserId();
        Map<String, Object> map = new HashMap();

        if (ShiroEnum.MANAGER.getValue().equals(ShiroKit.getRole().getRoleType())) {
            map.put("managerId", userId);
            return dataTablePage("queryByManagerId", map);
        }
        //团队负责人
        Integer teamId = (Integer) request.getAttribute("teamId");
        if (teamId != null && teamId != 0) {
            if (tApplicationService.userIfTeamBoss(userId, teamId)) {
                //按团队Id查询进件信息
                return dataTablePage("queryAppByTeamId", map);
            }
        }
        //机构负责人
        Integer orgId = (Integer) request.getAttribute("orgId");
        if (orgId != null && orgId != 0) {
            if (tApplicationService.userIfOrgBoss(userId, teamId)) {
                //按机构id查询进件信息
                return dataTablePage("queryAppByOrgId", map);
            }
        }
        return null;
    }

    /**
     * 按进件id查询进件信息
     *
     * @param applicationId 进件id
     * @return 进件列表
     */
    @GetMapping("/{id}")
    public ResultTo queryByApplication(@PathVariable("id") int applicationId) {
        TApplicationVo tApplicationVo = tApplicationService.queryByApplication(applicationId);
        return new ResultTo().setData(tApplicationVo);
    }


}
