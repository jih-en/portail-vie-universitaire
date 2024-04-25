package com.cours.spring.cours.crud.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cours.spring.cours.crud.db.Entities.DemandeReleveNote;

public interface DemandeReleveNoteRepository extends JpaRepository<DemandeReleveNote, Long> {
}
