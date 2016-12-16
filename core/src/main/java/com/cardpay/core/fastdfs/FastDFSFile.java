package com.cardpay.core.fastdfs;

/**
 * FastDFSFile文件信息实体类
 * @author chenkai
 */
public class FastDFSFile implements FileManagerConfig {
    private byte[] content;
    /**
     * 文件名
     */
    private String name;
    /**
     * 文件类型
     */
    private String ext;
    /**
     * 文件长度
     */
    private String length;

    public FastDFSFile(byte[] content, String ext) {
        this.content = content;
        this.ext = ext;
    }

    public FastDFSFile(byte[] content, String name, String ext) {
        this.content = content;
        this.name = name;
        this.ext = ext;
    }

    public FastDFSFile(byte[] content, String name, String ext, String length) {
        this.content = content;
        this.name = name;
        this.ext = ext;
        this.length = length;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }
}
