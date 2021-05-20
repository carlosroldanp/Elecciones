package org.croldan.elecciones.controllers;

import javax.servlet.http.HttpSession;

import org.croldan.elecciones.entities.Eleccion;
import org.croldan.elecciones.entities.Provincia;
import org.croldan.elecciones.repositories.EleccionRepository;
import org.croldan.elecciones.repositories.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	EleccionRepository eleccionRepository;

	@Autowired
	ProvinciaRepository provinciaRepository;

	@PostMapping("escogerProvinciaYCCAA")
	public String escogerProvinciaYCCAA(@RequestParam("idEleccion") Long idEleccion,
			@RequestParam("idProvincia") Long idProvincia, HttpSession s) {
		Eleccion e = eleccionRepository.getOne(idEleccion);
		Provincia p = provinciaRepository.getOne(idProvincia);

		s.setAttribute("eleccion", e);
		s.setAttribute("provincia", p);

		return "redirect:/";

	}
}
