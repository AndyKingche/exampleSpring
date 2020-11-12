package com.example.mx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mx.domain.Alumno;

@RestController
@RequestMapping("/api")
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

	//@Query("select Nombre from estudiantes WHERE Nombre like'%A%'");
	//private Alumno findAlumno();
}
