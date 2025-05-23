package com.pilates.workflow.routes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardRoute {
	
	@GetMapping("/dashboard")
	public String dashboard() {
		return "dashboard";
	}

}
