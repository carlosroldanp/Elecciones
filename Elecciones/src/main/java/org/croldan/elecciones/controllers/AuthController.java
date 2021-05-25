package org.croldan.elecciones.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.croldan.elecciones.entities.Candidatura;
import org.croldan.elecciones.entities.Eleccion;
import org.croldan.elecciones.entities.Provincia;
import org.croldan.elecciones.repositories.CandidaturaRepository;
import org.croldan.elecciones.repositories.EleccionRepository;
import org.croldan.elecciones.repositories.ProvinciaRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth")
public class AuthController {

	// private static Logger log = LoggerFactory.getLogger(AuthController.class);

	@Autowired
	private CandidaturaRepository candidaturaRepository;

	@Autowired
	private EleccionRepository eleccionRepository;

	@Autowired
	private ProvinciaRepository provinciaRepository;

	@PostMapping("seleccionarProvinciaYEleccion")
	public String seleccionarProvinciaYEleccion(@RequestParam("eleccionId") Long eleccionId,
			@RequestParam("provinciaId") Long provinciaId, HttpSession s) {
		Eleccion e = eleccionRepository.getOne(eleccionId);
		Provincia p = provinciaRepository.getOne(provinciaId);

		// log.info("eleccion: "+e);

		s.setAttribute("eleccion", e);
		s.setAttribute("provincia", p);

		e = (Eleccion) s.getAttribute("eleccion");
		// log.info("eleccion (session): "+e);

		p = (Provincia) s.getAttribute("provincia");
		// log.info("provincia (session): "+p);

		return "redirect:/";
	}

	@GetMapping("candidatura/r")
	public String candidaturaR(ModelMap m, HttpSession s) {
		// log.info("AuthController.candidaturaR - candidatura/r");
		Eleccion e = (Eleccion) (s.getAttribute("eleccion"));
		// log.info("Eleccion: "+e);
		Provincia p = (Provincia) (s.getAttribute("provincia"));
		// log.info("Provincia: "+p);
		List<Candidatura> candidaturas = candidaturaRepository.findAllByProvinciaAndEleccion(p, e);
		// log.info("candidaturas: "+candidaturas);

		m.put("eleccion", e);
		m.put("provincia", p);
		m.put("candidaturas", candidaturas);
		m.put("view", "auth/candidatura/r");
		return "_t/frame";
	}
}
