package com.cinemador.demo.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.cinemador.demo.entity.Milista;
import com.cinemador.demo.entity.Pelicula;
import com.cinemador.demo.service.MilistaService;
import com.cinemador.demo.service.PeliculaService;



@Controller
@RequestMapping("/cinemador")
public class PeliculasPageController {
	
	@Autowired
	PeliculaService service;
	@Autowired
	MilistaService servicelista;
    @Autowired
    UserDetailsService userDetailsService;

	@GetMapping("/peliculas")
	public String peliculas(Model model, Principal principal) {
		List<Pelicula>listapeliculas=service.getMovies();
        model.addAttribute("datos", listapeliculas);
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);

        //Verifico el Rol
        boolean isAdmin = userDetails.getAuthorities().stream()
                .anyMatch(auth -> auth.getAuthority().equals("ADMIN"));

        model.addAttribute(model.addAttribute("isAdmin", isAdmin));

        return "peliculas";
    }

	@PostMapping("/peliculas/agregar")
    public String agregarPelicula(@RequestParam String movieTitle, @RequestParam String movieGenre,
                                   @RequestParam String movieDescription, @RequestParam String movieTrailer,
                                   @RequestParam String movieImdb, @RequestParam String movieRanking) {
        
        Milista milista = new Milista();
        String newTrailer;

        if (movieTrailer.contains("https://www.youtube.com/watch?v=")) {
            newTrailer = movieTrailer.replace("https://www.youtube.com/watch?v=", "");
            milista.setMovieTrailer(newTrailer);
        } else {
            milista.setMovieTrailer(movieTrailer);
        }

        milista.setMovieTitle(movieTitle);
        milista.setMovieGenre(movieGenre);
        milista.setMovieDescription(movieDescription);
        milista.setMovieImdb(movieImdb);
        milista.setMovieRanking(movieRanking);
        
        servicelista.saveOrUpdate(milista);

        return "redirect:/cinemador/milista";
    }
	
}
