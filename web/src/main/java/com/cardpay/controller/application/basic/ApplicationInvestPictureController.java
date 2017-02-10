package com.cardpay.controller.application.basic;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.util.datatable.DataTablePage;
import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.application.basic.model.TApplicationInvestPicture;
import com.cardpay.mgt.application.basic.service.TApplicationInvestPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * 调查图片表Controller
 *
 * @author chenkai
 */
@RestController
@RequestMapping("/api/applicationInvestPicture")
public class ApplicationInvestPictureController extends BaseController<TApplicationInvestPicture> {
    /**
     * 进件调查图
     */
    @Autowired
    private TApplicationInvestPictureService tApplicationInvestPictureService;

    /**
     * 进件相关图片上传
     *
     * @param files                     图片
     * @param tApplicationInvestPicture 相关参数
     * @return 数据库变记录
     */
    @PostMapping
    public ResultTo upLoads(@RequestPart MultipartFile[] files, TApplicationInvestPicture tApplicationInvestPicture) {
        int flag = tApplicationInvestPictureService.insertFile(files, tApplicationInvestPicture);
        return flag != 0 ? new ResultTo().setData(flag) : new ResultTo(ResultEnum.SERVICE_ERROR);
    }

    /**
     * 查询产品调查图片
     *
     * @param applicationId 进件Id
     * @return 产品调查图片信息
     */
    @GetMapping("/{applicationId}")
    public DataTablePage queryByProduct(@PathVariable("applicationId") int applicationId){
        Map<String, Object> map = new HashMap();
        map.put("applicationId", applicationId);
        return dataTablePage("queryByApplicationId", map);
    }


}
