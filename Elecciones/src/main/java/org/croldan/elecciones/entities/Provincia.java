package org.croldan.elecciones.entities;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Provincia {

	// ================================================

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String nombre;

	private int numEscanios;

	@OneToMany(mappedBy = "provincia")
	@JsonIgnore
	private Collection<Candidatura> candidaturas;

	@ManyToOne(cascade = CascadeType.ALL)
	private ComunidadAutonoma comunidadAutonoma;

	// ================================================

	public Provincia() {
		this.candidaturas = new HashSet<>();
	}

	public Provincia(String nombre) {
		super();
		this.nombre = nombre;
		this.numEscanios = 0;
	}

	// ================================================

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumEscanios() {
		return numEscanios;
	}

	public void setNumEscanios(int numEscanios) {
		this.numEscanios = numEscanios;
	}

	public Collection<Candidatura> getCandidaturas() {
		return candidaturas;
	}

	public void setCandidaturas(Collection<Candidatura> candidaturas) {
		this.candidaturas = candidaturas;
	}

	public ComunidadAutonoma getComunidadAutonoma() {
		return comunidadAutonoma;
	}

	public void setComunidadAutonoma(ComunidadAutonoma comunidadAutonoma) {
		this.comunidadAutonoma = comunidadAutonoma;
	}

}
