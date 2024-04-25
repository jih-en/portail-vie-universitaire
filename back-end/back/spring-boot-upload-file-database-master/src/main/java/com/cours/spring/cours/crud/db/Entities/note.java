package com.cours.spring.cours.crud.db.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
/*import jakarta.persistence.*;*/
import lombok.*;
import lombok.experimental.SuperBuilder;
import com.cours.spring.cours.crud.db.Entities.Matiere;

import jakarta.persistence.*;
import java.util.List;


@Data @NoArgsConstructor @AllArgsConstructor @Entity

@EqualsAndHashCode
public class note {

    @Id
    private Long id_note;
    @Column( name = "noteDs")
    private float noteDs;
    @Column( name = "noteTp")
    private float noteTp;
    @Column( name = "noteExam")
    private float noteExam;
    @Column( name = "noteProjet")
    private float noteProjet;
    @Column( name = "remarque")
    private String remarque;

    @ManyToOne
    @JoinColumn(name = "id_matiere")
    private Matiere matiere;

    @ManyToOne
    @JoinColumn(name = "id_etudiant")
    private Etudiant etudiant;

    public void setId(Long id) {
        this.id_note = id;
    }



}
