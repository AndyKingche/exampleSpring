package com.example.mx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.mx.domain.Alumno;
import com.example.mx.domain.Tipo;

public interface TipoRepository extends JpaRepository <Tipo, Long> {
	@Query(value = "SELECT * FROM tipo WHERE categoria_id =?", nativeQuery = true)
	List<Tipo> findByForeingKey(Integer id);
	
	@Query(value="SELECT COUNT(*) FROM tipo WHERE categoria_id=? ", nativeQuery = true)
	int numeroTipo(Integer id);

}
