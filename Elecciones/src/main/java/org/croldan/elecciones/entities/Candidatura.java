package org.croldan.elecciones.entities;

import javax.persistence.Entity;

@Entity
public class Candidatura {

	private int numVotos;
	private Eleccion eleccion;
}
