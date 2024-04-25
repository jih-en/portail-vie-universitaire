package com.cours.spring.cours.crud.db.controller;

import com.cours.spring.cours.crud.db.Entities.DemandeReleveNote;
import com.cours.spring.cours.crud.db.service.DemandeReleveNoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/DemandeReleveNote")
@CrossOrigin (origins = "*")
public class DemandeReleveNoteController {

    private final DemandeReleveNoteService demandeReleveNoteService;


    public DemandeReleveNoteController(DemandeReleveNoteService demandeReleveNoteService ) {
        this.demandeReleveNoteService = demandeReleveNoteService;

    }

    @PostMapping()
    public ResponseEntity<DemandeReleveNote> createDemandeReleveNote(@RequestBody DemandeReleveNote demandeReleveNote) {
        DemandeReleveNote newDemandeReleveNote = demandeReleveNoteService.creerDemandeReleveNote(demandeReleveNote); // Utilisation de la méthode correcte
        return ResponseEntity.ok(newDemandeReleveNote);
    }
}

    /*
    @PostMapping()
    public ResponseEntity<DemandeReleveNote> createDemandeReleveNote(@RequestBody DemandeReleveNote demandeReleveNote) {
        DemandeReleveNote newDemandeReleveNote = demandeReleveNoteService.createDemande(demandeReleveNote);
        return ResponseEntity.ok(newDemandeReleveNote);
    }*/


