package Intercetptor;

import java.net.InetAddress;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {
	
	
	
	
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
				return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public boolean preHandlea(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		request.getLocalAddr();
		System.out.println("preHandle..............................");
		
		//获取本机ip
		String ip = InetAddress.getLocalHost().getHostAddress();
		System.out.println(ip);
		
		//获取客户端ip
//      boolean b = Pattern.matches("(192.*.*.*)||(10.*.*.*)",request.getRemoteAddr().toString());
//		if (b) {
//			return false;
//		}else {
//			return true;
//		}
		if (ip.substring(0, 3).contains("19")||ip.substring(0, 3).contains("10")) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("postHandle..............................");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("afterCompletion..............................");
	}

}
