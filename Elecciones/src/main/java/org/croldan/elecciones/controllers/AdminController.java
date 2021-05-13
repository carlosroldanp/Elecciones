package org.croldan.elecciones.controllers;

import java.time.LocalDate;

import org.croldan.elecciones.entities.Eleccion;
import org.croldan.elecciones.repositories.CandidaturaRepository;
import org.croldan.elecciones.repositories.EleccionRepository;
import org.croldan.elecciones.repositories.PartidoPoliticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private EleccionRepository eleccionRepository;

	@Autowired
	private PartidoPoliticoRepository partidoPoliticoRepository;

	@Autowired
	private CandidaturaRepository candidaturaRepository;

	@GetMapping("/eleccion/c")
	public String cEleccionGet(ModelMap m) {
		m.put("view", "admin/eleccion/c");
		return "/_t/frame";
	}

	@PostMapping("/eleccion/c")
	public String cEleccionPost(@RequestParam("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
		eleccionRepository.save(new Eleccion(fecha));
		return "redirect:admin/eleccion/r";
	}

	@GetMapping("/eleccion/r")
	public String rEleccionGet(ModelMap m) {
		m.put("elecciones", eleccionRepository.findAll());
		m.put("view", "anon/eleccion/r");
		return "/_t/frame";
	}

	// ============================
	// CANDIDATURA
	// ============================

	@GetMapping("candidatura/c")
	public String cCandidaturaGet(ModelMap m) {
		
		m.put("elecciones", eleccionRepository.findAll());
		return null;
	}
}
