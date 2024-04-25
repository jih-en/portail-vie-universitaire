package com.cours.spring.cours.crud.db.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cours.spring.cours.crud.db.service.CourStorageService;
import com.cours.spring.cours.crud.db.message.ResponseCour;
import com.cours.spring.cours.crud.db.message.ResponseMessage;
import com.cours.spring.cours.crud.db.model.Cour;

@Controller
@CrossOrigin(origins = "*")

public class CoursController {

  @Autowired
  private CourStorageService storageService;
@Autowired
CourStorageService storageS;

  @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file ,@RequestParam("descrip") String descrip, @RequestParam("createur") String createur,@RequestParam("name") String name ) {
    String message = "";
    try {
      storageService.store(file,descrip,createur,name);

      message = "Uploaded the Cour successfully: " + file.getOriginalFilename();
      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
    } catch (Exception e) {
      message = "Could not upload the Cour: " + file.getOriginalFilename() + "!";
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
    }
  }

  @GetMapping("/Cours")
  public ResponseEntity<List<ResponseCour>> getListFiles() {
    List<ResponseCour> files = storageService.getAllFiles().map(dbFile -> {
      String fileDownloadUri = ServletUriComponentsBuilder
          .fromCurrentContextPath()
          .path("/Cour/")
          .path(dbFile.getId())
          .toUriString();

      return new ResponseCour(
          dbFile.getName(),
          fileDownloadUri,
          dbFile.getType(),
          dbFile.getUpDate(),
          dbFile.getData().length,
              dbFile.getDescrip(),
              dbFile.getCreateur());

    }).collect(Collectors.toList());


    return ResponseEntity.status(HttpStatus.OK).body(files);
  }

  @GetMapping("/Cour/{id}")
  public ResponseEntity<byte[]> getFile(@PathVariable String id) {
    Cour fileDB = storageService.getFile(id);

    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
        .body(fileDB.getData());
  }
  @PostMapping("update/{id}")
  public ResponseEntity<ResponseMessage> updateCours(@PathVariable String id,
                                                    @RequestParam("descrip") String descrip,
                                                    @RequestParam("createur") String createur,
                                                    @RequestParam("name") String name)
          {
    try {
      storageService.updateCours(id, descrip, createur,name);
      return ResponseEntity.ok(new ResponseMessage("Cours updated successfully."));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("Could not update cours."));
    }
  }
  @DeleteMapping("delete/{id}")
  public ResponseEntity<ResponseMessage> deleteCours(@PathVariable String id) {
    try {
      storageService.deleteCours(id);
      return ResponseEntity.ok(new ResponseMessage("Cours deleted successfully."));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("Could not delete Cours."));
    }
  }
  @GetMapping("Cou/{id}")
  public ResponseEntity<Cour> getFilee(@PathVariable String id) {

    Optional<Cour> fileDB = Optional.ofNullable(storageS.getFile(id));
    return fileDB.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

}
