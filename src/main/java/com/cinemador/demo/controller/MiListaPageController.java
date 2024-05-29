package com.cinemador.demo.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cinemador.demo.entity.Milista;
import com.cinemador.demo.service.MilistaService;
import com.cinemador.demo.service.PeliculaService;

@Controller
@RequestMapping("/cinemador")
public class MiListaPageController {

    @Autowired
    MilistaService servicelista;
    PeliculaService servicepelicula;

	@GetMapping("/milista")
	public String milista(Model model) {
        List<Milista>listadeusuario=servicelista.getMovies();
        model.addAttribute("datos", listadeusuario);
        return "milista";
    }

    @PostMapping("/milista/quitar")
    public String quitarDeLista(@RequestParam String movieId){
        Long modifiedMovieId = Long.parseLong(movieId);
        servicelista.deleteUserMovie(modifiedMovieId);
        return "redirect:/cinemador/milista";
    }
    
}
