package com.pilates.workflow.routes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginRoute {

	@GetMapping("/login")
	public String Login() {
		return "login";
	}

}
