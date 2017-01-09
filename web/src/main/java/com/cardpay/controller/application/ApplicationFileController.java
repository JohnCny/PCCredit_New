package com.cardpay.controller.application;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.application.basic.model.TApplicationFile;
import com.cardpay.mgt.application.basic.service.TApplicationFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/**
 * 进件文件上传表
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/9 10:27
 */
@RestController
@RequestMapping("/api/applicationFile")
public class ApplicationFileController extends BaseController<TApplicationFile> {
    @Autowired
    private TApplicationFileService tApplicationFileService;

    /**
     * 文件上传接口
     *
     * @param files            文件
     * @param tApplicationFile 进见id，上传类型
     * @return 数据库变更记录
     */
    @PostMapping
    public ResultTo upLoads(@RequestPart MultipartFile[] files, TApplicationFile tApplicationFile) {
        int flag = tApplicationFileService.insertFile(files, tApplicationFile);
        return flag != 0 ? new ResultTo().setData(flag) : new ResultTo(ResultEnum.SERVICE_ERROR);
    }

}
