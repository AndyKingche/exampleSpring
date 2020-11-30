package com.example.mx.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
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

	@RequestMapping(value="/tipos/{id}", produces = { "application/json"},method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteTipos(@PathVariable Long id) {
		try {
			Tipo findTipo = getTipos(id).orElseThrow(() -> new ResourceNotFoundException("No se encontro id"));
			if(findTipo!=null) {
				int eliminar = tipoRepository.eliminarTipo(id.intValue());
				System.out.print("SI SE ELIMINO el id "+ id);
				return ResponseEntity.ok().header("Content-Type", "application/json")
						.body("{\"mensaje\": \"Se elimino correctamente el " + id + "\"}");
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.print("EXISTE UN ERROR NO SEA GIL, REVISE EL CODIGO "+ e);
		}
		
		return ResponseEntity.ok().header("Content-Type", "application/json")
				.body("{\"mensaje\": \"No Se elimino correctamente el " + id + "\"}");
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
	
	@Transactional
	@Modifying
	@RequestMapping(value="/tipos/categoria/{id}/{idcat}",produces = {"application/json"},method= RequestMethod.PUT)
	public int encontrarTipo(@RequestBody Tipo tipo, @PathVariable("id") Integer id, @PathVariable("idcat") Integer idcat) {
		System.out.println("SI ESNTREEE NO TE PREUCPES "+ tipo.getNombre()+" categoria_id: "+idcat+" id: "+id);

		int tipoActualizado= tipoRepository.actualizarTipo(tipo.getNombre(), tipo.getDescripcion(),idcat,id);
		System.out.println("hay.."+tipoActualizado);
		return tipoActualizado;
	}
	
	
}
