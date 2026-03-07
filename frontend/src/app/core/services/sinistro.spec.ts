import { TestBed } from '@angular/core/testing';

import { Sinistro } from './sinistro';

describe('Sinistro', () => {
  let service: Sinistro;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Sinistro);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
