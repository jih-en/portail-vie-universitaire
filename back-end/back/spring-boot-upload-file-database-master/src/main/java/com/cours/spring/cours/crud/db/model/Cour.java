package com.cours.spring.cours.crud.db.model;

import jakarta.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Entity
@Table(name = "files")
public class Cour {
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String id;

  private String name;

  private String type;

  @Lob
  private byte[] data;
  private String createur;
  private Date upDate;
  private String descrip;
  public Cour() {
  }

  public Cour(String name, String type, byte[] data, String descrip, String createur) {
    this.name = name;
    this.type = type;
    this.data = data;
    this.descrip=descrip;
    this.createur=createur;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public byte[] getData() {
    return data;
  }

  public void setData(byte[] data) {
    this.data = data;
  }

 public Date getUpDate(){return upDate;}

  public void setUpDate(Date upDate){ this.upDate=upDate;}

  public String getDescrip() {return descrip;}
    public void setDescrip(String descrip) {this.descrip = descrip;}
  public String getCreateur() {return createur;}

  public void setCreateur(String createur) {this.createur = createur;}
}
