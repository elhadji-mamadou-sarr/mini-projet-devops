package com.devops.gestion_etablissement.service;

import com.devops.gestion_etablissement.dto.CourRequest;
import com.devops.gestion_etablissement.dto.CoursResponse;
import com.devops.gestion_etablissement.model.Cours;
import com.devops.gestion_etablissement.repository.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourService {

    @Autowired
    private CoursRepository coursRepository;

    public void ajoutCour(CourRequest cours) {
        Cours cour = Cours.builder()
                .libelle(cours.getLibelle())
                .description(cours.getDescription())
                .classeId(cours.getClasseId())
                .build();

         coursRepository.save(cour);
    }

//    public List<Cours> getAllCours(){
//        return coursRepository.findAll();
//    }

    public List<CoursResponse> getAllCours(){
        List<Cours> coursList = coursRepository.findAll();
        return coursList.stream().map(this::mapCourResponse).collect(Collectors.toList());
    }

    private CoursResponse mapCourResponse(Cours cour) {
        return CoursResponse.builder()
                .id(cour.getId())
                .libelle(cour.getLibelle())
                .description(cour.getDescription())
                .build();
    }

    public CoursResponse getCoursById(Long id) {
        Cours cours = coursRepository.findById(id).orElse(null);
        return mapCourResponse(cours);
    }

    public CoursResponse updateCours(Long id, CourRequest cours) {
        Cours cour = coursRepository.findById(id).orElse(null);
        cour.setLibelle(cours.getLibelle());
        cour.setDescription(cours.getDescription());
        coursRepository.save(cour);
        CoursResponse courR = mapCourResponse(cour);

        return courR;
    }

    public void deleteCours(Long id) {
        coursRepository.deleteById(id);
    }

    public List<CoursResponse> getCoursByClasseId(Long classeId) {
        List<Cours> coursList = coursRepository.findByClasseId(classeId);
        return coursList.stream().map(this::mapCourResponse).collect(Collectors.toList());
    }

}
