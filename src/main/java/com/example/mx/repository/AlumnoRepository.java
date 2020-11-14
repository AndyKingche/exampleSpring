package com.example.mx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mx.domain.Alumno;

@RestController
@RequestMapping("/api")
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

<<<<<<< HEAD
	@Query(value = "SELECT * FROM alumnos WHERE nombre LIKE %?%", nativeQuery = true)
	List<Alumno> findByName(String name);
=======
	@Query(value = "select * from alumnos WHERE nombre like'%?1%'", 
			nativeQuery= true) 
	public Alumno findByName(@Param("name")String name);
	
>>>>>>> origin/master
}
