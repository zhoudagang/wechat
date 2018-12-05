package what.fuck.wechat.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import what.fuck.wechat.config.Configuration;
import what.fuck.wechat.exception.WeixinException;
import what.fuck.wechat.pojo.Data;
import what.fuck.wechat.pojo.Followers;
import what.fuck.wechat.pojo.Menu;
import what.fuck.wechat.pojo.OAuth;
import what.fuck.wechat.pojo.OAuthToken;
import what.fuck.wechat.pojo.Response;
import what.fuck.wechat.pojo.User;
import what.fuck.wechat.service.WeixinService;
import what.fuck.wechat.util.HttpsClient;
import what.fuck.wechat.util.WeixinSupport;

@Service
public class WeixinServiceimpl extends WeixinSupport implements WeixinService {

	/**
	 * access_token过期自动登录，默认是
	 */
	private boolean access_token_auto_login = true;
	/**
	 * 公众号对象
	 */
	private OAuth oauth = null;
	/**
	 * 公众号Token对象
	 */
	private OAuthToken oauthToken = null;

	/**
	 * 微信基础支持
	 *
	 * 默认Access_Token过期后会自动重新登录
	 */
	public WeixinServiceimpl() {
	}

	/**
	 * 微信基础支持
	 *
	 * @param access_token_auto_login
	 *            是否自动登录
	 */
	public WeixinServiceimpl(boolean access_token_auto_login) {
		this.access_token_auto_login = access_token_auto_login;
	}

	/**
	 * 获取登录后的OAuthToken对象
	 *
	 * @return 如果已登录过返回OAuthToken对象，否则返回null
	 */
	@Override
	public OAuthToken getOAuthToken() {
		return oauthToken;
	}

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
	@Override
	public OAuthToken login(String appId, String secret, String grantType) throws WeixinException {

		if (appId == null || secret == null || appId.equals("") || secret.equals("") || grantType == null
				|| grantType.equals("")) {
			throw new WeixinException("invalid null, appid or secret is null.");
		}
		// 发送登陆请求验证，由于接口有频率限制，所以，一次请求后，在过期时间内，不在进行第二次请求
		// 所以先从当前HttpClient内验证OAuthToken是否已验证，并且未过期
		if (this.oauth != null && this.oauthToken != null) {
			// 判断是否过期
			if (!oauthToken.isExprexpired()) {
				// 先验证用户公众号信息是否一致，不一致则需要重新登录获取
				if (this.oauth.getAppId().equals(appId) && this.oauth.getSecret().equals(secret)) {
					// 如果没有过期，则直接返回对象
					return oauthToken;
				}
			}
		}
		// 拼接参数
		String param = "?grant_type=" + grantType + "&appid=" + appId + "&secret=" + secret;
		// 创建请求对象
		HttpsClient http = new HttpsClient();
		// 调用获取access_token接口
		Response res = http.get("https://api.weixin.qq.com/cgi-bin/token" + param);
		// 根据请求结果判定，是否验证成功
		JSONObject jsonObj = res.asJSONObject();
		if (jsonObj != null) {
			if (Configuration.isDebug()) {
				System.out.println("login返回json：" + jsonObj.toString());
			}
			Object errcode = jsonObj.get("errcode");
			if (errcode != null) {
				// 返回异常信息
				throw new WeixinException(getCause(Integer.parseInt(errcode.toString())));
			}
			// 判断是否登录成功，并判断过期时间
			Object obj = jsonObj.get("access_token");
			// 登录成功，设置accessToken和过期时间
			if (obj != null) {
				// 设置公众号信息
				oauth = new OAuth(appId, secret);
				// 设置凭证
				this.oauthToken = (OAuthToken) JSONObject.toJavaObject(jsonObj, OAuthToken.class);
			
			}
		}
		return oauthToken;

	}
	
	 /**
     * 验证用户登录
     *
     * <p>
     * 调用所有方法之前，应先调用此方法检查用户是否已经登录，或者Token是否失效<br/>
     * 如果没有登录，则跑出异常提示登录，如果失效，密码正确的情况下回自动重新登录。</p>
     *
     * @throws WeixinException
     */
	@Override
	public void checkLogin() throws WeixinException {
		  //自动登录，才验证是否过期，否则不验证，默认不过期
        if (access_token_auto_login) {
            //判断是否过期，如果已过期，则发送重新登录命令
            if (oauthToken == null) {
                throw new WeixinException("oauthToken is null,you must call login or init first!");
            } else //已过期
            if (oauthToken.isExprexpired()) {
                //如果用户名和密码正确，则自动登录，否则返回异常
                if (oauth != null) {
                    //自动重新发送登录请求
                    login(oauth.getAppId(), oauth.getSecret(),"client_credential");
                } else {
                    throw new WeixinException("oauth is null and oauthToken is exprexpired, please log in again!");
                }
            }
        }		
	}
	
