package what.fuck.test;

import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import what.fuck.StartSpringBootMain;
import what.fuck.wechat.config.Configuration;
import what.fuck.wechat.exception.WeixinException;
import what.fuck.wechat.pojo.OAuthToken;
import what.fuck.wechat.service.WeixinService;
import what.fuck.wechat.service.Impl.WeixinServiceimpl;

@SpringBootTest(classes = StartSpringBootMain.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class WeixinTest {

	@Resource
	private WeixinService weixinService;
	
	@Resource
	private WeixinServiceimpl weixinServiceImpl;
	
	
	@org.junit.Test
	public void testWeixin() throws WeixinException {
		
		String appid = Configuration.getProperty("wechat.oauth.appid");
		String secret = Configuration.getProperty("wechat.oauth.secret");
		OAuthToken token = weixinService.login(appid, secret, "client_credential");
		System.err.println(token.getAccess_token());
		System.err.println(token.getCreate_time());
		System.err.println(token.getExpires_in());
		
	}
	
	@org.junit.Test
	public void testWeixin1() throws WeixinException {
		OAuthToken token = weixinServiceImpl.getOAuthToken();
		System.err.println(token.getAccess_token());
		System.err.println(token.getCreate_time());
		System.err.println(token.getExpires_in());
	}
	
	
	
	
}
