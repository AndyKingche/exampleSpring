package com.example.mx;

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

@RestController
@RequestMapping("/api")
public class MatriculaController {
	
	@Autowired
	MatriculaRepository matriculaRepositorio;
	
	@GetMapping("/matriculas")
	public List<Matricula> getAllMatriculas() {
		List<Matricula> matricula = matriculaRepositorio.findAll();
		return matricula;
	}
	
	@GetMapping("/matriculas/{id}")
	public Optional<Matricula> getIdMatriculas (@PathVariable Long id) throws ResourceNotFoundException{
		Optional<Matricula> matricula = matriculaRepositorio.findById(id);
		return matricula;
	}
	
	@PostMapping("/matriculas")
	Matricula newMatricula (@RequestBody Matricula matricula) {
		return matriculaRepositorio.save(matricula);
	}
	
	@PutMapping("/matriculas/{id}")
	public ResponseEntity<String> updateMatricula (@RequestBody Matricula matricula, @PathVariable Long id) throws ResourceNotFoundException {
		Matricula findMatricula = getIdMatriculas(id).orElseThrow(()-> new ResourceNotFoundException("No se encontro el id"));
		findMatricula.setMateria(matricula.getMateria());
		findMatricula.setAlumno(matricula.getAlumno());
		
		Matricula newMateria = matriculaRepositorio.save(findMatricula);
		
		return ResponseEntity.ok().header("Contet-Type", "application/json").
				body("La matricula se actualizo correctamente");
	}
	
	@DeleteMapping("/matriculas/{id}")
	public ResponseEntity<String> deleteMatricula (@PathVariable Long id) {
		matriculaRepositorio.deleteById(id);
		return ResponseEntity.ok().header("Contet-Type", "application/json").
				body("La matricula se elimino correctamente");
	}
}
