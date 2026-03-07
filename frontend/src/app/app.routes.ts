import { Routes } from '@angular/router';
import { SinistrosComponent } from './core/pages/sinistros/sinistros.component';

export const routes: Routes = [
  { path: '', redirectTo: 'sinistros', pathMatch: 'full' },
  { path: 'sinistros', component: SinistrosComponent },
];