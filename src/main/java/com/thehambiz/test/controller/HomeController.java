package com.thehambiz.test.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

/*@Controller
@RequestMapping("/")
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
    }*/

@Controller
public class HomeController {

    @Autowired
    private MemberService memberService;
    
    @GetMapping("/")
    public String home(Model model) {
        // 홈 페이지로 이동
        return "Login";
    }

    @GetMapping("/Login.do")
    public String showLoginForm(Model model) {
        // 로그인 페이지로 이동
        return "Login";
    }

    @PostMapping("/login_check.do")
    public String login(@RequestParam("userid") String userid,
                        @RequestParam("passwd") String passwd,
                        HttpSession session,
                        Model model) {
        // 아이디와 비밀번호를 이용하여 로그인 체크
        UserDto dto = new UserDto();
        dto.setUserid(userid);
        dto.setPasswd(passwd);

        String name = memberService.loginCheck(dto, session);

        if (name != null) {
            // 로그인 성공 시 홈페이지로 리다이렉트
            return "redirect:/Main";
        } else {
            // 로그인 실패 시 에러 메시지와 함께 로그인 페이지로 이동
            model.addAttribute("error", "아이디 또는 비밀번호가 올바르지 않습니다.");
            return "Login";
        }
    }

    @GetMapping("/logout.do")
    public String logout(HttpSession session) {
        // 로그아웃 처리
        memberService.logout(session);
        return "redirect:/Main";
    }
}