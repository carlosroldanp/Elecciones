package org.croldan.elecciones.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ComunidadAutonoma {

	// ===============================

	@Column(unique = true)
	private String nombre;
}
