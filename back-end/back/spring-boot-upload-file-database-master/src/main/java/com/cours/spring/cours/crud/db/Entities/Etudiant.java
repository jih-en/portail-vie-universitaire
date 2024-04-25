package com.cours.spring.cours.crud.db.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;


import org.hibernate.annotations.GenericGenerator;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.cours.spring.cours.crud.db.Entities.Matiere;
import com.cours.spring.cours.crud.db.Entities.level;


@Data @NoArgsConstructor @AllArgsConstructor @Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "T_Etudiant")

public class Etudiant implements Serializable //,//UserDetails
{


    @Serial
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private long  id;


    @Column( name = "Etat")
    private boolean actif = false;

    @Column( name = "Email")
    private String email;

    @Column( name = "CIN")
    private int CIN;

    @Column( name = "Password")
    private String Password;

    @Column( name = "Nom")
    private String nom;

    @Column( name = "Prenom")
    private String Prenom;

    @Enumerated(EnumType.STRING)
    @Column( name = "specialité")
    private level level;


    @OneToMany(mappedBy = "etudiant")
    private List<DemandeReleveNote> demandesReleveNote = new ArrayList<>();

    @OneToMany(mappedBy = "etudiant")
    private List<DemandeCertificatPresence> demandesCertificatsPresence = new ArrayList<>();

   /* @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    */

    /*@Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.actif;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.actif;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.actif;
    }

    @Override
    public boolean isEnabled() {
        return this.actif;
    }

     */

    @Column ( name="NumTel")
    private String NumTel;
    @Column(name="adresse")
    private String adresse;


    @ManyToOne
    @JoinColumn(name = "classe_id")
    @JsonIgnore

    private com.cours.spring.cours.crud.db.Entities.Classe classe;


}
