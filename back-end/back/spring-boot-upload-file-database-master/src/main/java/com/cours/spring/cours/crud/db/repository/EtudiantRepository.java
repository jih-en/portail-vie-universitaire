package com.cours.spring.cours.crud.db.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.cours.spring.cours.crud.db.Entities.Etudiant;
import com.cours.spring.cours.crud.db.Entities.Matiere;
import com.cours.spring.cours.crud.db.message.NotesReponse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EtudiantRepository extends CrudRepository<Etudiant, Long > {
    Optional<Etudiant> findByCIN(int cin);
    Etudiant findByNom(String Nom);

    @Query("SELECT m FROM Matiere m , note n WHERE n.matiere.id = m.id AND n.etudiant.id  = ?1")
    List<Matiere> findByEtudiantMatieres(long id);
    Etudiant findById(long id);

    @Query("SELECT NEW com.cours.spring.cours.crud.db.message.NotesReponse(n.id_note, n.noteTp, n.noteDs, n.noteExam, n.noteProjet, n.remarque, m.Matiere) " +
            "FROM note n " +
            "JOIN n.matiere m " + // Join with Matiere entity
            "WHERE n.etudiant.id = ?1")
    List<NotesReponse> getNotesByEtudiant(long id);

    Etudiant findByEmail(String email);
}
