package com.cinemador.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cinemador.demo.entity.Pelicula;
import com.cinemador.demo.service.PeliculaService;

@Controller
@RequestMapping("/cinemador")
public class CargarPageController {
	
	@Autowired
	PeliculaService service;

	@Autowired
	UserDetailsService userDetailsService;

	@GetMapping("/peliculas/cargar")
	public String cargar(Model model) {
		Pelicula pelicula=new Pelicula();
		model.addAttribute("nuevosdatos", pelicula);
        return "cargar";
    }
	
	@PostMapping("/peliculas/cargar/submit")
	public String guardarPelicula(@ModelAttribute("nuevosdatos") Pelicula pelicula) {
		
		String movieTrailer = pelicula.getMovieTrailer();
		String newTrailer;

		if (movieTrailer.contains("https://www.youtube.com/watch?v=")) {
			newTrailer = movieTrailer.replace("https://www.youtube.com/watch?v=", "");
			pelicula.setMovieTrailer(newTrailer);
		}
		service.saveOrUpdate(pelicula);
		return "redirect:/cinemador/peliculas";
	}
	
}
