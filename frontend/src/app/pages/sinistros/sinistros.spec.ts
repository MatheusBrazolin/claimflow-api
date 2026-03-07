import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Sinistros } from './sinistros';

describe('Sinistros', () => {
  let component: Sinistros;
  let fixture: ComponentFixture<Sinistros>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Sinistros],
    }).compileComponents();

    fixture = TestBed.createComponent(Sinistros);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
