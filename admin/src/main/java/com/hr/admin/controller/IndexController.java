package com.hr.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IndexController {

	
	@RequestMapping(value= {"/"})
	public String login() {
		return "login.html";
	}
}
