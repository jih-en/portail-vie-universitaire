import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { login } from '../Respense/login';



@Injectable({
  providedIn: 'root'
})
export class AuthService {

  
 
  constructor(private http: HttpClient) { }

  loginUser(loginData: login): Observable<number> {
    return  this.http.post<number>(`/api/login`, loginData);
  } 
 // getEtudiantByEmail(email: String): Observable<Etudiant> {
  //  return this.http.get<Etudiant>('/api/etudiants/'+email);
  //}

}