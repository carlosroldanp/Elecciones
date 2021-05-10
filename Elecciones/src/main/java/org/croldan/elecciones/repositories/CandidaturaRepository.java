package org.croldan.elecciones.repositories;

import org.croldan.elecciones.entities.Candidatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidaturaRepository extends JpaRepository<Candidatura, Long> {

}
