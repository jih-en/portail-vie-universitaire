package com.cours.spring.cours.crud.db.controller;

import com.cours.spring.cours.crud.db.Entities.Etudiant;
import com.cours.spring.cours.crud.db.Entities.Matiere;
import com.cours.spring.cours.crud.db.Entities.note;
import com.cours.spring.cours.crud.db.message.EtudiantReponse;
import com.cours.spring.cours.crud.db.message.NotesReponse;
import com.cours.spring.cours.crud.db.service.EtudiantService;
import com.cours.spring.cours.crud.db.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin
@RequestMapping("/api/etudiant")
public class etudiantcontroller {

    @Autowired
    private EtudiantService etudiantService;

    @Autowired
    private NoteService noteService;



    @Autowired
    public etudiantcontroller(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }



    @GetMapping("/{cin}")
    public ResponseEntity<Etudiant> getEtudiantByCin(@PathVariable int cin) {
        Optional<Etudiant> etudiant = etudiantService.getEtudiantByCin(cin);
        return etudiant.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{cin}")
    public ResponseEntity<Void> updateEtudiantByCin(@PathVariable int cin, @RequestBody Etudiant etudiant) {
        Optional<Etudiant> updatedEtudiant = etudiantService.updateEtudiantByCin(cin, etudiant);
        return updatedEtudiant.isPresent() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }

   /* @GetMapping
    public List<Etudiant> getAllEtudiants() {
        return etudiantService.getAllEtudiants();
    }
    @PostMapping
    public ResponseEntity<Etudiant> createEtudiant(@RequestBody Etudiant etudiant) {
        Etudiant createdEtudiant = etudiantService.createEtudiant(etudiant);
        return ResponseEntity.ok(createdEtudiant);
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<Etudiant> getEtudiantById(@PathVariable long id) {
        Etudiant etudiant = etudiantService.getEtudiantById(id);
        if (etudiant != null) {
            return ResponseEntity.ok(etudiant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{id}/notes")
    public ResponseEntity<List<NotesReponse>> getNotesByEtudiant(@PathVariable long id) {
        List<NotesReponse> notesReponse = etudiantService.getNotesByEtudiant(id);
        if (notesReponse != null) {
            return ResponseEntity.ok(notesReponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    @GetMapping("/{id}/list")
    public ResponseEntity<EtudiantReponse> getEtudiantReponseById(@PathVariable long id) {
        Etudiant etudiant = etudiantService.getEtudiantById(id);
        EtudiantReponse etudiantReponse = new EtudiantReponse(id);
        List<Matiere> m=  noteService.findByEtudiantMatieres(id);
        List<note> n=  noteService.findByEtudiantId(id);
        etudiantReponse.setListMatier(m);
        etudiantReponse.setListnotes(n);
        etudiantReponse.setId(id);
        etudiantReponse.setNom(etudiant.getNom());
        etudiantReponse.setPreNom(etudiant.getPrenom());
        etudiantReponse.setEmail(etudiant.getEmail());


        if (etudiantReponse != null) {
            return ResponseEntity.ok(etudiantReponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Etudiant> updateEtudiant(@PathVariable long id, @RequestBody Etudiant etudiant) {
        Etudiant updatedEtudiant = etudiantService.updateEtudiant(id, etudiant);
        if (updatedEtudiant != null) {
            return ResponseEntity.ok(updatedEtudiant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEtudiant(@PathVariable long id) {
        boolean deleted = etudiantService.deleteEtudiant(id);
        if (deleted) {
            return ResponseEntity.ok("Etudiant with ID " + id + " has been deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
