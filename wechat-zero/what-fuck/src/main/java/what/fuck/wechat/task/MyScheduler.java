package what.fuck.wechat.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import what.fuck.wechat.config.Configuration;
import what.fuck.wechat.exception.WeixinException;
import what.fuck.wechat.service.WeixinService;

@Component
public class MyScheduler {

	private final Logger log = LoggerFactory.getLogger(MyScheduler.class);
	@Resource
	private WeixinService weixinService;

	// 項目啓動時啓動一次 ，然后每30分钟跑一次 保持心跳
	@Scheduled(initialDelay = 0, fixedRate = 1000 * 60 * 30)
	public void getAccessToken() throws WeixinException {
		String appid = Configuration.getProperty("wechat.oauth.appid");
		String secret = Configuration.getProperty("wechat.oauth.secret");
		weixinService.login(appid, secret, "client_credential");
		log.info("【*** 向微信平台发送获取access_token请求 - 间隔调度 ***】"
				+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	}

}
