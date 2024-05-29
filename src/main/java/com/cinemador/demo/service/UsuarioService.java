package com.cinemador.demo.service;

import com.cinemador.demo.entity.Usuario;
import com.cinemador.demo.usuarios.dto.UsuarioRegistroDto;

public interface UsuarioService {

    public Usuario save(UsuarioRegistroDto usuarioRegistroDto);
}
