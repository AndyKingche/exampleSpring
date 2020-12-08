package com.example.mx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mx.domain.Cantones;

@RestController
@RequestMapping("/api")
public interface CantonesRepository extends JpaRepository<Cantones, Long> {
	
	@Query(value="SELECT * FROM cantones WHERE fk_id=?", nativeQuery = true)
	List<Cantones> encontrarCanton(Integer fk_id);

}
