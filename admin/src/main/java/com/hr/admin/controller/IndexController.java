package com.hr.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IndexController {

	
	@RequestMapping(value= {"/"})
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageName", "Welcome to IN+");
		mav.setViewName("login");
		return mav;
	}
}
