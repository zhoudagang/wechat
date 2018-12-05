package what.fuck.wechat.message;

/**
 * 回复语音消息中的语音对象
 *
 * <p>提供了获取语音Id<code>getMediaId()</code>等主要方法.</p>
 *
 */
@SuppressWarnings("serial")
public class Voice implements java.io.Serializable {

    private String MediaId;     //通过上传多媒体文件，得到的id

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
     * @param mediaId 通过上传多媒体文件，得到的id
     */
    public void setMediaId(String mediaId) {
        this.MediaId = mediaId;
    }
}