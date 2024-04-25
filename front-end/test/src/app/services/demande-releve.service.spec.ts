import { TestBed } from '@angular/core/testing';

import { DemandeReleveService } from './demande-releve.service';

describe('DemandeReleveService', () => {
  let service: DemandeReleveService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DemandeReleveService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
