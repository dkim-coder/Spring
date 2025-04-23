package com.ssafy.ws.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SessionInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("loginUser")!= null) {
			log.info("SessionInterceptor login user!");
			return true;
		}else {
			log.info("SessionInterceptor login fail!");

			response.sendRedirect(request.getContextPath()+"/");
			return false;
		}
		
	}

}