	 /**
     * 获取用户对象
     *
     * <p>
     * 通过公众号，返回用户对象，进行用户相关操作</p>
     *
     * @param openId 普通用户的标识，对当前公众号唯一
     * @param lang 国家地区语言版本 zh_CN 简体，zh_TW 繁体，en 英语
     * @return 用户对象
     * @throws WeixinException
     */
	@Override
	public User getUserInfo(String openId, String lang) throws WeixinException {
		 //必须先调用检查登录方法
        checkLogin();
        //拼接参数
        String param = "?access_token=" + this.oauthToken.getAccess_token() + "&openid=" + openId + "&lang=" + lang;
        //创建请求对象
        HttpsClient http = new HttpsClient();
        //调用获取access_token接口
        Response res = http.get("https://api.weixin.qq.com/cgi-bin/user/info" + param);
        //根据请求结果判定，是否验证成功
        JSONObject jsonObj = res.asJSONObject();
        if (jsonObj != null) {
            if (Configuration.isDebug()) {
                System.out.println("getUserInfo返回json：" + jsonObj.toString());
            }
            Object errcode = jsonObj.get("errcode");
            if (errcode != null) {
                //返回异常信息
                throw new WeixinException(getCause(Integer.parseInt(errcode.toString())));
            }
            //设置公众号信息
            return JSONObject.toJavaObject(jsonObj, User.class);
        }
        return null;
	}

	@Override
	public Followers getAllUserList() throws WeixinException {
		 Followers allFollower = new Followers();
	        int toatl = 0;
	        int count = 0;
	        Data data = new Data();
	        data.setOpenid(new ArrayList<String>());
	        allFollower.setData(data);
	        String next_openid = "";
	        do {
	            Followers f = getUserList(next_openid);
	            if (f == null) {
	                break;
	            }
	            if (f.getCount() > 0) {
	                count += f.getCount();
	                toatl += f.getTotal();
	                List<String> openids = f.getData().getOpenid();
	                for (String openid : openids) {
	                    allFollower.getData().getOpenid().add(openid);
	                }
	            }
	            next_openid = f.getNext_openid();
	        } while (next_openid != null && !next_openid.equals(""));
	        allFollower.setCount(count);
	        allFollower.setTotal(toatl);
	        return allFollower;
	}

	@Override
	public Followers getUserList(String next_openid) throws WeixinException {
		 //拼接参数
        String param = "?access_token=" + this.oauthToken.getAccess_token() + "&next_openid=";
        //第一次获取不添加参数
        if (next_openid != null && !next_openid.equals("")) {
            param += next_openid;
        }
        //创建请求对象
        HttpsClient http = new HttpsClient();
        //调用获取access_token接口
        Response res = http.get("https://api.weixin.qq.com/cgi-bin/user/get" + param);
        //根据请求结果判定，是否验证成功
        JSONObject jsonObj = res.asJSONObject();
        Followers follower = null;
        if (jsonObj != null) {
            if (Configuration.isDebug()) {
                System.out.println("getUserList返回json：" + jsonObj.toString());
            }
            Object errcode = jsonObj.get("errcode");
            if (errcode != null) {
                //返回异常信息
                throw new WeixinException(getCause(Integer.parseInt(errcode.toString())));
            }
            follower = (Followers) JSONObject.toJavaObject(jsonObj, Followers.class);
        }
        return follower;
	}

	@Override
	public void createMenu(Menu menu) throws WeixinException {
		  //必须先调用检查登录方法
        checkLogin();
        //内部业务验证
        if (menu == null || menu.getButton() == null) {
            throw new IllegalStateException("menu is null!");
        }
        //创建请求对象
        HttpsClient http = new HttpsClient();
        //调用获取access_token接口
        Response res = http.post("https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + this.oauthToken.getAccess_token(), menu.toJSONObject());
        //根据请求结果判定，是否验证成功
        JSONObject jsonObj = res.asJSONObject();
        if (jsonObj != null) {
            if (Configuration.isDebug()) {
                System.out.println("createMenu返回json：" + jsonObj.toString());
            }
            Object errcode = jsonObj.get("errcode");
            if (errcode != null && !errcode.toString().equals("0")) {
                //返回异常信息
                throw new WeixinException(getCause(Integer.parseInt(errcode.toString())));
            }
        }
		
	}

	@Override
	public void deleteMenu() throws WeixinException {
		 //必须先调用检查登录方法
        checkLogin();
        //创建请求对象
        HttpsClient http = new HttpsClient();
        //调用获取access_token接口
        Response res = http.get("https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=" + this.oauthToken.getAccess_token());
        //根据请求结果判定，是否验证成功
        JSONObject jsonObj = res.asJSONObject();
        if (jsonObj != null) {
            if (Configuration.isDebug()) {
                System.out.println("deleteMenu返回json：" + jsonObj.toString());
            }
            Object errcode = jsonObj.get("errcode");
            if (errcode != null && !errcode.toString().equals("0")) {
                //返回异常信息
                throw new WeixinException(getCause(Integer.parseInt(errcode.toString())));
            }
        }		
	}

	@Override
	public void createMenu1(String str) throws WeixinException {
		  //必须先调用检查登录方法
        checkLogin();
        
         JSONObject parseObject = JSONObject.parseObject(str);
        //创建请求对象
        HttpsClient http = new HttpsClient();
        //调用获取access_token接口
        Response res = http.post("https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + this.oauthToken.getAccess_token(), parseObject);
        //根据请求结果判定，是否验证成功
        JSONObject jsonObj = res.asJSONObject();
        if (jsonObj != null) {
            if (Configuration.isDebug()) {
                System.out.println("createMenu返回json：" + jsonObj.toString());
            }
            Object errcode = jsonObj.get("errcode");
            if (errcode != null && !errcode.toString().equals("0")) {
                //返回异常信息
                throw new WeixinException(getCause(Integer.parseInt(errcode.toString())));
            }
        }		
	}

}
