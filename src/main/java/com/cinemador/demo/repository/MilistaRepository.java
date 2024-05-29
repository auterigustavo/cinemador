package com.cinemador.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinemador.demo.entity.Milista;

@Repository
public interface MilistaRepository extends JpaRepository<Milista, Long> {

}
