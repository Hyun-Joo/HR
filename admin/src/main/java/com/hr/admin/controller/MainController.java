package com.hr.admin.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/main")
@RestController
public class MainController {

	@RequestMapping("/index")
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("main");
		return mav;
	}
}
