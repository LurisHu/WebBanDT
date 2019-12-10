package com.webbanhang.controller.admin;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webbanhang.dao.NguoiDungDAO;
import com.webbanhang.entity.NguoiDung;
import com.webbanhang.service.EmailService;

@Controller
public class QuanLyNguoiDungController {
	@Autowired
	NguoiDungDAO dao;

	@Autowired
	EmailService mailer;

	// Admin
	@RequestMapping("admin/nguoidung/admin/index/{pageNo}")
	public String index(Model model, @PathVariable("pageNo") int pageNo) {
		if (pageNo >= dao.getPageCountAdmin()) {
			pageNo = 0;
		} else if (pageNo < 0) {
			pageNo = dao.getPageCountAdmin() - 1;
		}
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("lastPageNo", dao.getPageCountAdmin() - 1);
		model.addAttribute("nds", dao.findPageAdmin(pageNo));
		model.addAttribute("nd", new NguoiDung());
		return "admin/nguoidung/admin/index";
	}

	// Thêm Admin
	@GetMapping("admin/nguoidung/admin/create")
	public String create(Model model) {
		model.addAttribute("nd", new NguoiDung());
		model.addAttribute("nds", dao.findPageAdmin(0));
		model.addAttribute("lastPageNo", dao.getPageCountAdmin() - 1);
		return "admin/nguoidung/admin/index";
	}

