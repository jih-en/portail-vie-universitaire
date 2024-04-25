import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router'; // Import ActivatedRoute
import { EtudiantService } from "../services/etudiant.service";
import { Etudiant } from '../Respense/Etudiant';
import { NotesReponse } from '../Respense/NotesReponse';

@Component({
  selector: 'app-etudiant',
  templateUrl: './etudiant.component.html',
  styleUrl: './etudiant.component.css'
})

export class EtudiantComponent implements OnInit { // Implement OnInit interface

  constructor(private etudiantsService: EtudiantService, private route: ActivatedRoute) { } // Inject ActivatedRoute

    
  etudiantForm: FormGroup = new FormGroup({});
  updateForm: FormGroup = new FormGroup({});
  filteredNotes: NotesReponse[] = [];
  idEtudian: number = 0;
  email: string | null = "";
  etudiant: Etudiant = new Etudiant();
  notes: NotesReponse[] = [];

  ngOnInit(): void {
    this.route.params.subscribe(params => { // Access route parameters using params observable
      const id = params['id']; // Get the 'id' parameter from the route
      this.etudiantsService.getEtudiantById(id).subscribe((res: any) => { // Fetch etudiant by ID
        this.etudiant = res;
        console.log(res);
        
      });

      this.etudiantsService.getNotesByEtudiantId(id).subscribe((r:any)=>{
        this.notes=r;
        console.log("aaaaaa32323"+r+"23233");

        this.filteredNotes = [...this.notes];


      });



    });
  }
    getNotesParEleveAndMatiere(): void {
     
    }
  
   
    imageUrl: string | undefined;

    onSelectFile(event: any) {
      const file = event.target.files[0];
      if (file) {
        const reader = new FileReader();
        reader.onload = () => {
          this.imageUrl = reader.result as string;
        };
        reader.readAsDataURL(file);
      }
    }
   
    delete(): void {
      this.imageUrl = '';
    
    }
  
    selectImage(): void {
      document.getElementById('fileInput')?.click();
    }

     doFilter(event: any){
      const searchTerm = event.target.value.toLowerCase();
  
      if (!searchTerm) {
        this.filteredNotes = [...this.notes];
        return;
      }
  
      this.filteredNotes = this.notes.filter(note =>
        note.matiere.toLowerCase().includes(searchTerm) 
      );
    }

}
