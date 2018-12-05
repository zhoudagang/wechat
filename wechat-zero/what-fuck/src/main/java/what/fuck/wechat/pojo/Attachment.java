
package what.fuck.wechat.pojo;

import java.io.BufferedInputStream;

/**
 * 附件
 *
 */
public class Attachment {

    private String fileName;
    private String fullName;
    private String suffix;
    private String contentLength;
    private String contentType;
    private BufferedInputStream fileStream;
    private String error;

    /**
     * 附件名称
     *
     * @return 附件名称
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 设置 附件名称
     *
     * @param fileName 附件名称
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 附件全名
     *
     * @return 附件全名
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * 设置附件全名
     *
     * @param fullName 附件全名
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * 附件后缀
     *
     * @return 附件后缀
     */
    public String getSuffix() {
        return suffix;
    }

    /**
     * 设置 附件后缀
     *
     * @param suffix 附件后缀
     */
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    /**
     * 内容长度
     *
     * @return 内容长度
     */
    public String getContentLength() {
        return contentLength;
    }

    /**
     * 设置内容长度
     *
     * @param contentLength 内容长度
     */
    public void setContentLength(String contentLength) {
        this.contentLength = contentLength;
    }

    /**
     * 文件类型
     *
     * @return 文件类型
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * 设置 文件类型
     *
     * @param contentType 文件类型
     */
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    /**
     * 文件输入流
     *
     * @return 文件输入流
     */
    public BufferedInputStream getFileStream() {
        return fileStream;
    }

    /**
     * 设置 文件输入流
     *
     * @param fileStream 文件输入流
     */
    public void setFileStream(BufferedInputStream fileStream) {
        this.fileStream = fileStream;
    }

    /**
     * 错误消息
     *
     * @return 错误消息
     */
    public String getError() {
        return error;
    }

    /**
     * 设置 错误消息
     *
     * @param error 错误消息
     */
    public void setError(String error) {
        this.error = error;
    }
}
