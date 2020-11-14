package com.example.mx.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mx.domain.Alumno;

@RestController
@RequestMapping("/api")
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

	@Query(value = "SELECT * FROM alumnos u WHERE u.nombre like '%:name%' ", 
			nativeQuery= true) 
	public List<Alumno> findByName(@Param("name") String name);
	
}
