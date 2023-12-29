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
    // menu.do�� Ŭ���ϸ� views/member/login.jsp�� �̵�
    @RequestMapping("/")
    public String login() {
        return "Login";
    }

    @RequestMapping(value="login_check", method = RequestMethod.POST)
    public ModelAndView loginCheck(@ModelAttribute UserDto dto, HttpSession session) {
        String name = memberService.loginCheck(dto, session);
        ModelAndView mav = new ModelAndView();
        if (name != null) { // �α��� ���� ��
            mav.setViewName("home"); // ���� �̸��� "home"�� ����
        } else { // �α��� ���� ��
            mav.setViewName("Login");
            mav.addObject("message", "error");
        }
        return mav; 
    }

    @RequestMapping("logout")
    public ModelAndView logout(HttpSession session) {
        memberService.logout(session);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Login"); // ���� �̸��� "Login"���� ����
        mav.addObject("message", "logout");
        return mav;
    }*/

@Controller
public class HomeController {

    @Autowired
    private MemberService memberService;
    
    @GetMapping("/")
    public String home(Model model) {
        // Ȩ �������� �̵�
        return "Login";
    }

    @GetMapping("/Login.do")
    public String showLoginForm(Model model) {
        // �α��� �������� �̵�
        return "Login";
    }

    @PostMapping("/login_check.do")
    public String login(@RequestParam("userid") String userid,
                        @RequestParam("passwd") String passwd,
                        HttpSession session,
                        Model model) {
        // ���̵�� ��й�ȣ�� �̿��Ͽ� �α��� üũ
        UserDto dto = new UserDto();
        dto.setUserid(userid);
        dto.setPasswd(passwd);

        String name = memberService.loginCheck(dto, session);

        if (name != null) {
            // �α��� ���� �� Ȩ�������� �����̷�Ʈ
            return "redirect:/Main";
        } else {
            // �α��� ���� �� ���� �޽����� �Բ� �α��� �������� �̵�
            model.addAttribute("error", "���̵� �Ǵ� ��й�ȣ�� �ùٸ��� �ʽ��ϴ�.");
            return "Login";
        }
    }

    @GetMapping("/logout.do")
    public String logout(HttpSession session) {
        // �α׾ƿ� ó��
        memberService.logout(session);
        return "redirect:/Main";
    }
}