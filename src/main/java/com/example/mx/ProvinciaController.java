package com.example.mx;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public Optional<Provincia> getProvincias(@PathVariable Long id) {
		Optional<Provincia> provincia = provinciaRepository.findById(id);
		return provincia;
	}
 
	/*
	@PostMapping("/provincias")
	public ResponseEntity<Provincia> createProvincias(@Valid @RequestBody Provincia padre) throws URISyntaxException {
		System.out.println(padre.getNombre());
		System.out.println(padre.getDescripcion());
		if (padre.getId() != null) {
			return ResponseEntity.badRequest()
					.headers(
							HeaderUtil.createFailureAlert("Notas", "idexists", "A new padre cannot already have an ID"))
					.body(null);
		}

		Provincia result = provinciaRepository.save(padre);
		return ResponseEntity.created(new URI("/api/notas/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert("Notas", result.getId().toString())).body(result);
	}

	// UPDATE
	@PutMapping("/provincias")
	public ResponseEntity<Provincia> updateProvincias(@Valid @RequestBody Provincia provincia)
			throws URISyntaxException {
		Provincia result = provinciaRepository.save(provincia);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityUpdateAlert("NOTA", provincia.getId().toString()))
				.body(result);
	}

	// OK
	@DeleteMapping("/provincias/{id}")
	public ResponseEntity<Void> deleteProvincias(@PathVariable Long id) {
		provinciaRepository.delete(id);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("provincias", id.toString())).build();
	}
	*/

	 
	 
}
 
