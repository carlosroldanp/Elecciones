package org.croldan.elecciones.repositories;

import java.util.List;

import org.croldan.elecciones.entities.Candidatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidaturaRepository extends JpaRepository<Candidatura, Long> {

	//Devuelve la lista de candidaturas cuyo id coincida con el idEleccion
	public List<Candidatura> findAllByEleccionId(Long idEleccion);
}
