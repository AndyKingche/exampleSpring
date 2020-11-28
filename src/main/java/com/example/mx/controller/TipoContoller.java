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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.mx.domain.Alumno;
import com.example.mx.domain.Tipo;
import com.example.mx.repository.TipoRepository;

@RestController
@RequestMapping("/api")
public class TipoContoller {
	@Autowired
	TipoRepository tipoRepository;

	@GetMapping("/tipos")
	public List<Tipo> getAllTipos() {
		List<Tipo> page = tipoRepository.findAll();
		return page;
	}

	@GetMapping("/tipos/{id}")
	public Optional<Tipo> getTipos(@PathVariable Long id) throws ResourceNotFoundException {
		Optional<Tipo> tipo = tipoRepository.findById(id);
		System.out.print("estoy adentro de getTipos");
		System.out.println(tipo.get());
		return tipo;
	}

	@PostMapping("/tipos")
	Tipo newTipo(@RequestBody Tipo newTipo) {
		return tipoRepository.save(newTipo);
	}

	@PutMapping("/tipos/{id}")
	public ResponseEntity<String> updateTipos(@RequestBody Tipo tipo, @PathVariable Long id)
			throws ResourceNotFoundException {
		Tipo findTipo = getTipos(id).orElseThrow(() -> new ResourceNotFoundException("No se encontro id"));

		findTipo.setNombre(tipo.getNombre());
		findTipo.setDescripcion(tipo.getDescripcion());
		findTipo.setCategoria(tipo.getCategoria());
		System.out.println(tipo.getCategoria());
		Tipo actualizarTipo = tipoRepository.save(findTipo);

		return ResponseEntity.ok().header("Content-Type", "application/json")
				.body("{\"mensaje\": \"La categoria se actualizo correctamente " + "" + "\"}");
	}

	@DeleteMapping("/tipos/{id}")
	public ResponseEntity<String> deleteTipos(@PathVariable Long id) {
		tipoRepository.deleteById(id);
		return ResponseEntity.ok().header("Content-Type", "application/json")
				.body("{\"mensaje\": \"Se elimino correctamente el " + id + "\"}");
	}
	@RequestMapping(value="/tipos/find/{id}", produces = { "application/json"},method = RequestMethod.GET)
	public List<Tipo> findByName(@PathVariable("id") Integer id){
		List<Tipo> tipo = tipoRepository.findByForeingKey(id);
	
		return tipo;
		}
	
	@RequestMapping(value="/tipos/number/{id}",produces = {"application/json"},method= RequestMethod.GET)
	public int numberTipo(@PathVariable("id") Integer id) {
		int numeroTipo= tipoRepository.numeroTipo(id);
		System.out.println("hay.."+numeroTipo);
		return numeroTipo;
	}
	
	@RequestMapping(value="/tipos/categoria/{id}/{idcat}",produces = {"application/json"},method= RequestMethod.PUT)
	public String encontrarTipo(@RequestBody Tipo tipo, @PathVariable("id") Integer id, @PathVariable("idcat") Integer idcat) {
		System.out.println("SI ESNTREEE NO TE PREUCPES "+ tipo.getNombre()+" "+id);
		
		
		List<Tipo> tipoActualizado= tipoRepository.actualizarTipo(tipo.getNombre(), tipo.getDescripcion(),idcat,id);
		System.out.println("hay.."+tipoActualizado);
		return "Si entre";
	}
	
}
