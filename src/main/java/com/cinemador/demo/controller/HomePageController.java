package com.cinemador.demo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cinemador.demo.entity.Pelicula;
import com.cinemador.demo.service.PeliculaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/cinemador")
public class HomePageController {

	@Autowired
	PeliculaService service;

	@GetMapping("/inicio")
	public String index(Model model) {
        Pelicula listapelicula=service.getRandomMovie();
		if (listapelicula == null) {
			return "index";
		} else {
			model.addAttribute("datos", listapelicula);
        	return "index";
		}
    }

	@GetMapping("/inicio/recomendar")
	public String recomendar(Model model) {
		return "redirect:/cinemador/inicio";
	}
	
	@GetMapping("/styles")
	public String styles() {
		return "add-css-demo";
	}


}
