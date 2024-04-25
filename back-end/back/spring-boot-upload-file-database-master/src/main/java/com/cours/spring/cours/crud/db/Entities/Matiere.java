package com.cours.spring.cours.crud.db.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
/*import jakarta.persistence.*;*/
import jakarta.persistence.*;
import lombok.*;
        import lombok.experimental.SuperBuilder;


import java.io.Serializable;
import java.util.List;


@Data @NoArgsConstructor @AllArgsConstructor @Entity

@EqualsAndHashCode
@Table(name = "T_Matiere")

public class Matiere  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column( name = "id_matiere")
    private long id;

    @Column( name = "Nom_Matiere")
    private String Matiere;
    @Column( name = "module")
    private String Module;


}

