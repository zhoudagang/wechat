package what.fuck.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import what.fuck.entity.vo.Message;
import what.fuck.service.IDeptService;
import what.fuck.util.controller.AbstractBaseResource;
import what.fuck.wechat.exception.WeixinException;
import what.fuck.wechat.pojo.Followers;
import what.fuck.wechat.pojo.OAuthToken;
import what.fuck.wechat.pojo.User;
import what.fuck.wechat.service.WeixinService;

@Controller
public class MessageController extends AbstractBaseResource {

	//增加日志
    private final Logger log = LoggerFactory.getLogger(MessageController.class);
	@Resource
	private IDeptService deptService;
	
	@Resource
	private WeixinService weixinService;
	
	
	
	
	
	@RequestMapping(value = "/list2", method = RequestMethod.GET)
	@ResponseBody
	public Object list2() {
		log.info("%%%%查询部门所有数据%%%%");
		return deptService.findAll2();
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	@ResponseBody
	public String get() {
		System.out.println(10/0);
		return "hello world";
	}
	
	
	
	@RequestMapping(value = "/addPre", method = RequestMethod.GET)
	public String addPre() {
		return "add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Message add(Message message) {
		return message;
	}

	@RequestMapping(value = "/showInfo", method = RequestMethod.GET)
	public String show(Model model) {
		model.addAttribute("url", "www.baidu.com");
		model.addAttribute("name", "zhougang");
		return "show";
	}

}
