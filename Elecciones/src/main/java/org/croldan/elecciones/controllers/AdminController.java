package org.croldan.elecciones.controllers;

import java.time.LocalDate;

import org.croldan.elecciones.entities.Candidatura;
import org.croldan.elecciones.entities.Eleccion;
import org.croldan.elecciones.entities.PartidoPolitico;
import org.croldan.elecciones.entities.Provincia;
import org.croldan.elecciones.repositories.CandidaturaRepository;
import org.croldan.elecciones.repositories.EleccionRepository;
import org.croldan.elecciones.repositories.PartidoPoliticoRepository;
import org.croldan.elecciones.repositories.ProvinciaRepository;
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

	@Autowired
	private ProvinciaRepository provinciaRepository;

	// ============================
	// ELECCION
	// ============================

	@GetMapping("/eleccion/c")
	public String cEleccionGet(ModelMap m) {

		m.put("view", "admin/eleccion/c");
		return "_t/frame";
	}

	@PostMapping("/eleccion/c")
	public String cEleccionPost(@RequestParam("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {

		eleccionRepository.save(new Eleccion(fecha));
		return "redirect:admin/eleccion/r";
	}

	@GetMapping("/eleccion/r")
	public String rEleccionGet(ModelMap m) {

		m.put("elecciones", eleccionRepository.findAll());
		m.put("view", "admin/eleccion/r");
		return "_t/frame";
	}

	// ============================
	// CANDIDATURA
	// ============================

	@GetMapping("candidatura/c")
	public String cCandidaturaGet(ModelMap m) {

		m.put("elecciones", eleccionRepository.findAll());
		m.put("pps", partidoPoliticoRepository.findAll());
		m.put("provincias", provinciaRepository.findAll());

		m.put("view", "admin/candidatura/c");
		return "_t/frame";
	}

	@PostMapping("candidatura/c")
	public String cCandidaturaPost(@RequestParam("idEleccion") Long idEleccion,
			@RequestParam("idProvincia") Long idProvincia, @RequestParam("idPartidoPolitico") Long idPartidoPolitico) {

		Eleccion eleccion = eleccionRepository.getOne(idEleccion);
		Provincia provincia = provinciaRepository.getOne(idProvincia);
		PartidoPolitico partidoPolitico = partidoPoliticoRepository.getOne(idPartidoPolitico);

		candidaturaRepository.save(new Candidatura(eleccion, provincia, partidoPolitico));
		return "redirect:admin/candidatura/r";
	}

	@GetMapping("candidatura/r")
	public String rCandidaturaGet(ModelMap m) {

		m.put("candidaturas", candidaturaRepository.findAll());
		m.put("view", "admin/candidatura/r");
		return "_t/frame";
	}

	// ============================
	// PARTIDO POLITICO
	// ============================

	@GetMapping("pp/c")
	public String cPartidoPoliticoGet(ModelMap m) {

		m.put("view", "admin/pp/c");
		return "_t/frame";
	}

	@PostMapping("pp/c")
	public String cPartidoPoliticoPost(@RequestParam("siglas") String siglas, @RequestParam("nombre") String nombre) {

		partidoPoliticoRepository.save(new PartidoPolitico(siglas, nombre));
		return "redirect:/admin/pp/r";
	}

	@GetMapping("pp/r")
	public String rPartidoPoliticoGet(ModelMap m) {

		m.put("partidos", partidoPoliticoRepository.findAll());
		m.put("view", "admin/pp/r");
		return "_t/frame";
	}
}
