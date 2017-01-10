package com.cardpay.mgt.file.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.file.model.TFile;

import java.util.List;

/**
 * 文件Mapepr类
 * @auther chenkai
 */
public interface TFileMapper extends BasicMapper<TFile> {

    /**
     * 批量插入文件信息
     * @param list
     * @return 插入数量
     */
    int batchInsertFile(List<TFile> list);
}