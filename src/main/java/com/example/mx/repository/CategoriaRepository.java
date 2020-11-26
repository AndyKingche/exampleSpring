package com.example.mx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.example.mx.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	@Query(value = "SELECT * FROM categoria WHERE nombre LIKE %?%", nativeQuery = true)
	List<Categoria> findByName(String name);

}
