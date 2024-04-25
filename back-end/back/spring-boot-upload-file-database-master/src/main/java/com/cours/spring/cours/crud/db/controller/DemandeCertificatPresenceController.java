package com.cours.spring.cours.crud.db.controller;

import com.cours.spring.cours.crud.db.Entities.DemandeCertificatPresence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cours.spring.cours.crud.db.service.DemandeCertificatPresenceService;
import com.cours.spring.cours.crud.db.repository.DemandeCertificatPresenceRepository;
import com.cours.spring.cours.crud.db.Entities.DemandeCertificatPresence;

@RestController
@RequestMapping("/api/DemandeCetificatPresence")
@CrossOrigin (origins = "*")
public class DemandeCertificatPresenceController {

    private final DemandeCertificatPresenceService demandeCertificatPresenceService;

    @Autowired
    public DemandeCertificatPresenceController(DemandeCertificatPresenceService demandeCertificatPresenceService) {
        this.demandeCertificatPresenceService = demandeCertificatPresenceService;
    }

    @PostMapping()
    public ResponseEntity<DemandeCertificatPresence> createDemandeCertificatPresence(@RequestBody DemandeCertificatPresence demandeCertificatPresence) {
        DemandeCertificatPresence nouvelleDemande = demandeCertificatPresenceService.createDemande(demandeCertificatPresence);
        return ResponseEntity.ok(nouvelleDemande);
    }
}

