import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SinistroService } from '../../services/sinistro.service';
import { Sinistro } from '../../models/sinistro.model';

@Component({
  selector: 'app-sinistros',
  template: `
    <div>
      <h2>Lista de Sinistros</h2>
      <ul>
        <li *ngFor="let sinistro of sinistros">
          {{ sinistro.descricao || sinistro.id }} <!-- Ajuste conforme as propriedades do modelo Sinistro -->
        </li>
      </ul>
    </div>
  `,
  standalone: true,
  imports: [CommonModule]
})
export class SinistrosComponent implements OnInit {
  sinistros: Sinistro[] = [];

  constructor(private service: SinistroService) {}

  ngOnInit() {
    this.service.listar().subscribe((data: Sinistro[]) => {
      this.sinistros = data;
    });
  }
}