package com.travelgateway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebMvcController {

	@GetMapping("/home")
	public String home() {
		System.out.println("In the Web Controller");
		return "home"; // returns home.jsp
	}

}
