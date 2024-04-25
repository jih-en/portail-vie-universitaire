package com.cours.spring.cours.crud.db.message;


import lombok.Setter;
import com.cours.spring.cours.crud.db.Entities.note;
import com.cours.spring.cours.crud.db.Entities.Matiere;

import java.util.List;

public class EtudiantReponse {
    @Setter
    private long id;
    @Setter
    private String nom="";
    private String prenom="";
    @Setter
    private String email="";
    private List<note> notes=null; // List of notes associated with the student
    private List<Matiere> matieres=null; // List of subjects associated with the student

    public void setListMatier(List<Matiere> m){
        matieres=m;
    }public void setListnotes(List<note> m){
        notes=m;
    }

    public void setPreNom(String prenom) { this.prenom=prenom;
    }
    public EtudiantReponse(Long id) { this.id=id;

    }
    // Constructors, getters, and setters
}
