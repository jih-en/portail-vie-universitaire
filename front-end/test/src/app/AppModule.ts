import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CourseComponent } from './course/course.component';
import { EditCourseComponent } from './course/edit-course/edit-course.component';
import { AddCourseComponent } from './course/add-course/add-course.component';
import { FormsModule } from '@angular/forms';
import { MaterialFileInputModule } from 'ngx-material-file-input';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatTableModule } from '@angular/material/table';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatDialogModule } from '@angular/material/dialog';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { provideHttpClient, withFetch } from '@angular/common/http';
import { provideClientHydration } from '@angular/platform-browser';
import { provideRouter } from '@angular/router';
import { EtudiantComponent } from './etudiant/etudiant.component';
import { LoginComponent } from './login/login.component';
import { InfoPersonnelComponent } from './info-personnel/info-personnel.component';
import { AcceuilEtudiantComponent } from './acceuil-etudiant/acceuil-etudiant.component';
import { DemandesComponent } from './demandes/demandes.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';

@NgModule({
  declarations: [
    AppComponent,
    CourseComponent,
    EditCourseComponent,
    AddCourseComponent,
    EtudiantComponent,
    LoginComponent,
    AcceuilEtudiantComponent,

    NavbarComponent,
    InfoPersonnelComponent,
    FooterComponent,
    DemandesComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    MaterialFileInputModule,
    MatButtonModule,
    MatInputModule,
    MatTableModule,
    MatFormFieldModule,
    MatDialogModule,
    HttpClientModule,
  ],
  providers: [
    provideHttpClient(withFetch()),
    provideAnimationsAsync(),
     provideClientHydration()
     
  ],
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule { }
