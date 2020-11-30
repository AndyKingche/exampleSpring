package com.example.mx.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.example.mx.domain.Alumno;
import com.example.mx.domain.Tipo;

public interface TipoRepository extends JpaRepository <Tipo, Long> {
	@Query(value = "SELECT * FROM tipo WHERE categoria_id =?", nativeQuery = true)
	List<Tipo> findByForeingKey(Integer id);
	
	@Query(value="SELECT COUNT(*) FROM tipo WHERE categoria_id=? ", nativeQuery = true)
	int numeroTipo(Integer id);	
	
	@Query(value="UPDATE tipo SET nombre=?, descripcion=?, categoria_id=? WHERE id=?", nativeQuery = true)
		int actualizarTipo(String nombre, String descripcion, Integer categoria_id,Integer id);
	
	@Query(value="DELETE FROM tipo WHERE id=? ", nativeQuery = true)
	int eliminarTipo(Integer id);

}
