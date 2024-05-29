package com.cinemador.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemador.demo.repository.PeliculaRepository;
import com.cinemador.demo.entity.Pelicula;

@Service
public class PeliculaService {

	@Autowired
	PeliculaRepository peliculaRepository;
	
	//retorna toda la lista
	public List<Pelicula> getMovies(){
		return (List<Pelicula>)peliculaRepository.findAll();
	}
	
	//debo lograr que obtenga una pelicula al azar
	public Pelicula getRandomMovie(){
		Long minId = peliculaRepository.findMinId();
		Long maxId = peliculaRepository.findMaxId();
		Random randomNumber = new Random();
		
		if (minId == null || maxId == null) {
			return null;
		} else {
			while (true) {
				Long randomId = minId+randomNumber.nextLong(maxId - minId + 1);
				Optional <Pelicula> peliculaOptional = peliculaRepository.findById(randomId);
				if (peliculaOptional.isPresent()) {
					return peliculaOptional.get();
				}
			}
		}
	}
	
	public void saveOrUpdate(Pelicula pelicula){
		peliculaRepository.save(pelicula);
	}
}
