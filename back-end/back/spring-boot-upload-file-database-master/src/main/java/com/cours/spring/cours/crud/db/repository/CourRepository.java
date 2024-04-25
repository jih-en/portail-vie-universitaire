package com.cours.spring.cours.crud.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cours.spring.cours.crud.db.model.Cour;

@Repository
public interface CourRepository extends JpaRepository<Cour, String> {

}
