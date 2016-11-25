package com.cardpay.controller.generalization;
import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.core.fastdfs.FastDFSFile;
import com.cardpay.core.fastdfs.FileManager;
import com.cardpay.core.fastdfs.FileManagerConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.csource.common.NameValuePair;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 文件上传下载
 * Created by chekai .
 * Date 2016/11/25 .
 */
@Api(value = "/files", description = "文件上传类")
@Controller
@RequestMapping("/files")
public class FilesController {
    @Autowired
    private static LogTemplate logger;

    /**
     * 文件下载接口
     * @param file 组名,文件名,文件类型
     * @return ResponseEntity对象
     */
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    @ApiOperation(value = "文件下载接口", notes = "下载dfs服务器文件",  httpMethod = "GET")
    public ResponseEntity<byte[]> download(@ApiParam(value = "组名,文件名,文件类型", required = true)
                                               @RequestParam("file") String file) {
        String[] str = file.split(",");
        return FileManager.download(str[0], str[1], str[2]);
    }

    /**
     *  文件上传接口
     * @param files 文件
     * @return  文件路径
     * @throws Exception IO异常
     */
    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ApiOperation(value = "文件上传接口", notes = "上传文件到dfs服务器", httpMethod = "POST")
    public ResultTo upLoad(@ApiParam(value = "文件", required = true, allowMultiple = true) @RequestPart MultipartFile[] files) {
        List<String> list = new ArrayList<>();
        final String[] ext = {""};
        Arrays.stream(files).forEach((MultipartFile file) ->{
            ext[0] = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);//获取后缀名
            try {
                FastDFSFile fastDFSFile = new FastDFSFile(file.getBytes(), ext[0]);
                NameValuePair[] metaList = new NameValuePair[4];
                metaList[0] = new NameValuePair("fileName", file.getOriginalFilename());
                metaList[1] = new NameValuePair("fileLength", String.valueOf(file.getSize()));
                metaList[2] = new NameValuePair("fileExt", ext[0]);
                metaList[3] = new NameValuePair("fileAuthor", FileManagerConfig.FILE_DEFAULT_AUTHOR);
                String upload = FileManager.upload(fastDFSFile, metaList) + ",." + ext[0] + "," + file.getOriginalFilename();
                list.add(upload);
                logger.info("上传文件返回结果", upload);
            } catch (IOException e) {
                e.printStackTrace();
                logger.debug(file.getOriginalFilename()+"文件上传失败", e.getMessage());
            }
        });
        return new ResultTo().setData(list);
    }

    /**
     * 删除文件接口
     * @param file 文件信息
     * @return 1成功, 0失败
     */
    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ApiOperation(value = "文件删除接口", notes = "删除dfs服务器中指定文件",  httpMethod = "DELETE")
    public ResultTo delete(@ApiParam(value = "组名,文件名", required = true) @RequestParam("file") String file) {
        String[] str = file.split(",");
        int flag = FileManager.deleteFile(str[0], str[1]);
        return new ResultTo().setData(flag);
    }
}
