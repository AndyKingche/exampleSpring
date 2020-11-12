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

import com.example.mx.domain.Cantones;
import com.example.mx.repository.CantonesRepository;

@RestController
@RequestMapping("/api")
public class CantonesController {

	@Autowired
	CantonesRepository cantonesrespoRepository;

	@GetMapping("/cantones")
	public List<Cantones> getAllCantones() {
		List<Cantones> page = cantonesrespoRepository.findAll();
		return page;
	}

	@GetMapping("/cantones/{id}")
	public Optional<Cantones> getCantones(@PathVariable Long id) throws ResourceNotFoundException {
		Optional<Cantones> cantones = cantonesrespoRepository.findById(id);
		System.out.println("cantones " + cantones.isPresent());

		return cantones;
	}

	@PostMapping("/cantones")
	public ResponseEntity<Cantones> createCantones(@RequestBody Cantones padre) {

		if (padre.getId() != null) {
			return ResponseEntity.badRequest().header("Content-Type", "application/json").body(null);
		}
		Cantones result = cantonesrespoRepository.save(padre);
		return ResponseEntity.ok().header("Content-Type", "application/json").body(result);
	}

	@PutMapping("/cantones/{id}")
	public ResponseEntity<String> updateCantones(@RequestBody Cantones cantones, @PathVariable Long id)
			throws ResourceNotFoundException {

		Cantones encontrarCantones = getCantones(id)
				.orElseThrow(() -> new ResourceNotFoundException("No se encontro el Id"));

		encontrarCantones.setNombre(cantones.getNombre());
		encontrarCantones.setProvincia(cantones.getProvincia());
		encontrarCantones.setDescripcion(cantones.getDescripcion());

		Cantones actualizarCantones = cantonesrespoRepository.save(encontrarCantones);

		return ResponseEntity.ok().header("Content-Type", "application/json")
				.body("{\"mensaje\": \"El canton se actualizo correctamente " + "" + "\"}");

	}

	@DeleteMapping("/cantones/{id}")
	public ResponseEntity<String> deleteCantones(@PathVariable Long id) {
		cantonesrespoRepository.deleteById(id);

		return ResponseEntity.ok().header("Content-Type", "application/json")
				.body("{\"mensaje\": \"Se elimino correctamente el " + id + "\"}");
	}

}
