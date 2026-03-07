import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Sinistro } from '../models/sinistro.model';

@Injectable({
  providedIn: 'root'
})
export class SinistroService {
  private apiUrl = 'http://localhost:8080/sinistros'; // backend rodando

  constructor(private http: HttpClient) {}

  listar(): Observable<Sinistro[]> {
    return this.http.get<Sinistro[]>(this.apiUrl);
  }
}