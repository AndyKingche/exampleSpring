package com.example.mx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mx.domain.Matricula;

@RestController
@RequestMapping("/api")
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

}
