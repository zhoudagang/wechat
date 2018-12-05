package what.fuck.wechat.exception;

/**
 *
 * 微信操作全局异常
 *
 */
@SuppressWarnings("serial")
public class WeixinException extends Exception {

	public WeixinException(String msg) {
		super(msg);
	}

	public WeixinException(Exception cause) {
		super(cause);
	}

	public WeixinException(String msg, Exception cause) {
		super(msg, cause);
	}
}
