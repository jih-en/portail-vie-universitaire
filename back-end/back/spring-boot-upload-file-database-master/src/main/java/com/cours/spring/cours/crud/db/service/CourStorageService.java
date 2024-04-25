package com.cours.spring.cours.crud.db.service;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Stream;

import com.cours.spring.cours.crud.db.repository.CourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import com.cours.spring.cours.crud.db.model.Cour;

@Service
public class CourStorageService {

  @Autowired
  private CourRepository fileDBRepository;

  public Cour store(MultipartFile file, String descrip, String createur, String name) throws IOException {

    Cour FileDB = new Cour(name, file.getContentType(), file.getBytes(),descrip,createur);
    FileDB.setUpDate(new Date());
    return fileDBRepository.save(FileDB);
  }

  public Cour getFile(String id) {
    return fileDBRepository.findById(id).get();
  }
  
  public Stream<Cour> getAllFiles() {
    return fileDBRepository.findAll().stream();
  }

  public void updateCours(String id, String descrip, String createur,String name) {
    Optional<Cour> optionalFileDB = fileDBRepository.findById(id);
    if (optionalFileDB.isPresent()) {
      Cour fileDB = optionalFileDB.get();
      fileDB.setDescrip(descrip);
      fileDB.setCreateur(createur);
      fileDB.setName(name);
      fileDBRepository.save(fileDB);
    }
  }
  public void deleteCours(String id) {
    fileDBRepository.deleteById(id);
  }

  public Optional<Cour> getFilee(String id) {
    return fileDBRepository.findById(id);
  }

}
