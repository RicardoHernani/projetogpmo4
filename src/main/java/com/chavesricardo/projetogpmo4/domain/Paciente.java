package com.chavesricardo.projetogpmo4.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private Integer prontuario;
		
	@JsonBackReference
	@ManyToMany(mappedBy="pacientes")
	private List<Usuario> usuarios = new ArrayList<>();
	

	@JsonManagedReference
	@ManyToMany
	@JoinTable(name = "PACIENTE_CIRURGIA",
		joinColumns = @JoinColumn(name="paciente_cirurgia_id"),
		inverseJoinColumns = @JoinColumn(name = "cirurgia_id")
	)
	private List<Cirurgia> cirurgias = new ArrayList<>();
	
	public Paciente() {
	}

	public Paciente(Integer id, Integer prontuario) {
		super();
		this.id = id;
		this.prontuario = prontuario;
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProntuario() {
		return prontuario;
	}

	public void setProntuario(Integer registro) {
		this.prontuario = registro;
	}

	public List<Cirurgia> getCirurgias() {
		return cirurgias;
	}

	public void setCirurgias(List<Cirurgia> cirurgias) {
		this.cirurgias = cirurgias;
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}