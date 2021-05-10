package org.croldan.elecciones.repositories;

import org.croldan.elecciones.entities.Eleccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EleccionRepository extends JpaRepository<Eleccion, Long> {

}
