package com.example.mx;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.http.HeaderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
//import io.github.jhipster.web.util.ResponseUtil;

@RestController
@RequestMapping("/api")
public class ProvinciaController {

	@Autowired
	ProvinciaRepository provinciaRepository;

	@GetMapping("/provincias")
	public List<Provincia> getAllProvincias() {
		List<Provincia> page = provinciaRepository.findAll();
		
		return page;
	}

	@GetMapping("/provincias/{id}")
	public Optional<Provincia> getProvincias(@PathVariable Long id) throws ResourceNotFoundException{
		Optional<Provincia> provincia = provinciaRepository.findById(id);
	
		return provincia;
	}
 
	
	@PostMapping("/provincias")
	public ResponseEntity<Provincia> createProvincias(@RequestBody Provincia padre)  {
		
		
			Provincia result = provinciaRepository.save(padre);
			return ResponseEntity.ok()
						.header("Content-Type", "application/json").body(result);
	}

	@PutMapping("/provincias/{id}")
	public ResponseEntity<String> updateProvincias( @RequestBody Provincia provincia, @PathVariable Long id) throws ResourceNotFoundException{
		
		Provincia encontrarProvincia = getProvincias(id).orElseThrow(( )-> new ResourceNotFoundException("No se encontro el Id"));
		
		encontrarProvincia.setNombre(provincia.getNombre());
		encontrarProvincia.setHabitantes(provincia.getHabitantes());
		encontrarProvincia.setDescripcion(provincia.getDescripcion());
		
		Provincia actualizarProvincia = provinciaRepository.save(encontrarProvincia);		
		
		return ResponseEntity.ok()
				.header("Content-Type", "application/json")
				.body("{\"mensaje\": \"La provincia Se actualizo correctamente "+""+"\"}");
		
	}
	

	@DeleteMapping("/provincias/{id}")
	public ResponseEntity<String> deleteProvincias(@PathVariable Long id) {
		provinciaRepository.deleteById(id);
		
		return ResponseEntity.ok()
				.header("Content-Type", "application/json")
				.body("{\"mensaje\": \"Se elimino correctamente el "+id+"\"}");
}
}
 
