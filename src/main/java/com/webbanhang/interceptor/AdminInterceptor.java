/*
*
* Fresher Academy 2019
* @author Kay
* @date Nov 27, 2019
* @version 1.8
* 
*/
package com.webbanhang.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.webbanhang.dao.NguoiDungDAO;
import com.webbanhang.service.CookieService;

@Component
public class AdminInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	HttpSession session;
	@Autowired
	CookieService cookieService;
	@Autowired
	NguoiDungDAO userDao;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (session.getAttribute("user") == null) {
			session.setAttribute("back-url", request.getRequestURI());
			response.sendRedirect("/account/login");
			return false;
		} else {
			if (!userDao.findById(Integer.parseInt(cookieService.getCookieFromUser("userId", request))).getIsAdmin()) {
				session.setAttribute("back-url", request.getRequestURI());
				session.setAttribute("message", "Email này không phải Admin");
				response.sendRedirect("/account/login");
				return false;
			}
			return true;
		}
	}
}
