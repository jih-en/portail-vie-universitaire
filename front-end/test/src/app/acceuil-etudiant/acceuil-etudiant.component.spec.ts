import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AcceuilEtudiantComponent } from './acceuil-etudiant.component';

describe('AcceuilEtudiantComponent', () => {
  let component: AcceuilEtudiantComponent;
  let fixture: ComponentFixture<AcceuilEtudiantComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AcceuilEtudiantComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AcceuilEtudiantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
