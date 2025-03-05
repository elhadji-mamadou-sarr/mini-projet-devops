package com.devops.gestion_etablissement.controller;


import com.devops.gestion_etablissement.dto.CourRequest;
import com.devops.gestion_etablissement.dto.CoursResponse;
import com.devops.gestion_etablissement.service.CourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cours")
public class CourController {

    @Autowired
    private CourService courService;

    @GetMapping("/list")
    public String getAllCours(Model model) {
        List<CoursResponse> cours = courService.getAllCours();
        model.addAttribute("cours", cours);
        return "cours/list";
    }


    @GetMapping("/ajout")
    public  String showAdd(Model model){
        model.addAttribute("cour", new CourRequest());
        return "cours/add";
    }

    @PostMapping("/ajout")
    public  String addCours(@ModelAttribute CourRequest courRequest){
        courService.ajoutCour(courRequest);
        return "redirect:/cours/list";
    }

    @GetMapping("/{id}")
    public CoursResponse getCourById(@PathVariable Long id){
        return  courService.getCoursById(id);
    }

    @GetMapping("/edit/{id}")
    public String showEdiCour(@PathVariable Long id, Model model){
        CoursResponse cour = courService.getCoursById(id);
        model.addAttribute("cour", cour);
        return "cours/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateCour(@PathVariable Long id, @ModelAttribute CourRequest cours){
        courService.updateCours(id, cours);
        return "redirect:/cours/list";
    }

    @PostMapping("/delete/{id}")
    public String deleteCours(@PathVariable Long id){
        courService.deleteCours(id);
        return "redirect:/cours/list";
    }

}
