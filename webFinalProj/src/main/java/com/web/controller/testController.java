package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/1")
public class testController {
	
	@RequestMapping(value = "/1", method = RequestMethod.GET)
	public String test() {
		System.out.println("동작완료");
		return "test";
	}
	
}


