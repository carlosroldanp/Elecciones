package org.croldan.elecciones.controllers;

import org.croldan.elecciones.repositories.CandidaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/candidatura")
public class CandidaturaController {

	@Autowired
	private CandidaturaRepository candidaturaRepository;

	@GetMapping("c")
	public String createCandidatura(ModelMap m) {
		m.put("view", "candidatura/create");
		return "_t/frame";
	}

	@GetMapping("r")
	public String readCandidatura(ModelMap m) {
		m.put("candidaturas", candidaturaRepository.findAll());
		m.put("view", "candidatura/read");
		return "_t/frame";
	}
}
