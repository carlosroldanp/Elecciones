package org.croldan.elecciones.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PartidoPolitico {

	@Column(unique = true)
	private String siglas;

	@Column(unique = true)
	private String nombre;
}
