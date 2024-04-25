import { Etudiant } from "./Etudiant";
export class DemandeCertificatPresence {
    id: number;
    raison: string;
    anneeAcademique: string;
    etudiant: Etudiant; 
    emailAdministration:string;
  
    constructor(id: number, raison: string, anneeAcademique: string, etudiant: Etudiant,email:string) {
        this.id = id;
        this.raison = raison;
        this.anneeAcademique = anneeAcademique;
        this.etudiant = etudiant;
        this.emailAdministration=email;
      }
    
  }