package what.fuck.wechat.pojo;

public class Token {

	/**
	 * 凭证
	 */
	private String accessToken;

	/**
	 * 有效期，单位秒
	 */
	private int expiresIn;

	public String getAccessToken() {
		return this.accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public int getExpiresIn() {
		return this.expiresIn;
	}

	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}

}
