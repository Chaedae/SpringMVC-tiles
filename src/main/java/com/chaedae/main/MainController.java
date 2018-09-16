package com.chaedae.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping(value = "/chaedae/main/main.cd")
	public String main() {
		return "/chaedae/main/Main";
	}
}
