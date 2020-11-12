package com.example.mx.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mx.domain.Profesor;
import com.example.mx.repository.ProfesorRepository;

@RestController
@RequestMapping("/api")
public class ProfesorController {

	@Autowired
	ProfesorRepository profesorRepository;

	@GetMapping("/profesores")
	public List<Profesor> getAllProfesores() {
		List<Profesor> page = profesorRepository.findAll();
		return page;
	}

	@GetMapping("/profesores/{id}")
	public Optional<Profesor> getProfesores(@PathVariable Long id) throws ResourceNotFoundException {
		Optional<Profesor> profesores = profesorRepository.findById(id);
		return profesores;
	}

	@PostMapping("/profesores")
	Profesor newProfesor(@RequestBody Profesor profesor) {
		return profesorRepository.save(profesor);
	}

	@PutMapping("/profesores/{id}")
	public ResponseEntity<String> updateProfesor(@RequestBody Profesor profesor, @PathVariable Long id)
			throws ResourceNotFoundException {
		Profesor findProfesor = getProfesores(id)
				.orElseThrow(() -> new ResourceNotFoundException("No se encontro el id"));
		findProfesor.setNombre(profesor.getNombre());
		findProfesor.setApellido(profesor.getApellido());
		findProfesor.setCedula(profesor.getCedula());
		findProfesor.setFechanacimiento(profesor.getFechanacimiento());
		findProfesor.setEdad(profesor.getEdad());
		findProfesor.setDireccion(profesor.getDireccion());
		findProfesor.setTelefono(profesor.getTelefono());
		findProfesor.setTitulo(profesor.getTitulo());

		Profesor newProfesor = profesorRepository.save(findProfesor);

		return ResponseEntity.ok().header("Contet-Type", "application/json")
				.body("El profesor se actualizo correctamente");
	}

	@DeleteMapping("/profesores/{id}")
	public ResponseEntity<String> deleteProfesores(@PathVariable Long id) {
		profesorRepository.deleteById(id);
		return ResponseEntity.ok().header("Contet-Type", "application/json")
				.body("El profesor se elimino correctamente");
	}

}
