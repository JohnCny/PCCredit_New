package com.cardpay.controller.generalization;
import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.core.fastdfs.FastDFSFile;
import com.cardpay.core.fastdfs.FileManager;
import com.cardpay.core.fastdfs.FileManagerConfig;
import io.swagger.annotations.*;
import org.csource.common.NameValuePair;
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
    @ApiModelProperty(dataType = "MultipartFile")
    @ApiImplicitParam(name = "files", value = "文件", required = true, dataType = "MultipartFile")
    public ResultTo upLoad(@RequestPart MultipartFile[] files) {
        List<String> list = new ArrayList<>();
        String ext = "";
        for (int i = 0; i < files.length; i++) {
            ext = files[i].getOriginalFilename().substring(files[i].getOriginalFilename().lastIndexOf(".") + 1);
            FastDFSFile file = null;
            try {
                file = new FastDFSFile(files[i].getBytes(), ext);
            } catch (IOException e) {
                e.printStackTrace();
                return new ResultTo(500, "走你");
            }
            NameValuePair[] metaList = new NameValuePair[4];
            metaList[0] = new NameValuePair("fileName", files[i].getOriginalFilename());
            metaList[1] = new NameValuePair("fileLength", String.valueOf(files[i].getSize()));
            metaList[2] = new NameValuePair("fileExt", ext);
            metaList[3] = new NameValuePair("fileAuthor", FileManagerConfig.FILE_DEFAULT_AUTHOR);
            //组名+fastdfs文件名+文件后缀+文件名
            String upload = FileManager.upload(file, metaList) + ",." + ext + "," + files[i].getOriginalFilename();
            logger.info("上传文件返回结果:" , upload);
            list.add(upload);
        }
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
