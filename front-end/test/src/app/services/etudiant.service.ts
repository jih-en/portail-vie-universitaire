import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { etudiant } from '../request/etudiant';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Etudiant } from '../../Etudiant';
import { environment } from '../../environements/enviroment';



@Injectable({
  providedIn: 'root'
})
export class EtudiantService {

  private apiUrl = '/api/etudiant';

  constructor(private http: HttpClient) {}

  // Method to get a student by ID
  getEtudiantById(id: number): Observable<any> {
    return this.http.get<any>('/api/etudiant/'+id);
  }
 // getEtudiantById(id: number): Observable<any> {
   // return this.http.get<any>(`${this.apiUrl}/${id}`);
  //}
 
  getNotesByEtudiantId(id: number): Observable<any[]> {
    return this.http.get<any[]>(`/api/etudiant/${id}/notes`);
  }
   

  // Method to update student information
  updateEtudiant(id: number, data: etudiant): Observable<etudiant> {
    return this.http.put<any>(`${this.apiUrl}/${id}`, data);
  }

  // Method to download the student's profile picture
  downloadProfilePicture(id: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/${id}/profile-picture`, { responseType: 'blob' as 'json' });
  }


  /*private apiUrl = 'http://localhost:8084/api/etudiant';*/

  

  /*getEtudiantByCin(CIN: number): Observable<Etudiant> {
    return this.http.get<Etudiant>(`${this.apiUrl}/${CIN}`);
  }*/

    getEtudiantByCin(CIN: number): Observable<Etudiant> {
    return this.http.get<Etudiant>(environment.apiUrl+'/etudiant/'+CIN);
  }
  updateEtudiantByCin(CIN: number, etudiant: Etudiant): Observable<void> {
    return this.http.put<void>(environment.apiUrl+'/etudiant/'+CIN, etudiant);
  }
}
