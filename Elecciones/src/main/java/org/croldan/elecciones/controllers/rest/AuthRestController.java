package org.croldan.elecciones.controllers.rest;

import org.croldan.elecciones.entities.Candidatura;
import org.croldan.elecciones.repositories.CandidaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/auth")
public class AuthRestController {

	@Autowired
	CandidaturaRepository candidaturaRepository;

	@PatchMapping("candidatura/{candidaturaId}/{nVotos}")
	public Integer patchCandidatura(@PathVariable("candidaturaId") Long candidaturaId,
			@PathVariable("nVotos") int nVotos) {
		Candidatura candidatura = candidaturaRepository.getOne(candidaturaId);
		// Calculamos los votos finales (actuales + nuevos)
		int votosFinales = candidatura.getNumVotos() + nVotos;
		candidatura.setNumVotos(votosFinales);
		// Votos guardados en la bbdd
		candidaturaRepository.save(candidatura);
		return votosFinales;
	}
}
