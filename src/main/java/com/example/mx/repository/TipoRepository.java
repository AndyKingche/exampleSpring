package com.example.mx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mx.domain.Tipo;

public interface TipoRepository extends JpaRepository <Tipo, Long> {

}
