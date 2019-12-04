/*
*
* Fresher Academy 2019
* @author Kay
* @date Dec 4, 2019
* @version 1.8
* 
*/
package com.webbanhang.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
@Service
public class CookieService {
	public String getCookieFromUser(String keyOfCookie, HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		String result = null;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(keyOfCookie)) {
					result = cookie.getValue();
				}
			}
		}
		return result;
	}
}
