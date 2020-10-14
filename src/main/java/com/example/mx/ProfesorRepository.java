package com.example.mx;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
	
}
