package com.test.mybatis;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.service.userService;
import com.test.vo.userVO;
import javax.inject.Inject;
import java.util.List;
/**
 * Handles requests for the application home page.
 */
@Controller //컨트롤러 임을 선언하는 어노테이션
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private userService service; // 컨트롤러에서 서비스를 호출받은 뒤 모델에 담는다
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET) // RequestMapping은 URL을 명시하여 사용하는 어노테이션
	public String home2(Locale locale, Model model) throws Exception {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		List<userVO> userList = service.selectuser(); // test.xml에 있는 쿼리문을 받아온다
		model.addAttribute("userList", userList );
		
		return "home2";
	}
	
}
