package com.cours.spring.cours.crud.db.service;

import org.springframework.beans.factory.annotation.Autowired;


import com.cours.spring.cours.crud.db.Entities.Etudiant;
import com.cours.spring.cours.crud.db.Entities.Matiere;
import com.cours.spring.cours.crud.db.Entities.note;
import com.cours.spring.cours.crud.db.message.NotesReponse;
import com.cours.spring.cours.crud.db.repository.EtudiantRepository;
import com.cours.spring.cours.crud.db.repository.noteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService implements IEtudiantService  {


    @Autowired
    private  EtudiantRepository etudiantRepository;
    @Autowired
    noteRepository noteRepositor;
    @Override
    public Etudiant createEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public Etudiant getEtudiantById(long id) {
        return etudiantRepository.findById(id);
    }



    public Etudiant updateEtudiant(long id, Etudiant etudiant) {
        return etudiantRepository.save(etudiantRepository.findById(id));
    }
    public Etudiant updateEtudiantA(long id, Etudiant etudiant) {
        Optional<Etudiant> optionalEtudiant = Optional.ofNullable(etudiantRepository.findById(id));
        if (optionalEtudiant.isPresent()) {
            Etudiant existingEtudiant = optionalEtudiant.get();
            existingEtudiant.setNom(etudiant.getNom());
            existingEtudiant.setPrenom(etudiant.getPrenom());
            // Set other properties as needed
            return etudiantRepository.save(existingEtudiant);
        } else {
            // Handle if etudiant with given id is not found
            return null;
        }
    }

    @Override
    public boolean deleteEtudiant(long id) {
        etudiantRepository.delete(etudiantRepository.findById(id));
        return false;
    }
    public List<Etudiant> getAllEtudiants() {
        return (List<Etudiant>)etudiantRepository.findAll();

    }
    public List<note> getNotesByEtudiantId(long id) {

        List<note> byEtudiant = noteRepositor.findByEtudiant(id);
        return byEtudiant;

    }
    public List<Matiere> getMatieresByEtudiantId(long id) {

        List<Matiere> byEtudiant = noteRepositor.findByEtudiantMatieres(id);
        return byEtudiant;

    }

    public Etudiant getEtudiantByEmail(String email) {
        return etudiantRepository.findByEmail(email);
    }
    public List<NotesReponse> getNotesByEtudiant(long id) {return  etudiantRepository.getNotesByEtudiant(id);
    }



    public Optional<Etudiant> getEtudiantByCin(int cin) {
        return etudiantRepository.findByCIN(cin);
    }

    public Optional<Etudiant> updateEtudiantByCin(int cin, Etudiant etudiant) {
        Optional<Etudiant> existingEtudiant = etudiantRepository.findByCIN(cin);
        if (existingEtudiant.isPresent()) {
            etudiant.setId(existingEtudiant.get().getId()); // Assurez-vous que l'ID reste le même
            return Optional.of(etudiantRepository.save(etudiant));
        }
        return Optional.empty();
    }






    // Méthode pour récupérer un étudiant par son ID
    public Etudiant getEtudiantById(Long id) {
        return etudiantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Étudiant non trouvé"));
    }

    // Méthode pour enregistrer un étudiant
    public Etudiant saveEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    // Méthode pour supprimer un étudiant par son ID
    public void deleteEtudiantById(Long id) {
        etudiantRepository.deleteById(id);
    }

    // Méthode pour mettre à jour les attributs d'un étudiant
    public Etudiant updateEtudiant(Long id, Etudiant newEtudiantData) {
        // Vérifie si l'étudiant existe
        Etudiant existingEtudiant = etudiantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Étudiant non trouvé"));

        // Met à jour les attributs de l'étudiant existant avec les nouvelles valeurs
        existingEtudiant.setNom(newEtudiantData.getNom());
        existingEtudiant.setPrenom(newEtudiantData.getPrenom());
        // Mettez à jour d'autres attributs selon vos besoins

        // Enregistre les modifications dans la base de données et renvoie l'étudiant mis à jour
        return etudiantRepository.save(existingEtudiant);
    }
}

