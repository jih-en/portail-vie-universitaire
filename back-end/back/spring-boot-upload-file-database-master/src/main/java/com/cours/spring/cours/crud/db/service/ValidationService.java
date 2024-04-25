package com.cours.spring.cours.crud.db.service;


import com.cours.spring.cours.crud.db.Entities.Etudiant;
import com.cours.spring.cours.crud.db.Entities.Validation;
import com.cours.spring.cours.crud.db.repository.ValidationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Random;

import static java.time.temporal.ChronoUnit.MINUTES;

@AllArgsConstructor
@Service
public class ValidationService {
/*
    private ValidationRepository validationRepository;


    public void enregistrer(Etudiant etudiant) {
        Validation validation = new Validation();
        validation.setUtilisateur(etudiant);
        Instant creation = Instant.now();
        validation.setCreation(creation);
        Instant expiration = creation.plus(10, MINUTES);
        validation.setExpiration(expiration);
        Random random = new Random();
        int randomInteger = random.nextInt(999999);
        String code = String.format("%06d", randomInteger);

        validation.setCode(code);
        this.validationRepository.save(validation);

    }

    public Validation lireEnFonctionDuCode(String code) {
        return this.validationRepository.findByCode(code).orElseThrow(() -> new RuntimeException("Votre code est invalide"));
    }


 */}