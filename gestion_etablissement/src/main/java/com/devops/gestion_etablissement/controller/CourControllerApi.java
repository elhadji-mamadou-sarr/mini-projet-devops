package com.devops.gestion_etablissement.controller;


import com.devops.gestion_etablissement.client.ClasseClient;
import com.devops.gestion_etablissement.dto.ClasseResponse;
import com.devops.gestion_etablissement.dto.CourRequest;
import com.devops.gestion_etablissement.dto.CoursResponse;
import com.devops.gestion_etablissement.service.CourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cours")
public class CourControllerApi {

    @Autowired
    private CourService courService;

    @Autowired
    private ClasseClient classeClient;

    @PostMapping
    public void addCour(@RequestBody CourRequest cours) {
         courService.ajoutCour(cours);
    }

    @GetMapping("/classes")
    public List<ClasseResponse> getAllClasses() {
        return classeClient.getAllClassesApi();
    }

    @GetMapping("/classe/{classeId}")
    public List<CoursResponse> getCoursByClasse(@PathVariable Long classeId) {
        return courService.getCoursByClasseId(classeId);
    }

    @GetMapping
    public List<CoursResponse> getAllCours(){
        return courService.getAllCours();
    }

    @GetMapping("/{id}")
    public CoursResponse getCourById(@PathVariable Long id){
        return  courService.getCoursById(id);
    }

    @PostMapping("/edit/{id}")
    public CoursResponse updateCour(@PathVariable Long id, @RequestBody CourRequest courRequest){
        return  courService.updateCours(id, courRequest);
    }

    @PostMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        courService.deleteCours(id);
    }



}
