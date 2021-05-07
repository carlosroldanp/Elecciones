package org.croldan.elecciones.entities;

import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Entity;

@Entity
public class Eleccion {

	private LocalDate fecha;
	private Collection<Candidatura> candidaturas;
}
