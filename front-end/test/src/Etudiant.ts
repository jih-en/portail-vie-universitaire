import { DemandeCertificatPresence} from "./DemandeCertificatPresence";
import { DemandeReleveNote } from "./DemandeReleveNote";
export class Etudiant {
  id: number=1;
  email: string="";
  cin: number=-1;
  password: string="";
  nom: string="";
  prenom: string="";
  specialite: string="";
  numTel: string="";
  adresse: string="";
  demandeReleveNote: DemandeReleveNote[]=[];
  demandeCertificatPresence: DemandeCertificatPresence[]=[];
  constructor(){}
}
  