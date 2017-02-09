package com.cardpay.controller.application.basic;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.util.datatable.DataTablePage;
import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.application.basic.model.TApplicationFile;
import com.cardpay.mgt.application.basic.service.TApplicationFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;
import javax.servlet.http.HttpServletRequest;


/**
 * 进件相关报告
 *
 * @author chenkai
 */
@RestController
@RequestMapping("/api/applicationFile")
public class ApplicationFileController extends BaseController<TApplicationFile> {
    /**
     * 进件相关报告上传
     */
    @Autowired
    private TApplicationFileService tApplicationFileService;

    /**
     * 进件相关报告上传接口
     *
     * @param files            文件
     * @param tApplicationFile 进见id，上传类型
     * @return 数据库变更记录
     */
    @PostMapping
    public ResultTo upLoads(@RequestPart MultipartFile[] files, @ModelAttribute TApplicationFile tApplicationFile) {
        int flag = tApplicationFileService.insertFile(files, tApplicationFile);
        return flag != 0 ? new ResultTo().setData(flag) : new ResultTo(ResultEnum.SERVICE_ERROR);
    }

    /**
     * 进件相关报告列表
     * @param applicationId 进件id
     * @param request request
     * @return 报告列表
     */
    @GetMapping("/{applicationId}")
    public DataTablePage queryAll(@PathVariable("applicationId") int applicationId, HttpServletRequest request) {
        Example example = new Example(TApplicationFile.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("applicationId", applicationId);
        String order = DataTablePage.getOrder(request);
        example.orderBy(order);
        return dataTablePage(example);
    }

}
