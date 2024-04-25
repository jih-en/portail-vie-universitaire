package com.cours.spring.cours.crud.db.Entities;

/*import jakarta.persistence.*;*/
        import jakarta.persistence.*;
        import lombok.*;
        import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import com.cours.spring.cours.crud.db.Entities.Etudiant;


import java.io.Serializable;
import java.util.List;


@Data @NoArgsConstructor @AllArgsConstructor @Entity

@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "T_Classe")
public class Classe implements Serializable {
    @Id
    @Column( name = "id_classe")
    private String id_classe;

    @OneToMany(mappedBy = "classe", cascade = CascadeType.ALL)
    private List<Etudiant> etudiants;

}
