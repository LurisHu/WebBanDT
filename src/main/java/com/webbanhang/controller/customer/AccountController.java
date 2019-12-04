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
	public String login(Model model,HttpServletResponse response,
			@RequestParam("email") String email,
			@RequestParam("password") String pw) {
		model.addAttribute("nd", dao.findByEmail(email));
		NguoiDung user = dao.findByEmail(email);
		if (user == null) {
			model.addAttribute("message", "Email không tồn tại");
		} else if (!pw.equals(user.getMatKhau())) {
			model.addAttribute("message", "Mật khẩu không chính xác");
		} else {
			model.addAttribute("message", "Đăng nhập thành công");
			session.setAttribute("user", user);
			session.setAttribute("userRole", user.getIsAdmin());
			System.out.println(session.getAttribute("userRole"));
			String url = (String) session.getAttribute("back-url");

			// create a cookie
			Cookie cookie = new Cookie("userId", user.getMaNguoiDung().toString());
			cookie.setPath("/");
			// add cookie to response
			response.addCookie(cookie);
			if (url != null) {
				System.out.println(url);
				if(url.equals("/cart/thanhtoan")) {
					return "redirect:/cart/view";
				}
				return "redirect:" + url;
			} else if (user.getIsAdmin() == true) {
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

				// create a cookie
				Cookie cookie = new Cookie("activeKey", activeKey);
				cookie.setPath("/");
				cookie.setMaxAge(86400);// Limit time of cookie 86400 second = 24 hours
				// add cookie to response
				response.addCookie(cookie);

				String message = "Xin chào " + nd.getHoTen()
						+ "! \nBạn đã đăng ký tài khoản thành công\nĐể hoàn tất đăng ký, bạn vui lòng nhấp vào link này:\n"
						+ "http://localhost:8080/active?id=" + nd.getMaNguoiDung() + "&activeKey=" + activeKey
						+ "\n(Hoặc copy đường link và paste vào trình duyệt web)\nLink sẽ hết hạn sau 24 tiếng\nBan quản trị web, trân trọng!";

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

	@GetMapping(value = { "account/forgot-password", "forgot", "forgot-password" })
	public String forgot() {
		return "account/forgot/index";
	}

	@PostMapping(value = "account/forgot-password")
	public String forgot(@RequestParam("email") String email, Model model, HttpServletResponse response) {
		if (dao.findByEmail(email) != null) {
			NguoiDung nd = dao.findByEmail(email);

			String validateKey = DigestUtils.sha1Hex(email + (new Date()));
			// create a cookie
			Cookie cookieValidateKey = new Cookie("validateKey", validateKey);

			cookieValidateKey.setPath("/");
			cookieValidateKey.setMaxAge(86400);// Limit time of cookie 86400 second = 24 hours

			Cookie cookieId = new Cookie("id", nd.getMaNguoiDung().toString());

			cookieId.setPath("/");
			cookieId.setMaxAge(86400);// Limit time of cookie 86400 second = 24 hours
			// add cookie to response
			response.addCookie(cookieValidateKey);
			response.addCookie(cookieId);

			String message = "Xác nhận yêu cầu cập nhật lại mật khẩu" + "Xin chào " + dao.findByEmail(email).getHoTen()
					+ "!" + "http://localhost:8080/reset?validateKey=" + validateKey
					+ "\n(Hoặc copy đường link và paste vào trình duyệt web)\nLink sẽ hết hạn sau 24 tiếng\nBan quản trị web, trân trọng!";

			mailer.sendEmail(email, "Xin chào bạn " + nd.getHoTen() + ", chúc mừng bạn đã đăng ký thành công", message);
			model.addAttribute("message", "Một link hướng dẫn lấy lại mật khẩu đã được gửi đến email " + email + ".");
		} else {
			model.addAttribute("message", "Email này chưa đăng ký tài khoản tại web, vui lòng kiểm tra lại!");
		}
		return "account/forgot/index";
	}

	@GetMapping("reset")
	public String resetPassword(HttpServletResponse response,
			@CookieValue(value = "validateKey", defaultValue = "not") String validateKeyCookies,
			@CookieValue(value = "id", defaultValue = "none") String userIdCookie,
			@RequestParam(value = "validateKey", defaultValue = "none") String validateKeyFromEmail, Model model) {
		if (validateKeyCookies.equals(validateKeyFromEmail)) {
			model.addAttribute("isValidValidate", true);
			model.addAttribute("validateKeyFromEmail", validateKeyFromEmail);
		} else {
			model.addAttribute("isValidValidate", false);
		}
		return "account/reset/index";
	}

	@PostMapping("reset")
	public String resetPassword(HttpServletResponse response,
			@CookieValue(value = "validateKey", defaultValue = "not") String validateKeyCookies,
			@CookieValue(value = "id", defaultValue = "none") String userIdCookie,
			@RequestParam(value = "validateKey", defaultValue = "null") String validateKeyFromEmail, Model model,
			@RequestParam("password") String pwd, @RequestParam("re-password") String repwd) {
		if (validateKeyCookies.equals(validateKeyFromEmail)) {
			if (pwd.equals(repwd)) {
				NguoiDung user = dao.findById(Integer.parseInt(userIdCookie));
				user.setMatKhau(pwd);
				dao.update(user);
				model.addAttribute("message", "Đã thay đổi mật khẩu mới thành công!");
				model.addAttribute("isValidValidate", true);
			} else {
				model.addAttribute("message", "Mật khẩu bạn nhập không khớp! Vui lòng kiểm tra lại");
			}
			// create a cookie
			Cookie cookieValidate = new Cookie("validateKey", "");
			cookieValidate.setPath("/");
			cookieValidate.setMaxAge(0);// Delete cookie
			// add cookie to response
			response.addCookie(cookieValidate);
			// create a cookie
			Cookie cookieId = new Cookie("id", "");
			cookieId.setPath("/");
			cookieId.setMaxAge(0);// Delete cookie
			// add cookie to response
			response.addCookie(cookieId);
		} else {
			model.addAttribute("isValidValidate", false);
		}
		return "account/reset/index";
	}
}
