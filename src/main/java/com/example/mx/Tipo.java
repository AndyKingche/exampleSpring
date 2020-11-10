package com.example.mx;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tipo")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Tipo implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,
	generator="native")
	@GenericGenerator(name ="native",
	strategy = "native")
	private Long id;

	@NotNull  
	@Column(name = "nombre", nullable = false)
	private String nombre;

	@NotNull 
	@Column(name = "descripcion", nullable = false)
	private String descripcion;

	@ManyToOne
	@JoinColumn(name = "categoria_id")
	@JsonIgnore
	private Categoria categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public Tipo nombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Tipo descripcion(String descripcion) {
		this.descripcion = descripcion;
		return this;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Tipo categoria(Categoria categoria) {
		this.categoria = categoria;
		return this;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Tipo tipo = (Tipo) o;
		if (tipo.id == null || id == null) {
			return false;
		}
		return Objects.equals(id, tipo.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

	@Override
	public String toString() {
		return "Tipo{" + "id=" + id + ", nombre='" + nombre + "'" + ", descripcion='" + descripcion + "'" + '}';
	}
}
