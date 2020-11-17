package com.example.mx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mx.domain.Profesor;

@RestController
@RequestMapping("/api")
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
	
	@Query(value = "SELECT * FROM profesor WHERE nombre LIKE %?%", nativeQuery = true)
	List<Profesor> findByName(String name);

}
