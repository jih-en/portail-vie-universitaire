package com.cours.spring.cours.crud.db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.cours.spring.cours.crud.db.controller.NoteController;
import com.cours.spring.cours.crud.db.Entities.Matiere;
import com.cours.spring.cours.crud.db.Entities.note;
import com.cours.spring.cours.crud.db.Entities.Etudiant;
import com.cours.spring.cours.crud.db.repository.noteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteService {

    private final noteRepository noteRepository1;

    @Autowired
    public NoteService(noteRepository noteRepository1) {
        this.noteRepository1 = noteRepository1;
    }
    public List<note> getAllNotes() {
        return (List<note>) noteRepository1.findAll();
    }


  /*  public List<note> findByEtudiantId(long etudiantId) {
        // Fetch all notes
        List<note> allNotes = (List<note>) noteRepository1.findAll();

        // Filter notes based on the provided student ID
        return allNotes.stream()
                .filter(note -> note.getEtudiantList().stream()
                        .anyMatch(etudiant -> etudiant.getId() == etudiantId))
                .collect(Collectors.toList());

    }

   */

    public note getNoteById(Long id) {
        return noteRepository1.findById(id).orElse(null);
    }

    public note addNote(note note) {
        return noteRepository1.save(note);
    }

    public note updateNote(Long id, note note) {
        if (!noteRepository1.existsById(id)) {
            return null; // Note with given id doesn't exist
        }
        note.setId(id);
        return noteRepository1.save(note);
    }

    public void deleteNote(Long id) {
        noteRepository1.deleteById(id);
    }


    public List<note> findByEtudiantId(Long id) {
        return noteRepository1.findByEtudiant(id);
    }
    public List<Matiere> findByEtudiantMatieres(Long id) {
        return noteRepository1.findByEtudiantMatieres(id);
    }

}
