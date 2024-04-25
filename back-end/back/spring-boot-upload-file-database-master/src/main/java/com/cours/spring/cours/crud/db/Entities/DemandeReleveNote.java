package com.cours.spring.cours.crud.db.Entities;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemandeReleveNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Raison;

    private String AnneeAcadémique;

    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;

    public String getAnneeAcademique() {
        return this.AnneeAcadémique;
    }
}
