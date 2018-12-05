package what.fuck.wechat.message.output;

import what.fuck.wechat.message.Music;
import what.fuck.wechat.message.OutputMessage;

/**
 * 这个类实现了<tt>OutputMessage</tt>，用来回复音乐消息
 *
 * <p>
 * 提供了获取音乐链接<code>getMusicURL()</code>等主要方法.</p>
 *
 */
@SuppressWarnings("serial")
public class MusicOutputMessage extends OutputMessage {

    /**
     * 消息类型:音乐消息
     */
    private final String MsgType = "music";
    /**
     * 音乐消息对象
     */
    private Music Music;

    @Override
    public String getMsgType() {
        return MsgType;
    }

    public MusicOutputMessage(Music music) {
        super();
        Music = music;
    }

    public Music getMusic() {
        return Music;
    }

    public void setMusic(Music Music) {
        this.Music = Music;
    }

    @Override
    public String toXML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        sb.append("<ToUserName><![CDATA[").append(this.getToUserName()).append("]]></ToUserName>");
        sb.append("<FromUserName><![CDATA[").append(this.getFromUserName()).append("]]></FromUserName>");
        sb.append("<CreateTime>").append(this.getCreateTime()).append("</CreateTime>");
        sb.append("<MsgType><![CDATA[" + this.MsgType + "]]></MsgType>");
        sb.append("<Music>");
        sb.append("<Title><![CDATA[").append(this.getMusic().getTitle()).append("]]></Title>");
        sb.append("<Description><![CDATA[").append(this.getMusic().getDescription()).append("]]></Description>");
        sb.append("<MusicUrl><![CDATA[").append(this.getMusic().getMusicUrl()).append("]]></MusicUrl>");
        sb.append("<HQMusicUrl><![CDATA[").append(this.getMusic().getHQMusicUrl()).append("]]></HQMusicUrl>");
        sb.append("<ThumbMediaId><![CDATA[").append(this.getMusic().getThumbMediaId()).append("]]></ThumbMediaId>");
        sb.append("</Music>");
        sb.append("</xml>");
        return sb.toString();
    }
}
