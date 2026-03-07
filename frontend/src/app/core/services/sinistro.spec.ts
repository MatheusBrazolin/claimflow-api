import { TestBed } from '@angular/core/testing';
import { provideHttpClient } from '@angular/common/http'; // Necessário para standalone
import { provideHttpClientTesting } from '@angular/common/http/testing';
import { SinistroService } from './sinistro.service';

describe('SinistroService', () => {
  let service: SinistroService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [
        SinistroService,
        provideHttpClient(),
        provideHttpClientTesting()
      ]
    });
    service = TestBed.inject(SinistroService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});