import { Component,OnInit } from '@angular/core';
import { DemandeReleveNote } from '../../DemandeReleveNote';
import { DemandeReleveService } from '../services/demande-releve.service';
import { Etudiant } from '../../Etudiant';
import { DemandeCertificatPresence } from '../../DemandeCertificatPresence';
import { DemandeCertificatService } from '../services/demande-Certificat.service';


@Component({
  selector: 'app-demandes',
  templateUrl: './demandes.component.html',
  styleUrl: './demandes.component.css'
})
export class DemandesComponent implements OnInit {
  etudiant: Etudiant = new Etudiant();
  demandeReleveNote: DemandeReleveNote = new DemandeReleveNote(1, "", "", this.etudiant,"");
  demandeCertificatPresence: DemandeCertificatPresence = new DemandeCertificatPresence(1, "", "", this.etudiant,"");
  emailCertificatPresence: string = '';
  cinCertificatPresence: number = -1;
  raisonCertificatPresence: string = '';
  anneeCertificatPresence: string = '';
  passwordCertificatPresence: string = '';

  emailDemandeReleve: string = '';
  cinDemandeReleve: number = -1;
  raisonDemandeReleve: string = '';
  anneeDemandeReleve: string = '';
  passwordDemandeReleve: string = '';

  constructor(private demandeReleveService: DemandeReleveService, private demandeCertificatService: DemandeCertificatService) { }

  ngOnInit(): void {
  }




  envoyerDemandeCertificat(): void {
    const demandeCertificatPresence: DemandeCertificatPresence = new DemandeCertificatPresence(
      1,
      this.raisonCertificatPresence,
      this.anneeCertificatPresence,
      new Etudiant(),
      'dorsaf.bouoni12@gmail.com' // Fournir l'email de l'administration ici
    );
  
    // Envoyer la demande de certificat de présence au service
    this.demandeCertificatService.envoyerDemande(demandeCertificatPresence)
      .subscribe(
        () => {
          console.log('Demande de certificat de présence envoyée avec succès !');
          this.demandeCertificatService.envoyerEmailAdministrationCertificat(
            'Nouvelle demande de certificat de présence', 
            demandeCertificatPresence 
            
          );
          // Réinitialiser les champs après l'envoi
          this.emailCertificatPresence = '';
          this.cinCertificatPresence = -1;
          this.raisonCertificatPresence = '';
          this.anneeCertificatPresence = '';
          this.passwordCertificatPresence = '';
        },
        error => {
          console.error('Erreur lors de l\'envoi de la demande de certificat de présence : ', error);
        }
      );
  }
  
  envoyerDemandeReleve(): void {
    const demandeReleveNote: DemandeReleveNote = new DemandeReleveNote(
      1,
      this.raisonDemandeReleve,
      this.anneeDemandeReleve,
      new Etudiant(),
      'administration@example.com' // Fournir l'email de l'administration ici
    );
  
    // Envoyer la demande de relevé de notes au service
    this.demandeReleveService.envoyerDemande(demandeReleveNote)
      .subscribe(
        () => {
          console.log('Demande de relevé de notes envoyée avec succès !');
  
          this.demandeReleveService.envoyerEmailAdministrationReleve(
            'Nouvelle demande de relevé de notes', 
            demandeReleveNote
          
          );
  
          // Réinitialiser les champs après l'envoi
          this.emailDemandeReleve = '';
          this.cinDemandeReleve = -1;
          this.raisonDemandeReleve = '';
          this.anneeDemandeReleve = '';
          this.passwordDemandeReleve = '';
  
        },
        error => {
          console.error('Erreur lors de l\'envoi de la demande de relevé de notes : ', error);
        }
      );
  }
  




}

