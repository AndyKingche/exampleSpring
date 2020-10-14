package com.example.mx;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "matricula")

public class Matricula implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,
	generator="native")
	@GenericGenerator(name ="native",
	strategy = "native")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "fK_idmateria")
	private Materias materia;
	
	@ManyToOne
	@JoinColumn(name = "fK_idalumnos")
	private Alumno alumno;
	
	
	public Matricula() {
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Materias getMateria() {
		return materia;
	}


	public void setMateria(Materias materia) {
		this.materia = materia;
	}


	public Alumno getAlumno() {
		return alumno;
	}


	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
	
	
}