	@PostMapping("admin/nguoidung/admin/create")
	public String create(Model model, @Validated @ModelAttribute("nd") NguoiDung nd, BindingResult errors,
			HttpServletResponse response) {
		nd.setIsActive(false);
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
						+ "! \nBạn đã thêm tài khoản thành công\nĐể hoàn tất thêm tài khoản, bạn vui lòng nhấp vào link này:\n"
						+ "http://localhost:8080/active?id=" + nd.getMaNguoiDung() + "&activeKey=" + activeKey
						+ "\n(Hoặc copy đường link và paste vào trình duyệt web)\nLink sẽ hết hạn sau 24 tiếng\nBan quản trị web, trân trọng!";
				// create a cookie
				Cookie cookie = new Cookie("activeKey", activeKey);
				cookie.setPath("/");
				cookie.setMaxAge(86400);// Limit time of cookie 86400 second = 24 hours
				// add cookie to response
				response.addCookie(cookie);

				mailer.sendEmail(nd.getEmail(),
						"Xin chào bạn " + nd.getHoTen() + ", chúc mừng bạn thêm tài khoản Admin thành công", message);
				model.addAttribute("message", "Thêm Admin thành công");
			} catch (Exception e) {
				model.addAttribute("message", "Thêm Admin thất bại");
			}
		}
		model.addAttribute("nds", dao.findPageAdmin(0));
		model.addAttribute("lastPageNo", dao.getPageCountAdmin() - 1);
		return "admin/nguoidung/admin/index";
	}

	// Sửa Admin
	@GetMapping("admin/nguoidung/admin/update")
	public String update(Model model) {
		model.addAttribute("nd", new NguoiDung());
		model.addAttribute("nds", dao.findPageAdmin(0));
		model.addAttribute("lastPageNo", dao.getPageCountAdmin() - 1);
		return "admin/nguoidung/admin/index";
	}

	@PostMapping("admin/nguoidung/admin/update")
	public String update(Model model, @Validated @ModelAttribute("nd") NguoiDung nd, BindingResult errors,
			HttpServletResponse response) {
		if (errors.hasErrors()) {
			model.addAttribute("message", "Xin vui lòng sửa các lỗi sau đây");
		} else if (nd.getIsActive() == false) {
			model.addAttribute("message", "Tài khoản chưa được kích hoạt. Vui lòng kích hoạt trước khi cập nhật");
		} else {
			try {
				nd.setIsActive(true);
				dao.update(nd);
				model.addAttribute("message", "Cập nhật Admin thành công");
			} catch (Exception e) {
				model.addAttribute("message", "Cập nhật Admin thất bại");
			}
		}
		model.addAttribute("nds", dao.findPageAdmin(0));
		model.addAttribute("lastPageNo", dao.getPageCountAdmin() - 1);
		return "admin/nguoidung/admin/index";
	}

	// Xóa Admin
	@GetMapping("admin/nguoidung/admin/delete")
	public String delete(Model model) {
		model.addAttribute("nd", new NguoiDung());
		model.addAttribute("nds", dao.findPageAdmin(0));
		model.addAttribute("lastPageNo", dao.getPageCountAdmin() - 1);
		return "admin/nguoidung/admin/index";
	}

	@PostMapping("admin/nguoidung/admin/delete")
	public String delete(Model model, @ModelAttribute("nd") NguoiDung entity) {
		if (entity.getMaNguoiDung() == null) {
			model.addAttribute("message", "Vui lòng chọn 1 tài khoản Admin ");
		} else {
			try {
				dao.delete(entity.getMaNguoiDung());
				model.addAttribute("message", "Xóa Admin thành công");
			} catch (Exception e) {
				model.addAttribute("message", "Xóa Admin thất bại");
			}
		}
		model.addAttribute("nds", dao.findPageAdmin(0));
		model.addAttribute("lastPageNo", dao.getPageCountAdmin() - 1);
		return "admin/nguoidung/admin/index";
	}

	// Edit Admin
	@GetMapping("admin/nguoidung/admin/edit/{id}")
	public String edit(Model model, @PathVariable("id") Integer id) {
		NguoiDung entity = dao.findById(id);
		model.addAttribute("nds", dao.findPageAdmin(0));
		model.addAttribute("lastPageNo", dao.getPageCountAdmin() - 1);
		model.addAttribute("nd", entity);
		return "admin/nguoidung/admin/index";
	}

	// Search Admin
	@RequestMapping("admin/nguoidung/admin/search")
	public String search(Model model, @RequestParam("search") String email) {
		model.addAttribute("nd", new NguoiDung());
		model.addAttribute("nds", dao.searchAdmin(email));
		model.addAttribute("lastPageNo", dao.getPageCountAdmin() - 1);
		return "admin/nguoidung/admin/index";
	}

	// -----------------------------------------------------------
	// Customer
	@RequestMapping("admin/nguoidung/customer/index/{pageNo}")
	public String indexCus(Model model, @PathVariable("pageNo") int pageNo) {
		if (pageNo >= dao.getPageCountCustomer()) {
			pageNo = 0;
		} else if (pageNo < 0) {
			pageNo = dao.getPageCountCustomer() - 1;
		}
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("lastPageNo", dao.getPageCountCustomer() - 1);
		model.addAttribute("nds", dao.findPageCustomer(pageNo));
		model.addAttribute("nd", new NguoiDung());
		return "admin/nguoidung/customer/index";
	}

	// Thêm Customer
	@GetMapping("admin/nguoidung/customer/create")
	public String createCus(Model model) {
		model.addAttribute("nd", new NguoiDung());
		model.addAttribute("nds", dao.findPageCustomer(0));
		model.addAttribute("lastPageNo", dao.getPageCountCustomer() - 1);
		return "admin/nguoidung/customer/index";
	}

	@PostMapping("admin/nguoidung/customer/create")
	public String createCus(Model model, @Validated @ModelAttribute("nd") NguoiDung nd, BindingResult errors,
			HttpServletResponse response) {
		nd.setLoaiKH(0);
		nd.setIsAdmin(false);
		nd.setIsActive(false);
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
						+ "! \nBạn đã thêm tài khoản thành công\nĐể hoàn tất thêm tài khoản, bạn vui lòng nhấp vào link này:\n"
						+ "http://localhost:8080/active?id=" + nd.getMaNguoiDung() + "&activeKey=" + activeKey
						+ "\n(Hoặc copy đường link và paste vào trình duyệt web)\nLink sẽ hết hạn sau 24 tiếng\nBan quản trị web, trân trọng!";
				// create a cookie
				Cookie cookie = new Cookie("activeKey", activeKey);
				cookie.setPath("/");
				cookie.setMaxAge(86400);// Limit time of cookie 86400 second = 24 hours
				// add cookie to response
				response.addCookie(cookie);

				mailer.sendEmail(nd.getEmail(),
						"Xin chào bạn " + nd.getHoTen() + ", chúc mừng bạn thêm tài khoản thành công", message);
				model.addAttribute("message", "Thêm khách hàng thành công");
			} catch (Exception e) {
				model.addAttribute("message", "Thêm khách hàng thất bại");
			}
		}
		model.addAttribute("nds", dao.findPageCustomer(0));
		model.addAttribute("lastPageNo", dao.getPageCountCustomer() - 1);
		return "admin/nguoidung/customer/index";
	}

	// Sửa Customer
	@GetMapping("admin/nguoidung/customer/update")
	public String updateCus(Model model) {
		model.addAttribute("nd", new NguoiDung());
		model.addAttribute("nds", dao.findPageCustomer(0));
		model.addAttribute("lastPageNo", dao.getPageCountCustomer() - 1);
		return "admin/nguoidung/customer/index";
	}

	@PostMapping("admin/nguoidung/customer/update")
	public String updateCus(Model model, @Validated @ModelAttribute("nd") NguoiDung nd, BindingResult errors,
			HttpServletResponse response) {
		if (errors.hasErrors()) {
			model.addAttribute("message", "Xin vui lòng sửa các lỗi sau đây");
		} else if (nd.getIsActive() == false) {
			model.addAttribute("message", "Tài khoản chưa được kích hoạt. Vui lòng kích hoạt trước khi cập nhật");
		} else {
			try {
				dao.update(nd);
				model.addAttribute("message", "Cập nhật khách hàng thành công");
			} catch (Exception e) {
				model.addAttribute("message", "Cập nhật khách hàng thất bại");
			}
		}
		model.addAttribute("nds", dao.findPageCustomer(0));
		return "admin/nguoidung/customer/index";
	}

	// Xóa Customer
	@GetMapping("admin/nguoidung/customer/delete")
	public String deleteCus(Model model) {
		model.addAttribute("nd", new NguoiDung());
		model.addAttribute("nds", dao.findPageCustomer(0));
		model.addAttribute("lastPageNo", dao.getPageCountCustomer() - 1);
		return "admin/nguoidung/customer/index";
	}

	@PostMapping("admin/nguoidung/customer/delete")
	public String deleteCus(Model model, @ModelAttribute("nd") NguoiDung entity) {
		if (entity.getMaNguoiDung() == null) {
			model.addAttribute("message", "Vui lòng chọn 1 tài khoản ");
		} else {
			try {
				dao.delete(entity.getMaNguoiDung());
				model.addAttribute("message", "Xóa khách hàng thành công");
			} catch (Exception e) {
				model.addAttribute("message", "Xóa khách hàng thất bại");
			}
		}
		model.addAttribute("nds", dao.findPageCustomer(0));
		model.addAttribute("lastPageNo", dao.getPageCountCustomer() - 1);
		return "admin/nguoidung/customer/index";
	}

	// Edit customer
	@GetMapping("admin/nguoidung/customer/edit/{id}")
	public String editCus(Model model, @PathVariable("id") Integer id) {
		NguoiDung entity = dao.findById(id);
		model.addAttribute("nds", dao.findPageCustomer(0));
		model.addAttribute("lastPageNo", dao.getPageCountCustomer() - 1);
		model.addAttribute("nd", entity);
		return "admin/nguoidung/customer/index";
	}

	// Search Customer
	@RequestMapping("admin/nguoidung/customer/search")
	public String searchCustomer(Model model, @RequestParam("search") String email) {
		model.addAttribute("nd", new NguoiDung());
		model.addAttribute("nds", dao.searchCustomer(email));
		model.addAttribute("lastPageNo", dao.getPageCountCustomer() - 1);
		return "admin/nguoidung/customer/index";
	}
}
