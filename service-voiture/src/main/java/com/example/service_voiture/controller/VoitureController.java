package com.example.service_voiture.controller;

import com.example.service_voiture.entities.Voiture;
import com.example.service_voiture.repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class VoitureController {


    @Autowired
    VoitureRepository voitureRepository;


    @GetMapping("/voitures")
    public List<Voiture> findAll() {
        return voitureRepository.findAll();
    }
    @GetMapping("voitures/{id}")
    public Voiture getVoiture(@PathVariable Long id) throws Exception {
        return voitureRepository.findById(id)
                .orElseThrow(()-> new Exception("voiture non trouvée") );
    }


}
