package what.fuck.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import what.fuck.service.MessageService;
import what.fuck.util.controller.AbstractBaseResource;

@RestController
public class test extends AbstractBaseResource {
	
	@Resource
	private MessageService message;
	
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String index() {
		return message.info();
	}
	
	
	//读取配置文件
	@RequestMapping(value="/zhou",method=RequestMethod.GET)
	public String zhou() {
		System.out.println("【~~~访问地址~~~】"+super.getMessage("welcome.url"));
		return "gang";
	}
	
	
	
	@SuppressWarnings("deprecation")
	@RequestMapping("/object")
	public String object(HttpServletRequest request,HttpServletResponse response) {
		System.err.println("%%%% 客户端IP地址:" + request.getRemoteAddr());
		System.err.println("%%%% 获取客户端响应代码:" + request.getCharacterEncoding());
		System.err.println("%%%% 获取SessionID:" + request.getSession().getId());
		System.err.println("%%%% 获取真是路径:" + request.getRealPath("/upload"));
		return "zhougang";
	}

	

	@RequestMapping(value="/echo/{message}",method=RequestMethod.GET)
	public String echo(@PathVariable("message") String message) {
		return "=dd=="+message;
	}
	
	


}
