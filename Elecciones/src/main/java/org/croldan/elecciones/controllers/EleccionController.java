package org.croldan.elecciones.controllers;

import org.croldan.elecciones.repositories.EleccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/eleccion")
public class EleccionController {

	@Autowired
	private EleccionRepository eleccionRepository;

	@GetMapping("c")
	public String createEleccion(ModelMap m) {
		m.put("view", "eleccion/create");
		return "_t/frame";
	}

	@GetMapping("r")
	public String readEleccion(ModelMap m) {
		m.put("elecciones", eleccionRepository.findAll());
		m.put("view", "eleccion/read");
		return "_t/frame";
	}
}
