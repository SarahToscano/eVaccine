package br.com.sarahtoscano.fullstackproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sarahtoscano.fullstackproject.domain.GrupoPrioridades;

import br.com.sarahtoscano.fullstackproject.repository.GrupoPrioridadesRepository;



@RestController
@RequestMapping("/grupos-prioridade")

public class GrupoPrioridadesController {

    @Autowired
    private GrupoPrioridadesRepository grupoPrioridadesRepository;

    @GetMapping
    public List <GrupoPrioridades> listarTodos (){
        return grupoPrioridadesRepository.findAll();
    }

    @GetMapping("/{codigo}")
    public GrupoPrioridades buscarPeloCodigo(@PathVariable Long codigo) {
        return grupoPrioridadesRepository.findById(codigo).orElse(null);
    }

}