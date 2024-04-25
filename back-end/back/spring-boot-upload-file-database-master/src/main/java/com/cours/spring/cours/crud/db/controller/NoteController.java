package com.cours.spring.cours.crud.db.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.cours.spring.cours.crud.db.Entities.Etudiant;
import com.cours.spring.cours.crud.db.Entities.note;
import com.cours.spring.cours.crud.db.service.EtudiantService;
import com.cours.spring.cours.crud.db.service.NoteService;

import java.util.Collections;
import java.util.List;
@CrossOrigin

@RestController
@RequestMapping("/api/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping
    public List<note> getAllNotes() {
        return noteService.getAllNotes();
    }

    @PostMapping
    public ResponseEntity<?> addNote(@RequestBody note note) {
        note addedNote = noteService.addNote(note);
        return ResponseEntity.ok(addedNote);
    }

    @GetMapping("/{id}")
    public ResponseEntity<note> getNoteById(@PathVariable Long id) {
        note note = noteService.getNoteById(id);
        if (note != null) {
            return ResponseEntity.ok(note);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<note> updateNote(@PathVariable Long id, @RequestBody note note) {
        note updatedNote = noteService.updateNote(id, note);
        if (updatedNote != null) {
            return ResponseEntity.ok(updatedNote);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        return ResponseEntity.ok("Note with ID " + id + " has been deleted");
    }

    @Autowired
    private EtudiantService etudiantService;

    @GetMapping("/findByEtudiant/{id}")
    public List<note> findByEtudiant(@PathVariable("id") Long id) {
        Etudiant etudiant = etudiantService.getEtudiantById(id);
        if (etudiant != null) {
            return noteService.findByEtudiantId(id);
        } else {
            return Collections.emptyList();
        }
    }


}
