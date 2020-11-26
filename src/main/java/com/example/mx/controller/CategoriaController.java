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

import com.example.mx.domain.Categoria;
import com.example.mx.domain.Tipo;
import com.example.mx.repository.CategoriaRepository;

@RestController
@RequestMapping("/api")
public class CategoriaController {
	@Autowired
	CategoriaRepository categoriaRepository;

	@GetMapping("/categorias")
	public List<Categoria> getAllCategorias() {
		List<Categoria> page = categoriaRepository.findAll();
		return page;
	}

	@GetMapping("/categorias/{id}")
	public Optional<Categoria> getCategorias(@PathVariable Long id) throws ResourceNotFoundException {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		System.out.println(categoria.get());
		return categoria;
	}

	@PostMapping("/categorias")
	Categoria newCategoria(@RequestBody Categoria newCategoria) {
		System.out.println(newCategoria.getTipo());
		return categoriaRepository.save(newCategoria);
	}

	@PutMapping("/categorias/{id}")
	public ResponseEntity<String> updateCategorias(@RequestBody Categoria categoria, @PathVariable long id)
			throws ResourceNotFoundException {
		Categoria findCategoria = getCategorias(id).orElseThrow(() -> new ResourceNotFoundException("No se encontro id"));

		findCategoria.setNombre(categoria.getNombre());
		findCategoria.setDescripcion(categoria.getDescripcion());
		findCategoria.setTipo(categoria.getTipo());

		
		Categoria actualizarCategoria = categoriaRepository.save(findCategoria);

		return ResponseEntity.ok().header("Content-Type", "application/json")
				.body("{\"mensaje\": \"La categoria se actualizo correctamente " + "" + "\"}");
	}

	@DeleteMapping("/categorias/{id}")
	public ResponseEntity<String> deleteCategorias(@PathVariable Long id) {
		categoriaRepository.deleteById(id);
		return ResponseEntity.ok().header("Content-Type", "application/json")
				.body("{\"mensaje\": \"Se elimino correctamente el " + id + "\"}");
	}


}
