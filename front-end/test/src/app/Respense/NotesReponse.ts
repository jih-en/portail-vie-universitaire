export class NotesReponse {
  id_Note: number;
  noteTp: number;
  noteDs: number;
  noteExamen: number;
  notePrj: number;
  remarque: string;
  matiere: string;
    constructor(
    id_Note: number,
    noteTp: number,
    noteDs: number,
    noteExamen: number,
    notePrj: number,
    remarque: string,
    matiere: string
  ) {
    this.id_Note = id_Note;
    this.noteTp = noteTp;
    this.noteDs = noteDs;
    this.noteExamen = noteExamen;
    this.notePrj = notePrj;
    this.remarque = remarque;
    this.matiere = matiere;
  }
}
