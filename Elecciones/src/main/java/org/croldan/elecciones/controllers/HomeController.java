package org.croldan.elecciones.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String index(ModelMap m) {

		m.put("view", "home/index");
		return "_t/frame";
	}
}
