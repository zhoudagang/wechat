package what.fuck.wechat.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import what.fuck.service.IDeptService;
import what.fuck.wechat.constant.createMenuConstant;
import what.fuck.wechat.exception.WeixinException;
import what.fuck.wechat.pojo.Followers;
import what.fuck.wechat.pojo.OAuthToken;
import what.fuck.wechat.service.WeixinService;

@Controller
public class TestWechatController {

	@Resource
	private WeixinService wxService;
	
	@Resource
	private IDeptService deptService;
	
	@Resource
	private WeixinService weixinService;
	
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	@ResponseBody
	public String createWechatMenu() {
		try {
			wxService.createMenu1(createMenuConstant.CREATE_MENU_JSON);
		} catch (WeixinException e) {
			e.printStackTrace();
		}
		return "build success!!!";
	}
	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public Object list() throws WeixinException {
		OAuthToken token = weixinService.getOAuthToken();
		System.err.println(token.getAccess_token());
		System.err.println(token.getCreate_time());
		System.err.println(token.getExpires_in());
		
		Followers allUserList = weixinService.getAllUserList();
		List<String> openid = allUserList.getData().getOpenid();
		for (String s : openid) {
			weixinService.getUserInfo(s, "zh_CN");
		}
	    weixinService.deleteMenu();
		
		return deptService.findAll();
		
	}
}
