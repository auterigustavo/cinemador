package com.cinemador.demo.service;

import com.cinemador.demo.entity.Usuario;
import com.cinemador.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario user = usuarioRepository.findByEmail(username);
        if (user == null){
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return new CustomUserDetail(user);
    }
}
