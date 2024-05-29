package com.cinemador.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cinemador.demo.entity.Pelicula;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {

    @Query(value = "SELECT MIN(p.movieId) FROM Pelicula p")
    Long findMinId();

    @Query(value = "SELECT MAX(p.movieId) FROM Pelicula p")
    Long findMaxId();
}
