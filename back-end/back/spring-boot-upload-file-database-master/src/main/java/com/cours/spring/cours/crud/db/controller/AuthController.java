package com.cours.spring.cours.crud.db.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cours.spring.cours.crud.db.message.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.cours.spring.cours.crud.db.Entities.Etudiant;
import com.cours.spring.cours.crud.db.service.EtudiantService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("")

public class AuthController {

    @Autowired
    private EtudiantService etudiantService;

    @PostMapping("/api/login")
    public long login(@RequestBody LoginRequest request) {
        System.out.print(request.getEmail());System.out.print(request);
        Etudiant etudiant = etudiantService.getEtudiantByEmail(request.getEmail());
        System.out.print("ghgc"+etudiant.getNom());
        if (etudiant != null && etudiant.getPassword().equals(request.getPassword())) {

            return etudiant.getId();
        } else {
            return 0;
        }
    }
}
