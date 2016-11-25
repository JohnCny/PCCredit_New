package com.cardpay.core.fastdfs;


import com.cardpay.basic.common.log.LogTemplate;
import org.csource.fastdfs.*;
import org.csource.common.NameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.File;


/**
 * FastDFSFile文件上传实现接口
 * Created by chenkai on 2016/11/25.
 */
public class FileManager implements FileManagerConfig {
    @Autowired
    private static LogTemplate logger;

    private static TrackerClient trackerClient;
    private static StorageClient storageClient;
    private static TrackerServer trackerServer;
    private static StorageServer storageServer;

    static {
        try {
            //读取配置文件
            String classPath = new File(FileManager.class.getResource("/").getFile()).getCanonicalPath();
            String dfsClientConfigFilePath = classPath + File.separator + CLIENT_CONFIG_FILE;
            ClientGlobal.init(dfsClientConfigFilePath);

            trackerClient = new TrackerClient();
            trackerServer = trackerClient.getConnection();
            storageClient = new StorageClient(trackerServer, storageServer);
        }catch (Exception e){
            e.printStackTrace();
            logger.debug("", e.getMessage());
        }
    }

    /**
     * 上传文件
     * @param file FastDFSFile文件
     * @param valuePairs 文件分卷信息
     * @return 文件路径
     */
    public static String upload(FastDFSFile file, NameValuePair[] valuePairs){
        String groupName = "";
        String fileBuff = "";
            try {
                String[] uploadResults = storageClient.upload_file(file.getContent(), file.getExt(), valuePairs);
                groupName = uploadResults[0];
                fileBuff = uploadResults[1];
            }catch (Exception e){
                e.printStackTrace();
                logger.debug("", e.getMessage());
            }
        return groupName + "," + fileBuff;
    }

    /**
     * 下载文件
     * @param groupName 文件所在组名称
     * @param fileBuff 文件名称
     * @param fileType 文件类型
     * @return ResponseEntity对象
     */
    public static ResponseEntity<byte[]> download(String groupName, String fileBuff, String fileType) {
        byte[] content = null;
        HttpHeaders headers = new HttpHeaders();
        try {
            content = storageClient.download_file(groupName, fileBuff);
            headers.setContentDispositionFormData("attachment",
                    new String(fileType.getBytes("UTF-8"), "iso-8859-1"));
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        }catch (Exception e){
            e.printStackTrace();
            logger.debug("", e.getMessage());
        }
        return new ResponseEntity<>(content, headers, HttpStatus.CREATED);
    }

    /**
     * 删除文件
     *
     * @param groupName      分组名称
     * @param remoteFileName 文件名称
     * @return 1成功, 0失败
     */
    public static int deleteFile(String groupName, String remoteFileName) {
        try {
            return storageClient.delete_file(groupName, remoteFileName);
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("", e.getMessage());
        }
        return 0;
    }
}
