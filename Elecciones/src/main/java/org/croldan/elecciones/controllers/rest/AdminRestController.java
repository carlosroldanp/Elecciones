package org.croldan.elecciones.controllers.rest;

import java.util.List;

import org.croldan.elecciones.entities.Candidatura;
import org.croldan.elecciones.repositories.CandidaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/admin")
public class AdminRestController {

	@Autowired
	private CandidaturaRepository candidaturaRepository;

	/*
	 * Devolver todas las candidaturas Aquellas candidaturas que se relacionen con
	 * la fecha de Elecciones
	 */
	@GetMapping("candidaturas/{eleccionId}")
	public List<Candidatura> getCandidaturas(@PathVariable("eleccionId") Long eleccionId) {
		return candidaturaRepository.findAllByEleccionId(eleccionId);
	}
}
