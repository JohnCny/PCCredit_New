package com.cardpay.controller.file;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.core.fastdfs.FileManager;
import io.swagger.annotations.*;
import org.csource.fastdfs.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 文件上传下载Controller
 * Created by chenkai .
 * Date 2016/11/25 .
 */
@Api(value = "/file", description = "文件上传类")
@RestController
@RequestMapping("/files")
public class FilesController {
    @Autowired
    private FileManager fileManager;

    /**
     * 文件下载接口
     *
     * @param file 组名,文件名,另存为名称
     * @return ResponseEntity对象
     */
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    @ApiOperation(value = "文件下载接口", notes = "下载dfs服务器文件", httpMethod = "GET")
    public ResultTo download(@ApiParam(value = "组名,文件名,另存为名称", required = true)
                                           @RequestParam("file") String file) {
        String[] str = file.split(",");
        ResponseEntity<byte[]> download = FileManager.download(str[0], str[1], str[2]);
        return new ResultTo().setData(download);
    }

    /**
     * 文件上传接口
     *
     * @param file 文件
     * @return 文件路径
     * @throws Exception IO异常
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ApiOperation(value = "文件上传接口", notes = "上传文件到dfs服务器", httpMethod = "POST")
    @ApiModelProperty(dataType = "MultipartFile")
    public ResultTo upLoad(@ApiParam(name="文件", required=true) @RequestParam("file") MultipartFile[] file) {
        List<String> list = fileManager.upLoad(file);
        return new ResultTo().setData(list);
    }

    /**
     * 删除文件接口
     *
     * @param file 文件信息
     * @return 1成功, 0失败
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ApiOperation(value = "文件删除接口", notes = "删除dfs服务器中指定文件", httpMethod = "DELETE")
    public ResultTo delete(@ApiParam(value = "组名,文件名", required = true) @RequestPart("file") String file) {
        String[] str = file.split(",");
        int flag = FileManager.deleteFile(str[0], str[1]);
        return new ResultTo().setData(flag);
    }

    /**
     * 文件查询接口
     * @param groupName 组名称
     * @param fileName fastdfs中文件名称
     * @return fileInfo对象
     */
    @RequestMapping(value = "/queryFile", method = RequestMethod.GET)
    @ApiOperation(value = "文件查询接口", notes = "查询dfs服务器中指定文件", httpMethod = "GET")
    public ResultTo queryFile(@ApiParam(value = "组名", required = true) String groupName
            ,@ApiParam(value = "fastdfs中文件名称", required = true) String fileName){
        FileInfo fileInfo = FileManager.queryFile(groupName, fileName);
        return new ResultTo().setData(fileInfo);
    }
}
