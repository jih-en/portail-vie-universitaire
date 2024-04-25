package com.cours.spring.cours.crud.db.service;


import com.cours.spring.cours.crud.db.Entities.Etudiant;

import java.util.List;


public interface IEtudiantService {
    List<Etudiant> getAllEtudiants();

    Etudiant createEtudiant(Etudiant etudiant);
    Etudiant getEtudiantById(long id);
    boolean deleteEtudiant(long id);
}
