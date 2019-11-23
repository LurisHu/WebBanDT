package com.webbanhang.controller.customer;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webbanhang.dao.NguoiDungDAO;
import com.webbanhang.entity.NguoiDung;
import com.webbanhang.service.EmailService;

@Controller
public class AccountController {
	@Autowired
	NguoiDungDAO dao;

	@Autowired
	HttpSession session;

	@Autowired
	EmailService mailer;
//	@GetMapping("/account/login")
//	public String login() {
//		return "redirect:/customer/sanpham/index";
//	}
//	

	@GetMapping(value = { "account/login", "login" })
	public String login(Model model) {
		model.addAttribute("nd", new NguoiDung());
		return "account/login/index";
	}

	@PostMapping("/account/login")
	public String login(Model model, @RequestParam("email") String email, @RequestParam("password") String pw) {
		model.addAttribute("nd", dao.findByEmail(email));
		NguoiDung user = dao.findByEmail(email);
		session.setAttribute("user", user);
		if (user == null) {
			model.addAttribute("message", "Email không tồn tại");
		} else if (!pw.equals(user.getMatKhau())) {
			model.addAttribute("message", "Mật khẩu không chính xác");
		} else {
			model.addAttribute("message", "Đăng nhập thành công");
			if (user.getIsAdmin() == true) {
				return "redirect:/admin/dashboard/index";
			} else {
				return "redirect:/customer/sanpham/index";
			}
		}
		return "account/login/index";
	}

	@GetMapping(value = { "account/register", "register" })
	public String index(Model model) {
		model.addAttribute("nd", new NguoiDung());
		return "account/register/index";
	}

	@PostMapping(value = { "account/register", "register" })
	public String create(@Validated @ModelAttribute("nd") NguoiDung nd, BindingResult errors,
			HttpServletResponse response, Model model) {
		// Set default values to create customer
		nd.setLoaiKH(0);
		nd.setIsAdmin(false);
		nd.setIsActive(false);
		// create account

		if (errors.hasErrors() || (dao.findByEmail(nd.getEmail()) != null && !(nd.getEmail().isEmpty()))) {
			model.addAttribute("message", "Xin vui lòng sửa các lỗi sau đây");
			if (dao.findByEmail(nd.getEmail()) != null && !(nd.getEmail().isEmpty())) {
				model.addAttribute("checkEmail", "Email đã được sử dụng. Vui lòng chọn email khác!");
			}
		} else {
			try {
				dao.create(nd);
				String activeKey = DigestUtils.sha1Hex(nd.getMaNguoiDung() + nd.getEmail() + (new Date()));
				String message = "Xin chào " + nd.getHoTen()
						+ "! \nBạn đã đăng ký tài khoản thành công\nĐể hoàn tất đăng ký, bạn vui lòng nhấp vào link này:\n"
						+ "http://localhost:8080/active?id=" + nd.getMaNguoiDung() + "&activeKey=" + activeKey
						+ "\n(Hoặc copy đường link và paste vào trình duyệt web)\nLink sẽ hết hạn sau 24 tiếng\nBan quản trị web, trân trọng!";
				// create a cookie
				Cookie cookie = new Cookie("activeKey", activeKey);
				cookie.setPath("/");
				cookie.setMaxAge(86400);// Limit time of cookie 86400 second = 24 hours
				// add cookie to response
				response.addCookie(cookie);

				mailer.sendEmail(nd.getEmail(),
						"Xin chào bạn " + nd.getHoTen() + ", chúc mừng bạn đã đăng ký thành công", message);
				model.addAttribute("message", "Đăng ký thành công");
			} catch (Exception e) {
				model.addAttribute("message", "Đăng ký thất bại");
			}
		}
		return "account/register/index";
	}

	@RequestMapping("/account/logout")
	public String logout(HttpServletRequest req, HttpServletResponse resp) {
		// remove session
		session.removeAttribute("user");
		// remove cookies
		Cookie[] cookies = req.getCookies();
		if (cookies != null)
			for (Cookie cookie : cookies) {
				cookie.setValue("");
				cookie.setPath("/");
				cookie.setMaxAge(0);
				resp.addCookie(cookie);
			}
		return "redirect:/customer/sanpham/index";
	}

	@GetMapping("active")
	public String activeAccount(HttpServletResponse response,
			@CookieValue(value = "activeKey", defaultValue = "none") String activeKeyCookies,
			@RequestParam("id") Integer userId, @RequestParam("activeKey") String activeKeyFromEmail) {
		if (activeKeyCookies.equals(activeKeyFromEmail)) {
			NguoiDung user = dao.findById(userId);
			user.setIsActive(true);
			dao.update(user);

			// create a cookie
			Cookie cookie = new Cookie("activeKey", "");
			cookie.setPath("/");
			cookie.setMaxAge(0);// Delete cookie
			// add cookie to response
			response.addCookie(cookie);
		} else {
			// Some code if need
		}
		return "account/login/index";
	}
}
