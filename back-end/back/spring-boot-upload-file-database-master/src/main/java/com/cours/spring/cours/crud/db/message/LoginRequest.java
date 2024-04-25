package com.cours.spring.cours.crud.db.message;


import lombok.Getter;
import lombok.Setter;

public class LoginRequest {
    // Getters and setters
    @Getter
    @Setter
    private String email;
    @Getter
    private String password;
    private Long id_l;

    public void setId_l(long a){ id_l=a;}


}

