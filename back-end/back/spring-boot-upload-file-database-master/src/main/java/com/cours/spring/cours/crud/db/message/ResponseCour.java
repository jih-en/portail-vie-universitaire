package com.cours.spring.cours.crud.db.message;

import java.util.Date;

public class ResponseCour {
  private String name;
  private String url;
  private String type;
  private long size;
  private Date upDate;
  private String createur;
  private String descrip;

  public ResponseCour(String name, String url, String type, Date upDate, long size, String createur, String descrip ) {
    this.name = name;
    this.url = url;
    this.type = type;
    this.size = size;
    this.upDate=upDate;
    this.createur=createur;
    this.descrip=descrip;
  }



  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public long getSize() {
    return size;
  }

  public void setSize(long size) {
    this.size = size;
  }

  public Date getUpDate(){return upDate;}

  public void setUpDate(Date upDate){ this.upDate=upDate;}
  public String getCreateur() {return createur;}

 public void setCreateur(String createur) {this.createur = createur;}
public String getDescrip() {return descrip;}

public void setDescrip(String desc) {this.descrip = descrip;}

}
