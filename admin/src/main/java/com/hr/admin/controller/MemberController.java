package com.hr.admin.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hr.admin.service.MemberService;

@RequestMapping("/member")
@RestController
public class MemberController {
	
	@Autowired
	MemberService service;
	
	@RequestMapping("/index")
	public ModelAndView goToRegisterPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/register");
		return mav;
	}
	
	@PostMapping("/id/check")
	public Integer idCheck(@RequestBody Map<String,Object> paramData) {
		String mbAcc = String.valueOf(paramData.get("mbAcc"));
		Integer result = service.idCheck(mbAcc);
		return result;
	}

}
