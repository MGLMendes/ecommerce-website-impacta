import { TestBed } from '@angular/core/testing';

import { ImpactaFormService } from './impacta-form.service';

describe('ImpactaFormService', () => {
  let service: ImpactaFormService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ImpactaFormService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
