package com.thehambiz.test.svc;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.thehambiz.test.dao.LoginDao;
import com.thehambiz.test.dao.UserDto;

@Service
public class MemberService{

	@Autowired
	@Qualifier("loginDao")
	LoginDao memberDao;
	
	
	public String loginCheck(UserDto dto, HttpSession session) {
		String name = memberDao.loginCheck(dto);
		if (name != null) { // 세션 변수 저장
			session.setAttribute("userid", dto.getUserid());
			session.setAttribute("name", name);
		}
		return name;
	}
	public void logout(HttpSession session) {
		session.invalidate(); // 세션 초기화
	}
}