package com.cinemador.demo.controller;

import com.cinemador.demo.entity.Pelicula;
import com.cinemador.demo.service.CustomUserDetail;
import com.cinemador.demo.service.PeliculaService;
import com.cinemador.demo.service.UsuarioService;
import com.cinemador.demo.usuarios.dto.UsuarioRegistroDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class UsuariosController {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PeliculaService peliculaService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/registro")
    public String mostrarFormuarioDeRegistro(@ModelAttribute("usuario") UsuarioRegistroDto usuarioRegistroDto) {
        return "registro";
    }

    @PostMapping("/registro")
    public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioRegistroDto usuarioRegistroDto, Model model) {
        try {
            usuarioService.save(usuarioRegistroDto);
            model.addAttribute("message", "Usuario registrado exitosamente");
        } catch (Exception e) {
            model.addAttribute("error", "Ocurrió un error al registrar el usuario: " + e.getMessage());
        }
        return "registro";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/inicio")
    public String index(Model model, Principal principal) {
        if (principal == null) {
            model.addAttribute("error", "Debe estar logueado para ver esta página.");
            return "login";
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);

        Pelicula listapelicula = peliculaService.getRandomMovie();
        model.addAttribute("datos", listapelicula);

        return "index";
    }
}
