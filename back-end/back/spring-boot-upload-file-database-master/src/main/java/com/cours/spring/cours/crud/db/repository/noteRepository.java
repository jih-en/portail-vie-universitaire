package com.cours.spring.cours.crud.db.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.cours.spring.cours.crud.db.Entities.Matiere;
import com.cours.spring.cours.crud.db.Entities.note;
import com.cours.spring.cours.crud.db.message.NotesReponse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface noteRepository extends CrudRepository<note,Long > {
    @Query("SELECT n FROM note n WHERE n.etudiant.id  = ?1")
    List<note> findByEtudiant(long id);

    @Query("SELECT m FROM Matiere m , note n WHERE n.matiere.id = m.id AND n.etudiant.id  = ?1")
    List<Matiere> findByEtudiantMatieres( long id);



}