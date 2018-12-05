package what.fuck.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // 作为一个控制层的切面处理 AOP概念
public class GlobalExceptionHandler {

	public static final String DEFAULT_ERROR_VIEW = "error"; // 定义错误显示页，error.html

	@ExceptionHandler(Exception.class) // 所有的异常都是Exception子类
	public Object defaultErrorHandler(HttpServletRequest request, Exception e) {
		ErrorInfo info = new ErrorInfo();
		info.setCode(101); // 标记一个错误信息类型
		info.setMessage(e.getMessage());
		info.setUrl(request.getRequestURL().toString());
		return info;
	}

}
