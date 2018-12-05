package what.fuck.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class AuthInterceptor implements HandlerInterceptor {

	private static Logger logger = Logger.getLogger(AuthInterceptor.class);

	/**
	 * 执行时机：进入controller方法之前执行 使用场景：用于用户认证、用户授权拦截
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		logger.info("%%%% preHandle %%%%");

		return true;
	}

	/**
	 * 执行时机：进入action方法，在返回modelAndView之前执行 使用场景：在这里统一对返回数据进行处理，比如统一添加菜单 导航
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("%%%% postHandle %%%%");
	}

	/**
	 * 执行时机:action方法执行完成，已经 返回modelAndView，执行。 使用场景：统一处理系统异常，在这里统一记录系统日志
	 * 监控action方法执行时间，在preHandle记录开始时间，在afterCompletion记录结束时间
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("%%%% afterCompletion %%%%");
	}

}
