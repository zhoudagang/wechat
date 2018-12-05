package what.fuck.wechat.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import what.fuck.wechat.config.Configuration;
import what.fuck.wechat.spi.DefaultMessageHandler;
import what.fuck.wechat.util.SHA1;

@Controller
public class AccessToWechatController {

	@RequestMapping(value = "/wxinit")
	public void wxinit(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// 微信服务器将发送GET请求到填写的URL上,这里需要判定是否为GET请求
		// 因为微信 GET请求是首次绑定发来的请求,POST是 当普通微信用户向公众账号发消息时，微信服务器将POST消息的XML数据包到开发者填写的URL上。
		boolean isGet = request.getMethod().toLowerCase().equals("get");

		System.out.println("获得微信请求:" + request.getMethod() + " 方式");
		System.out.println("微信请求URL:" + request.getServletPath());

		// 消息来源可靠性验证
		String signature = request.getParameter("signature");// 微信加密签名
		String timestamp = request.getParameter("timestamp");// 时间戳
		String nonce = request.getParameter("nonce"); // 随机数
		String token = Configuration.getProperty("wechat.token");
		if (isGet) {
			String echostr = request.getParameter("echostr");
			// 确认此次GET请求来自微信服务器，原样返回echostr参数内容，则接入生效，成为开发者成功，否则接入失败
			if (checkSignature(token, signature, timestamp, nonce)) {
				response.getWriter().write(echostr);
			}
		} else {
			// 确认此次GET请求来自微信服务器，原样返回echostr参数内容，则接入生效，成为开发者成功，否则接入失败
			if (!checkSignature(token, signature, timestamp, nonce)) {
				// 消息不可靠，直接返回
				response.getWriter().write("");
				return;
			}
			//用户每次向公众号发送消息、或者产生自定义菜单点击事件时，响应URL将得到推送
            sendMessages(request, response);
			
		}

	}
	
    //当普通微信用户向公众账号发消息时，微信服务器将POST消息的XML数据包到开发者填写的URL上
    //用户在关注与取消关注公众号时，微信会把这个事件推送到开发者填写的URL
    //用户每次发送语音给公众号时，微信会在推送的语音消息XML数据包中，增加一个Recongnition字段
    private void sendMessages(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/xml");
            //获取POST流
            ServletInputStream in = request.getInputStream();
            if (Configuration.isDebug()) {
                System.out.println("接收到微信输入流,准备处理...");
            }
         //  IMessageHandler messageHandler = HandlerFactory.getMessageHandler();
            DefaultMessageHandler messageHandler = new DefaultMessageHandler();
            //处理输入消息，返回结果
            String xml = messageHandler.invoke(in);
            //返回结果
            response.getWriter().write(xml);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.getWriter().write("");
        }
    }
	

	/**
	 * 加密/校验流程如下：
	 *
	 * <p>
	 * 1. 将token、timestamp、nonce三个参数进行字典序排序<br>
	 * 2.将三个参数字符串拼接成一个字符串进行sha1加密<br>
	 * 3. 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信<br>
	 * </p>
	 *
	 * @param token
	 *            Token验证密钥
	 * @param signature
	 *            微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数，nonce参数
	 * @param timestamp
	 *            时间戳
	 * @param nonce
	 *            随机数
	 * @return 验证成功返回true,否则返回false
	 */
	private boolean checkSignature(String token, String signature, String timestamp, String nonce) {
		List<String> params = new ArrayList<String>();
		params.add(token);
		params.add(timestamp);
		params.add(nonce);
		// 1. 将token、timestamp、nonce三个参数进行字典序排序
		Collections.sort(params, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		// 2. 将三个参数字符串拼接成一个字符串进行sha1加密
		String temp = SHA1.encode(params.get(0) + params.get(1) + params.get(2));
		// 3. 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
		return temp.equals(signature);
	}
	
	
	
	
	
	
	
	

}
