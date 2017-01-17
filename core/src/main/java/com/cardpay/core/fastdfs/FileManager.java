package com.cardpay.core.fastdfs;


import com.cardpay.core.fastdfs.pool.ConnectionPool;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.file.model.TFile;
import com.cardpay.mgt.file.service.TFileService;
import org.apache.commons.lang3.StringUtils;
import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.csource.common.NameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * FastDFSFile文件上传下载通用类
 *
 * @author chenkai
 */
@Component
public class FileManager implements FileManagerConfig {
    @Autowired
    private TFileService tFileService;
    @Autowired
    private ConnectionPool connectionPool;

    private static StorageServer storageServer;

    private static TrackerServer trackerServer;

    /**
     * 初始化fastDfs连接池
     *
     * @return storageClient
     * @throws Exception 异常信息
     */
    private StorageClient1 into() throws Exception {
         trackerServer = connectionPool.checkout();
        StorageClient1 storageClient1 = new StorageClient1(trackerServer, storageServer);
        return storageClient1;
    }

    /**
     * 上传文件
     *
     * @param file       FastDFSFile文件
     * @param valuePairs 文件分卷信息
     * @return 文件路径
     */
    private String upload(FastDFSFile file, NameValuePair[] valuePairs) {
        try {
            StorageClient1 storageClient = into();
            String[] uploadResults;
            uploadResults = storageClient.upload_file(file.getContent(), file.getExt(), valuePairs);
            if (uploadResults.length > 0) {
                String groupName = uploadResults[0];
                String remoteFileName = uploadResults[1];
                return groupName + "," + remoteFileName;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionPool.checkin(trackerServer);
        }
        return null;
    }

    /**
     * 下载文件
     *
     * @param groupName      文件所在组名称
     * @param remoteFileName 文件名称
     * @param specFileName   文件类型
     * @return ResponseEntity对象
     */
    public ResponseEntity<byte[]> download(String groupName, String remoteFileName, String specFileName) {
        HttpHeaders headers = new HttpHeaders();
        byte[] content = null;
        try {
            StorageClient1 storageClient = into();
            content = storageClient.download_file(groupName, remoteFileName);
            if (content.length > 0) {
                updateFile(remoteFileName);
            }
            headers.setContentDispositionFormData("attachment",
                    new String(specFileName.getBytes("UTF-8"), "iso-8859-1"));
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionPool.checkin(trackerServer);
        }
        return new ResponseEntity<>(content, headers, HttpStatus.CREATED);
    }

    /**
     * 下载文件(返回InputStream)
     *
     * @param groupName      组名称
     * @param remoteFileName 文件名
     * @return InputStream对象
     */
    public InputStream downLoadToFile(String groupName, String remoteFileName) {
        byte[] content = null;
        try {
            StorageClient1 storageClient = into();
            content = storageClient.download_file(groupName, remoteFileName);
            if (content.length > 0) {
                updateFile(remoteFileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionPool.checkin(trackerServer);
        }
        return content == null ? null : new ByteArrayInputStream(content);
    }

    /**
     * 更新TFile信息
     *
     * @param remoteFileName 文件名
     * @return 变动数量
     */
    private int updateFile(String remoteFileName) {
        TFile tFile = new TFile();
        tFile.setFastName(remoteFileName);
        TFile fileEntity = tFileService.selectOne(tFile);
        fileEntity.setModifyBy(String.valueOf(ShiroKit.getUserId()));
        fileEntity.setRemark("downLoad");
        return tFileService.updateByPrimaryKey(fileEntity);
    }

    /**
     * 删除文件
     *
     * @param groupName      分组名称
     * @param remoteFileName 文件名称
     * @return 1成功, 0失败
     */
    public int deleteFile(String groupName, String remoteFileName) {
        try {
            StorageClient1 storageClient = into();
            TFile tFile = new TFile();
            tFile.setFastName(remoteFileName);
            Integer flag = tFileService.delete(tFile);
            return null != flag ? storageClient.delete_file(groupName, remoteFileName) : 0;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionPool.checkin(trackerServer);
        }
        return 0;
    }

    /**
     * 查询文件
     *
     * @param groupName      分组名称
     * @param remoteFileName 文件名称
     * @return FileInfo
     */
    public FileInfo queryFile(String groupName, String remoteFileName) {
        FileInfo fileInfo = null;
        try {
            StorageClient1 storageClient = into();
            fileInfo = storageClient.query_file_info(groupName, remoteFileName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionPool.checkin(trackerServer);
        }
        return fileInfo;
    }

    /**
     * 单文件上传
     *
     * @param file 上传文件
     * @return 文件信息
     */
    public String upLoad(MultipartFile file) {
        String ext = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
        return upLoadCore(file, ext);
    }

    /**
     * 单文件上传
     *
     * @param file 上传文件
     * @return 文件信息
     */
    public String upLoadExt(MultipartFile file) {
        String ext = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
        return upLoadCore(file, ext) + "," + ext;
    }

    /**
     * 文件批量上传接口
     *
     * @param files 文件
     * @return 文件名称
     */
    public List<String> upLoad(MultipartFile[] files) {
        List<String> list = new ArrayList<>();
        String ext;
        for (MultipartFile file : files) {
            ext = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
            String upLoadCore = upLoadCore(file, ext);
            list.add(upLoadCore);
        }
        return list;
    }

    /**
     * 文件上传核心方法
     *
     * @param file 文件
     * @return fastDfs返回值
     */
    private String upLoadCore(MultipartFile file, String ext) {
        String fileName = null;
        List<TFile> tFiles = new ArrayList<>();
        try {
            FastDFSFile fastDFSFile = new FastDFSFile(file.getBytes(), ext);
            NameValuePair[] metaList = new NameValuePair[4];
            metaList[0] = new NameValuePair("fileName", file.getOriginalFilename());
            metaList[1] = new NameValuePair("fileLength", String.valueOf(file.getSize()));
            metaList[2] = new NameValuePair("fileExt", ext);
            metaList[3] = new NameValuePair("fileAuthor", FileManagerConfig.FILE_DEFAULT_AUTHOR);
            fileName = upload(fastDFSFile, metaList);
            //插入数据库t_file表
            if (StringUtils.isNoneBlank(fileName)) {
                String[] split = fileName.split(",");
                String userId = String.valueOf(ShiroKit.getUserId());
                TFile tFile = TFile.TFileBuilder.get()
                        .withId(1)
                        .withImageType(ext)
                        .withFileName(file.getOriginalFilename())
                        .withRemark("upload")
                        .withCreatedBy(userId)
                        .withCreatedAt(new Date())
                        .withModifiedBy(userId)
                        .withModifiedAt(new Date())
                        .withGroupName(split[0])
                        .withFastName(split[1])
                        .build();
                tFiles.add(tFile);
                tFileService.batchInsertFile(tFiles);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }
}


