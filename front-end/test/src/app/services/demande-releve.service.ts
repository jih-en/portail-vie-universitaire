import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { DemandeReleveNote } from '../../DemandeReleveNote';
import { environment } from '../../environements/enviroment';
@Injectable({
  providedIn: 'root'
})
export class DemandeReleveService {

  constructor(private http: HttpClient) { }
  /*
    envoyerDemande(demande: DemandeReleveNote): Observable<any> {
      return this.http.post<any>(this.apiUrl, demande);
    }*/
  
    envoyerDemande(demande: DemandeReleveNote): Observable<any> {
      return this.http.post<any>(environment.apiUrl+'/DemandeReleveNote', demande);
  }
  envoyerEmailAdministrationReleve(sujet: string, demande: DemandeReleveNote): Observable<any> {
    const contenu = `Une nouvelle demande de relevé de notes a été créée avec les détails suivants :
    - Raison : ${demande.raison}
    - Année académique : ${demande.anneeAcademique}
    - Email de l'étudiant : ${demande.etudiant.email}`;
  
    const email = { sujet, contenu, destinataire: 'dorsaf.bouoni12@gmail.com' }; // Adresse fixe
    return this.http.post<any>(environment.apiUrl+'/DemandeReleveNote ', email);
  }
}
