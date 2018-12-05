package what.fuck.wechat.pojo;

/**
 * 微信公众号对象
 *
 * <p>每一次请求即对应一个<tt>HttpClient</tt>，
 * 每次登陆产生一个<tt>OAuth</tt>用户连接,使用<tt>OAuthToken</tt>
 * 可以不用重复向微信平台发送登陆请求，在没有过期时间内，可继续请求。</p>
 *
 */
@SuppressWarnings("serial")
public class OAuth implements java.io.Serializable {

    private String appId = "";
    private String secret;

    /**
     * 创建微信公众号实例
     *
     * @param appId 第三方用户唯一凭证
     * @param secret 第三方用户唯一凭证密钥
     */
    public OAuth(String appId, String secret) {
        setAppId(appId);
        setSecret(secret);
    }

    /**
     * 获取 第三方用户唯一凭证
     *
     * @return 第三方用户唯一凭证
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置 第三方用户唯一凭证
     *
     * @param appId 第三方用户唯一凭证
     */
    public final void setAppId(String appId) {
        this.appId = null != appId ? appId : "";
    }

    /**
     * 获取 第三方用户唯一凭证密钥
     *
     * @return 第三方用户唯一凭证密钥
     */
    public String getSecret() {
        return secret;
    }

    /**
     * 设置 第三方用户唯一凭证密钥
     *
     * @param secret 第三方用户唯一凭证密钥
     */
    public final void setSecret(String secret) {
        this.secret = null != secret ? secret : "";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof OAuth)) {
            return false;
        }

        OAuth oAuth = (OAuth) o;

        if (oAuth.getAppId() == null || !this.appId.equals(oAuth.getAppId())) {
            return false;
        }
        if (oAuth.getSecret() == null || !this.secret.equals(oAuth.getSecret())) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = this.appId != null ? this.appId.hashCode() : 0;
        result = 31 * result + (this.secret != null ? this.secret.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "{appid='" + this.appId + "',secret='" + this.secret + "'}";
    }
}
