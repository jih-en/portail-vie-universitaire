import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class NoteService {

 
  constructor(private http: HttpClient) { }

  // Méthode pour récupérer les notes à partir de l'API
  getNotes(): Observable<any[]> {
    return this.http.get<any[]>(`/api/notes`);
  }

  
}
