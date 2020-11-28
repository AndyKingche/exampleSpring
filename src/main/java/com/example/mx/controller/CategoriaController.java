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

import com.example.mx.domain.Categoria;
import com.example.mx.domain.Tipo;
import com.example.mx.repository.CategoriaRepository;
import com.example.mx.repository.TipoRepository;
import com.example.mx.controller.TipoContoller;

@RestController
@RequestMapping("/api")
public class CategoriaController {
	@Autowired
	CategoriaRepository categoriaRepository;
	TipoRepository tipoRepository;
	TipoContoller tipocontroller;

	@GetMapping("/categorias")
	public List<Categoria> getAllCategorias() {
		List<Categoria> page = categoriaRepository.findAll();
		return page;
	}

	@GetMapping("/categorias/{id}")
	public Optional<Categoria> getCategorias(@PathVariable Long id) throws ResourceNotFoundException {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		//System.out.println(categoria.get());
		return categoria;
	}

	public Optional<Tipo> getTipos(@PathVariable Long id) throws ResourceNotFoundException {
		Optional<Tipo> tipo = tipoRepository.findById(id);
		System.out.print("estoy adentro de getTipos");
		System.out.println(tipo.get());
		return tipo;
	}
	@PostMapping("/categorias")
	Categoria newCategoria(@RequestBody Categoria newCategoria) {
		System.out.print("ES EL TIPO"+newCategoria.getTipo());
		System.out.print("ES LA CATEGORIA"+categoriaRepository.save(newCategoria));

		return categoriaRepository.save(newCategoria);
	}

	@PutMapping("/categorias/{id}")
	public ResponseEntity<String> updateCategorias(@RequestBody Categoria categoria, @PathVariable Long id)
			throws ResourceNotFoundException {
		Categoria findCategoria = getCategorias(id)
				.orElseThrow(() -> new ResourceNotFoundException("No se encontro id"));

		findCategoria.setNombre(categoria.getNombre());
		findCategoria.setDescripcion(categoria.getDescripcion());
		
		/*for(Tipo x : categoria.getTipo()) {
		System.out.print("este es el id");
		System.out.print(x.getId());
		System.out.print(x.getNombre());
		System.out.print(x.getDescripcion());
			 Tipo findTipo= getTipos(x.getId()).
					orElseThrow(()->new ResourceNotFoundException("No se encontro id"));
			System.out.println(findTipo);
			findTipo.setNombre(x.getNombre());
			findTipo.setDescripcion(x.getDescripcion());
			//findTipo.setCategoria(x.getCategoria());	
			final Tipo actualizarTipo = tipoRepository.save(findTipo);			
			System.out.println(actualizarTipo);	
		}*/
	
		final Categoria actualizarCategoria = categoriaRepository.save(findCategoria);
		System.out.println(actualizarCategoria);
		return ResponseEntity.ok().header("Content-Type", "application/json")
				.body("{\"mensaje\": \"La categoria se actualizo correctamente " + "" + "\"}");
}
	
	
	@RequestMapping(value="/categorias/find/{name}", produces = {"application/json"}, method= RequestMethod.GET)
		public List<Categoria> findByName(@PathVariable("name") String name){
		List<Categoria> categoria = categoriaRepository.findByName(name);
		
		return categoria;
	}

	@DeleteMapping("/categorias/{id}")
	public ResponseEntity<String> deleteCategorias(@PathVariable Long id) {
		categoriaRepository.deleteById(id);
		return ResponseEntity.ok().header("Content-Type", "application/json")
				.body("{\"mensaje\": \"Se elimino correctamente el " + id + "\"}");
	}

	

}
