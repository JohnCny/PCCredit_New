package com.cardpay.mgt.file.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.file.model.TFile;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 文件Service类
 * Created by chenkai on 2016/11/25.
 */
public interface TFileService extends BaseService<TFile>{

    /**
     * 批量插入
     * @param list
     * @return 数据库变更数量
     */
    int batchInsertFile(List<TFile> list);


    /**
     * 上传文件返回文件信息
     * @param files 文件
     * @return 文件信息
     */
    List<TFile> uploads(MultipartFile[] files);
}
