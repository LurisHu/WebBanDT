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
import javax.servlet.http.HttpServletResponse;

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

	public void setCookie(String key, String value, String path, Integer liveTime, HttpServletResponse response) {
		// create a cookie and add to
		Cookie cookie = new Cookie(key, value);
		cookie.setPath(path);
		cookie.setMaxAge(liveTime);// Second
		response.addCookie(cookie);
	}

	public void deleteCookie(String keyToDelete, HttpServletResponse response) {
		// create a cookie and add to
		Cookie cookie = new Cookie(keyToDelete, "");
		cookie.setPath("/");
		cookie.setMaxAge(0);// Second
		response.addCookie(cookie);
	}

	public void deleteAllCookies(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null)
			for (Cookie cookie : cookies) {
				cookie.setValue("");
				cookie.setPath("/");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
	}
}
