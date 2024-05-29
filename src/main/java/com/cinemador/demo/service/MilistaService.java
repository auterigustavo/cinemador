package com.cinemador.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemador.demo.entity.Milista;
import com.cinemador.demo.repository.MilistaRepository;

@Service
public class MilistaService {

    @Autowired
    MilistaRepository milistaRepository;

    //retorna toda la lista
    public List<Milista> getMovies(){
        return (List<Milista>)milistaRepository.findAll();
    }

    public void saveOrUpdate(Milista milista){
        milistaRepository.save(milista);
    }

    public void deleteUserMovie(Long movieId){
        milistaRepository.deleteById(movieId);
    }

}
