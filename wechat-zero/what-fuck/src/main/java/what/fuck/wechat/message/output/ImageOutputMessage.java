package what.fuck.wechat.message.output;

import what.fuck.wechat.message.Image;
import what.fuck.wechat.message.OutputMessage;

/**
 * 这个类实现了<tt>OutputMessage</tt>，用来回复图片消息
 *
 * <p>
 * 提供了获取图片Id<code>getMediaId()</code>等主要方法.</p>
 *
 */
@SuppressWarnings("serial")
public class ImageOutputMessage extends OutputMessage {

    /**
     * 消息类型:图片消息
     */
    private final String MsgType = "image";
    /**
     * 通过上传多媒体文件，得到的id
     */
    private Image Image;

    /**
     * 创建一个图片 Output Message.
     *
     * 并且MsgType的值为image.
     */
    public ImageOutputMessage() {
    }

    /**
     * 创建一个图片 的Output Message.
     *
     * 并且MsgType的值为image.
     *
     * @param image 图片
     */
    public ImageOutputMessage(Image image) {
        this.Image = image;
    }

    /**
     * 获取 消息类型
     *
     * @return 消息类型
     */
    @Override
    public String getMsgType() {
        return MsgType;
    }

    /**
     * 获取 通过上传多媒体文件，得到的id
     *
     * @return 通过上传多媒体文件，得到的id封装的image对象
     */
    public Image getImage() {
        return this.Image;
    }

    /**
     * 设置 通过上传多媒体文件，得到的id
     *
     * @param image 通过上传多媒体文件，得到的id封装的image对象
     */
    public void setImage(Image image) {
        this.Image = image;
    }

    @Override
    public String toXML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        sb.append("<ToUserName><![CDATA[").append(this.getToUserName()).append("]]></ToUserName>");
        sb.append("<FromUserName><![CDATA[").append(this.getFromUserName()).append("]]></FromUserName>");
        sb.append("<CreateTime>").append(this.getCreateTime()).append("</CreateTime>");
        sb.append("<MsgType><![CDATA[" + this.MsgType + "]]></MsgType>");
        sb.append("<Image>");
        sb.append("<MediaId><![CDATA[").append(this.getImage().getMediaId()).append("]]></MediaId>");
        sb.append("</Image>");
        sb.append("</xml>");
        return sb.toString();
    }
}
