package com.cardpay.mgt.application.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.application.model.TApplicationFile;
import org.springframework.web.multipart.MultipartFile;

/**
 * 进件文件关联表Service
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/9 10:25
 */
public interface TApplicationFileService extends BaseService<TApplicationFile> {
    /**
     * 添加文件
     * @param files 文件
     * @param tApplicationFile 文件相关
     * @return 数据库变记录
     */
    int insertFile(MultipartFile[] files, TApplicationFile tApplicationFile);
}
