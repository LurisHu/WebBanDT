package com.webbanhang.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webbanhang.dao.NguoiDungDAO;

@Service
public class SecurityService {
	@Autowired
	NguoiDungDAO userDao;

	public boolean checkValidOfHashKeySha256(String hashValue, String rawValue) {
		if (hashValue.equals(DigestUtils.sha256Hex(rawValue)))
			return true;
		else
			return false;
	}

	public boolean validatePass(Integer userId, String password) {
		if (userDao.findById(userId).getMatKhau().equals(password))
			return true;
		else
			return false;
	}
}
