package what.fuck.wechat.message;

/**
 * 微信发送被动响应消息的抽象类
 *
 * <p>
 * 应用程序需要定义一个子类，来实现具体方法</p>
 *
 */
@SuppressWarnings("serial")
public abstract class OutputMessage implements java.io.Serializable {

    /**
     * 接收方帐号（收到的OpenID）
     */
    private String ToUserName;
    /**
     * 开发者微信号
     */
    private String FromUserName;
    /**
     * 消息创建时间 （整型）
     */
    private Long CreateTime;

    /**
     * 获取 接收方帐号（收到的OpenID）
     *
     * @return 接收方帐号（收到的OpenID）
     */
    public String getToUserName() {
        return ToUserName;
    }

    /**
     * 设置 接收方帐号（收到的OpenID）
     *
     * @return 接收方帐号（收到的OpenID）
     */
    public String getFromUserName() {
        return FromUserName;
    }

    /**
     * 获取 消息创建时间 （整型）
     *
     * @return 消息创建时间 （整型）
     */
    public Long getCreateTime() {
        return CreateTime;
    }

    /**
     * 获取 消息类型
     *
     * @return 消息类型
     */
    public abstract String getMsgType();

    /**
     * 将对象转换为xml字符串
     *
     * @return 对象xml字符串
     */
    public abstract String toXML();

    public void setToUserName(String ToUserName) {
        this.ToUserName = ToUserName;
    }

    public void setFromUserName(String FromUserName) {
        this.FromUserName = FromUserName;
    }

    public void setCreateTime(Long CreateTime) {
        this.CreateTime = CreateTime;
    }
}
