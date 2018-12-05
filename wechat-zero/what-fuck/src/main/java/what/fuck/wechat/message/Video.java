package what.fuck.wechat.message;

/**
 * 回复视频消息中的视频对象
 *
 * <p>提供了获取视频Id<code>getMediaId()</code>等主要方法.</p>
 *
 */
@SuppressWarnings("serial")
public class Video implements java.io.Serializable {

    private String MediaId;     //通过上传多媒体文件，得到的id
    private String Title;       //视频消息的标题
    private String Description; //视频消息的描述

    /**
     * 获取 通过上传多媒体文件，得到的id
     *
     * @return 通过上传多媒体文件，得到的id
     */
    public String getMediaId() {
        return MediaId;
    }

    /**
     * 设置 通过上传多媒体文件，得到的id
     *
     * @param image 通过上传多媒体文件，得到的id
     */
    public void setMediaId(String mediaId) {
        this.MediaId = mediaId;
    }

    /**
     * @return the Title
     */
    public String getTitle() {
        return Title;
    }

    /**
     * @param Title the Title to set
     */
    public void setTitle(String Title) {
        this.Title = Title;
    }

    /**
     * @return the Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param Description the Description to set
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }
}
