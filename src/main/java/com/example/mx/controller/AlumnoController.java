package com.example.mx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.example.mx.repository.AlumnoRepository;

@RestController
@RequestMapping("/api")

public class AlumnoController {

	@Autowired
	AlumnoRepository alumnoRepository;

	@GetMapping("/alumnos")
	public List<Alumno> getAllAlumnos() {
		List<Alumno> page = alumnoRepository.findAll();
		return page;
	}

	@GetMapping("/alumnos/{id}")
	public Optional<Alumno> getAlumnos(@PathVariable Long id) throws ResourceNotFoundException {
		Optional<Alumno> alumno = alumnoRepository.findById(id);
		System.out.println(alumno.get());
		return alumno;
	}
	
<<<<<<< HEAD
	@GetMapping("/alumnos/find/{name}")
	public List<Alumno> getAlumnosByName(@PathVariable String name) {
		List<Alumno> alumno = alumnoRepository.findByName(name);
		return alumno;
	}

=======
	@RequestMapping(value="/find/{name}",method = RequestMethod.GET)
	public String getAlumnoFind(@PathVariable("name") String name){
		Alumno alumno = alumnoRepository.findByName(name);
		
		Map<Long,String> map = null;
		if(alumno !=null )
		{
			map = new HashMap<Long, String>();
			
				map.put(((Long)alumno.getId()), alumno.getNombre());
			
		}
		System.out.println("estos son los alumnos"+ name);
		return "estos son los alumnos"+ name;
		
	}
	
	
>>>>>>> origin/master
	@PostMapping("/alumnos")
	Alumno newAlumno(@RequestBody Alumno newAlumno) {
		return alumnoRepository.save(newAlumno);
	}

	@PutMapping("/alumnos/{id}")
	public ResponseEntity<String> updateAlumnos(@RequestBody Alumno alumno, @PathVariable long id)
			throws ResourceNotFoundException {
		Alumno findAlumno = getAlumnos(id).orElseThrow(() -> new ResourceNotFoundException("No se encontro id"));

		findAlumno.setNombre(alumno.getNombre());
		findAlumno.setApellido(alumno.getApellido());
		findAlumno.setCedula(alumno.getCedula());
		findAlumno.setFechanacimiento(alumno.getFechanacimiento());
		findAlumno.setEdad(alumno.getEdad());
		findAlumno.setDireccion(alumno.getDireccion());
		findAlumno.setTelefono(alumno.getTelefono());
		findAlumno.setGrado(alumno.getGrado());
		findAlumno.setNumeromatricula(alumno.getNumeromatricula());
		findAlumno.setProvincia(alumno.getProvincia());
		Alumno actualizarAlumno = alumnoRepository.save(findAlumno);

		return ResponseEntity.ok().header("Content-Type", "application/json")
				.body("{\"mensaje\": \"La provincia Se actualizo correctamente " + "" + "\"}");

	}

	@DeleteMapping("/alumnos/{id}")
	public ResponseEntity<String> deleteAlumnos(@PathVariable Long id) {
		alumnoRepository.deleteById(id);
		return ResponseEntity.ok().header("Content-Type", "application/json")
				.body("{\"mensaje\": \"Se elimino correctamente el " + id + "\"}");
	}

}
