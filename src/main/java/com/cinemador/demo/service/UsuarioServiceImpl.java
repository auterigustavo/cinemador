package com.cinemador.demo.service;

import com.cinemador.demo.entity.Usuario;
import com.cinemador.demo.repository.UsuarioRepository;
import com.cinemador.demo.usuarios.dto.UsuarioRegistroDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario save(UsuarioRegistroDto usuarioRegistroDto) {
        Usuario usuario=new Usuario(usuarioRegistroDto.getNombre(),
                usuarioRegistroDto.getApellido(),
                usuarioRegistroDto.getEmail(),
                passwordEncoder.encode(usuarioRegistroDto.getPassword()),
                usuarioRegistroDto.getRole());
        usuario.setRoles("USER");
        return usuarioRepository.save(usuario);
    }

}
