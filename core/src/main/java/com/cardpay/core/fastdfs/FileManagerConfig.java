package com.cardpay.core.fastdfs;


import java.io.Serializable;

/**
 * FastDfs pei配置类
 * @author chenkai
 */
public interface FileManagerConfig extends Serializable {
    /**
     * 作者
     */
    String FILE_DEFAULT_AUTHOR = "qkjr";

    /**
     * 配置文件名
     */
     String CLIENT_CONFIG_FILE   = "dfs.conf";

}
