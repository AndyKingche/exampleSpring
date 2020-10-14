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
public class MateriasController {
	@Autowired
	MateriasRepository meteriasrespoRepository;
	
	@GetMapping("/materias")
	public List<Materias> getAllCantones() {
		List<Materias> page = meteriasrespoRepository.findAll();
		return page;
	}
	
	@GetMapping("/materias/{id}")
	public Optional<Materias> getMaterias(@PathVariable Long id) throws ResourceNotFoundException{
		Optional<Materias> materias = meteriasrespoRepository.findById(id);
		System.out.println("cantones "+materias.isPresent());
	
		return materias;
	}
	@PostMapping("/materias")
	public ResponseEntity<Materias> createMaterias(@RequestBody Materias padre)  {
			
		if (padre.getId() != null) {
			return ResponseEntity.badRequest()
					.header("Content-Type", "application/json")
					.body(null);
			}	
		
		Materias result = meteriasrespoRepository.save(padre);
		return ResponseEntity.ok()
					.header("Content-Type", "application/json").body(result);
	}
	
	@PutMapping("/materias/{id}")
	public ResponseEntity<String> updateMaterias( @RequestBody Materias cantones, @PathVariable Long id) throws ResourceNotFoundException{
		
		Materias encontrarMaterias = getMaterias(id).orElseThrow(( )-> new ResourceNotFoundException("No se encontro el Id"));
		
		encontrarMaterias.setNombre(cantones.getNombre());
		encontrarMaterias.setProfesor(cantones.getProfesor());
		encontrarMaterias.setHoras(cantones.getHoras());
		
		Materias actualizarCantones = meteriasrespoRepository.save(encontrarMaterias);		
		
		return ResponseEntity.ok()
				.header("Content-Type", "application/json")
				.body("{\"mensaje\": \"El canton se actualizo correctamente "+""+"\"}");
		
	}
	@DeleteMapping("/materias/{id}")
	public ResponseEntity<String> deleteMaterias(@PathVariable Long id) {
		meteriasrespoRepository.deleteById(id);
		
		return ResponseEntity.ok()
				.header("Content-Type", "application/json")
				.body("{\"mensaje\": \"Se elimino correctamente el "+id+"\"}");
}

	
}
