import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CourseComponent} from "./course/course.component";
import {TemplateComponent} from "./template/template.component";
import {FeedbackComponent} from "./feedback/feedback.component";
import { LoginComponent } from './login/login.component';
import { EtudiantComponent } from './etudiant/etudiant.component';
import { InfoPersonnelComponent } from './info-personnel/info-personnel.component';
import { AcceuilEtudiantComponent } from './acceuil-etudiant/acceuil-etudiant.component';
import { DemandesComponent } from './demandes/demandes.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';
const routes: Routes = [
  {
    path:"",
    component:TemplateComponent
  },
  {
    path:'api/login',
    component:LoginComponent
  },
 
  {
    path:"cours",
    component:CourseComponent
  },
  {
    path:"feedback",
    component:FeedbackComponent
  },
  { 
    path: 'etudiants/:id',
    component:EtudiantComponent
  },
  { path: 'demandes', component: DemandesComponent }, 
  {path:'acceuil-etudiant',component:AcceuilEtudiantComponent},
  {path:'espace-etudiant',component:InfoPersonnelComponent}
 
];
  


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }




