package com.example.mx;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import com.sun.istack.NotNull;

/**
 * A Categoria.
 */
@Entity
@Table(name = "categoria")

public class Categoria implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,
	generator="native")
	@GenericGenerator(name ="native",
	strategy = "native")
	private Long id;
 

	@Column(name = "nombre", nullable = false, unique = true)
	private String nombre;


	@Column(name = "descripcion", nullable = false)
	private String descripcion;
   
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, fetch = FetchType.EAGER,orphanRemoval = true) 
	private Set<Tipo> tipo = new TreeSet<>();
 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public Categoria nombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Categoria descripcion(String descripcion) {
		this.descripcion = descripcion;
		return this;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Categoria categoria = (Categoria) o;
		if (categoria.id == null || id == null) {
			return false;
		}
		return Objects.equals(id, categoria.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

	@Override
	public String toString() {
		return "Categoria{" + "id=" + id + ", nombre='" + nombre + "'" + ", descripcion='" + descripcion + "'" + '}';
	}

	public Set<Tipo> getTipo() {
		return tipo;
	}

	public void setTipo(Set<Tipo> tipo) {
		tipo.forEach(x -> x.setCategoria(this));
		this.tipo = tipo;
	}

}