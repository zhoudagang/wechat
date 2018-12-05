package what.fuck.wechat.message;

/**
 * 回复音乐消息中的音乐对象
 *
 */
@SuppressWarnings("serial")
public class Music implements java.io.Serializable {

    private String Title;           //音乐标题
    private String Description;     //音乐描述
    private String MusicUrl;        //音乐链接
    private String HQMusicUrl;      //高质量音乐链接，WIFI环境优先使用该链接播放音乐
    private String ThumbMediaId;    //缩略图的媒体id，通过上传多媒体文件，得到的id

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getMusicUrl() {
        return MusicUrl;
    }

    public void setMusicUrl(String MusicUrl) {
        this.MusicUrl = MusicUrl;
    }

    public String getHQMusicUrl() {
        return HQMusicUrl;
    }

    public void setHQMusicUrl(String HQMusicUrl) {
        this.HQMusicUrl = HQMusicUrl;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String ThumbMediaId) {
        this.ThumbMediaId = ThumbMediaId;
    }
}
