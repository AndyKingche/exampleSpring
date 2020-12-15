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
<<<<<<< HEAD
	List<Cantones> encontrarCanton(Integer id);
=======
	List<Cantones> encontrarCanton(Integer fk_id);
>>>>>>> a8bcb6de08d72f8f90c69863aee7c66b1e97fa7b

}
