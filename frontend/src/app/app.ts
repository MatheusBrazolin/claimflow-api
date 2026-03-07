import { Component } from '@angular/core';
import { SinistrosComponent } from './pages/sinistros/sinistros';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [SinistrosComponent],
  templateUrl: './app.html',
  styleUrls: ['./app.css']
})
export class AppComponent {
}