package what.fuck.wechat.service;

import org.springframework.stereotype.Service;

import what.fuck.wechat.exception.WeixinException;
import what.fuck.wechat.pojo.Followers;
import what.fuck.wechat.pojo.Menu;
import what.fuck.wechat.pojo.OAuthToken;
import what.fuck.wechat.pojo.User;

@Service
public interface WeixinService {

	/**
	 * 向微信平台发送获取access_token请求
	 *
	 * @param appId
	 *            第三方用户唯一凭证
	 * @param secret
	 *            第三方用户唯一凭证密钥，既appsecret
	 * @param grantType
	 *            获取access_token填写client_credential
	 * @return 用户凭证
	 * @throws WeixinException
	 */
	OAuthToken login(String appId, String secret, String grantType) throws WeixinException;

	/**
	 * 获取登录后的OAuthToken对象
	 *
	 * @return 如果已登录过返回OAuthToken对象，否则返回null
	 */
	OAuthToken getOAuthToken();

	/**
	 * 验证用户登录 调用所有方法之前，应先调用此方法检查用户是否已经登录，或者Token是否失效
	 * 如果没有登录，则跑出异常提示登录，如果失效，密码正确的情况下回自动重新登录。
	 */
	void checkLogin() throws WeixinException;

	/**
	 * 获取用户对象
	 *
	 * <p>
	 * 通过公众号，返回用户对象，进行用户相关操作
	 * </p>
	 *
	 * @param openId
	 *            普通用户的标识，对当前公众号唯一
	 * @param lang
	 *            国家地区语言版本 zh_CN 简体，zh_TW 繁体，en 英语
	 * @return 用户对象
	 * @throws WeixinException
	 */
	User getUserInfo(String openId, String lang) throws WeixinException;

	/**
	 * 获取所有关注者列表
	 *
	 * <p>
	 * 通过公众号，返回用户对象，进行用户相关操作
	 * </p>
	 *
	 * @return 关注者对象
	 * @throws WeixinException
	 */
	Followers getAllUserList() throws WeixinException;

	/**
	 * 获取关注者列表
	 *
	 * <p>
	 * 通过公众号，返回用户对象，进行用户相关操作
	 * </p>
	 *
	 * @param next_openid
	 *            第一个拉取的OPENID，不填默认从头开始拉取
	 * @return 关注者对象
	 * @throws WeixinException
	 *             when Weixin service or network is unavailable, or the user has
	 *             not authorized
	 */
	Followers getUserList(String next_openid) throws WeixinException;

	/**
	 * 创建自定义菜单
	 *
	 * @param menu
	 *            菜单对象
	 * @throws WeixinException
	 *             创建自定义菜单异常
	 */
	void createMenu(Menu menu) throws WeixinException;
	
	void createMenu1(String str) throws WeixinException;

	/**
	 * 删除自定义菜单
	 *
	 * @throws WeixinException
	 *             删除自定义菜单异常
	 */
	public void deleteMenu() throws WeixinException;
}
