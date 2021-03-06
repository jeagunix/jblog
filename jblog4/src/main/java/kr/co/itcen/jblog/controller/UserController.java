package kr.co.itcen.jblog.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.itcen.jblog.service.BlogService;
import kr.co.itcen.jblog.service.CategoryService;
import kr.co.itcen.jblog.service.UserService;
import kr.co.itcen.jblog.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private CategoryService categoryService;

//	@Auth("USER") // @Auth(value="USER")
//	@RequestMapping(value = "/update", method = RequestMethod.GET)
//	public String update(@AuthUser UserVo authUser, Model model) {
//		// 접근 제어(ACL) /////////////////////////
//		System.out.println(authUser);
//		Long no = authUser.getNo();
//		authUser = userService.select(no);
//		model.addAttribute("viewImfor", authUser);
//		return "user/update";
//	}
//
//	@RequestMapping(value = "/update", method = RequestMethod.POST)
//	public String update(@AuthUser UserVo authUser, @ModelAttribute UserVo vo, Model model) {
//		
//		Long no = authUser.getNo();
//		vo.setNo(no);
//		userService.update(vo);
//		
//		return "redirect:/user/update";
//	}
	// 회원가입 페이지로 넘어간다.
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(@ModelAttribute UserVo vo) {
		return "user/join";
	}
	// 회원가입 버튼 누르면 진행되는 post, joinsuccess로 넘어간다.
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute @Valid UserVo vo, BindingResult result, Model model) { 
		if (result.hasErrors()) {
			model.addAllAttributes(result.getModel());
			return "user/join";
		}

		userService.join(vo);
		blogService.join(vo);
		categoryService.join(vo);
		return "user/joinsuccess";
	}
	// login페이지로 넘어간다.
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "user/login";
	}

}