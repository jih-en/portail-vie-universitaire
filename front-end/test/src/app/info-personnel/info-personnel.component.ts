import { Component } from '@angular/core';
import { Etudiant } from '../../Etudiant';
import { EtudiantService } from '../services/etudiant.service';

@Component({
  selector: 'app-info-personnel',
  templateUrl: './info-personnel.component.html',
  styleUrl: './info-personnel.component.css'
})
export class InfoPersonnelComponent {
  /*
  @Input() nom: string='nom de l etudiant';
  @Input() prenom: string='prénom de l etudiant';
  @Input() adresse: string='adresse actuelle';
  @Input() NumTel:Number=22222222

  @Input() email: string='etudiant@gmail.com';


  */
 
  cin: number = 1; // Le numéro CIN de l'étudiant à récupérer/modifier
  etudiant: Etudiant = new Etudiant(); // L'objet étudiant récupéré
  loading: boolean = false;

  nouveauNumTel: string = ''; // Nouveau numéro de téléphone saisi par l'utilisateur
  nouvelEmail: string = ''; // Nouvel email saisi par l'utilisateur
  nouvelleAdresse: string = ''; // Nouvelle adresse saisie par l'utilisateur

  constructor(private etudiantService: EtudiantService) { }

  // Méthode appelée lorsque le contenu du champ de saisie CIN change
  onCinChange(): void {
    // Utilisez la valeur de cin
    console.log('CIN saisi :', this.cin);
  }

  getEtudiantByCin(): void {
    if (!this.cin || this.cin === -1) {
      console.log('Veuillez saisir un CIN valide');
      return;
    }
    this.loading = true;
    this.etudiantService.getEtudiantByCin(this.cin)
      .subscribe(
        (data: Etudiant) => {
          console.log(data);
          this.etudiant = data;
          this.loading = false;
        },
        (error) => {
          console.log('Erreur lors de la récupération de l\'étudiant : ', error);
          this.loading = false;
        }
      );
  }

  updateEtudiant(): void {
    this.loading = true;
    this.etudiantService.updateEtudiantByCin(this.cin, this.etudiant)
      .subscribe(
        () => {
          console.log('Étudiant mis à jour avec succès !');
          this.loading = false;
        },
        (error) => {
          console.log('Erreur lors de la mise à jour de l\'étudiant : ', error);
          this.loading = false;
        }
      );
  }

  modifierNumTel(): void {
    this.loading = true;
    this.etudiant.numTel = this.nouveauNumTel; // Met à jour le numéro de téléphone de l'étudiant
    this.updateEtudiant();
  }

  modifierEmail(): void {
    this.loading = true;
    this.etudiant.email = this.nouvelEmail; // Met à jour l'email de l'étudiant
    this.updateEtudiant();
  }

  modifierAdresse(): void {
    this.loading = true;
    this.etudiant.adresse = this.nouvelleAdresse; // Met à jour l'adresse de l'étudiant
    this.updateEtudiant();
  }


}
