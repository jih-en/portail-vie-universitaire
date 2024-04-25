package com.cours.spring.cours.crud.db.Entities;

/*import jakarta.persistence.*;*/
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.Instant;


@Data @NoArgsConstructor @AllArgsConstructor @Entity

@Table(name = "T_validation")
@SuperBuilder
public class Validation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_valid;
    private Instant creation;
    private Instant expiration;
    private Instant activation;
    private String code;
    @OneToOne(cascade = CascadeType.ALL)
    private Etudiant etudiant;

    public void setUtilisateur(Etudiant etudiant) {
    }
    @OneToOne
    @JoinColumn(name="id_valid")
    private Etudiant Etudiant;
}
