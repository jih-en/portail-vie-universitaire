import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { DemandeCertificatPresence } from '../../DemandeCertificatPresence';
import { environment } from '../../environements/enviroment';

@Injectable({
  providedIn: 'root'
})
export class DemandeCertificatService {

  /* private apiUrl = 'http://localhost:8084/api/DemandeCertificatPresence';*/

  constructor(private http: HttpClient) { }

  envoyerDemande(demande: DemandeCertificatPresence): Observable<any> {
    return this.http.post<any>(environment.apiUrl+'/DemandeCetificatPresence', demande);
  }
  envoyerEmailAdministrationCertificat(sujet: string, demande: DemandeCertificatPresence): Observable<any> {
    const contenu = `Une nouvelle demande de certificat de présence a été créée avec les détails suivants :
    - Raison : ${demande.raison}
    - Année académique : ${demande.anneeAcademique}
    - Email de l'étudiant : ${demande.etudiant.email}`;

    const email = { sujet, contenu, destinataire: 'dorsaf.bouoni12@gmail.com' }; // Adresse fixe
    return this.http.post<any>(environment.apiUrl +'/DemandeCetificatPresence', email);
  }
}
