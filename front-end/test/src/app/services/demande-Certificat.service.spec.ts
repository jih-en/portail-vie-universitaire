import { TestBed } from '@angular/core/testing';


import { DemandeCertificatService } from './demande-Certificat.service';

describe('DemandecertificatService', () => {
  let service: DemandeCertificatService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DemandeCertificatService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
