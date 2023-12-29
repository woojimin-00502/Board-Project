package com.thehambiz.test.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;


import com.thehambiz.test.dao.UserDto;
import com.thehambiz.test.svc.MemberService;

/**
 * Handles requests for the application home page.
 */
/*@Controller
@RequestMapping
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
	
		return "Login";
	}
}*/

@Controller
@RequestMapping(value = "/", method = RequestMethod.GET)
public class HomeController {
	
    MemberService memberService;

    @Autowired
    // menu.do를 클릭하면 views/member/login.jsp로 이동
    @RequestMapping("/")
    public String login() {
        return "Login";
    }

    @RequestMapping(value="login_check", method = RequestMethod.POST)
    public ModelAndView loginCheck(@ModelAttribute UserDto dto, HttpSession session) {
        String name = memberService.loginCheck(dto, session);
        ModelAndView mav = new ModelAndView();
        if (name != null) { // 로그인 성공 시
            mav.setViewName("home"); // 뷰의 이름만 "home"로 변경
        } else { // 로그인 실패 시
            mav.setViewName("Login");
            mav.addObject("message", "error");
        }
        return mav; 
    }

    @RequestMapping("logout")
    public ModelAndView logout(HttpSession session) {
        memberService.logout(session);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Login"); // 뷰의 이름만 "Login"으로 변경
        mav.addObject("message", "logout");
        return mav;
    }
}