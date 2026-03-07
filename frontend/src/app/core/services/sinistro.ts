import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Sinistro } from '../models/sinistro';

@Injectable({
  providedIn: 'root'
})
export class SinistroService {

  private api = 'http://localhost:8080/sinistros'

  constructor(private http: HttpClient) {}

  listar() {
    return this.http.get<Sinistro[]>(this.api)
  }

  aprovar(id: number) {
    return this.http.put(`${this.api}/${id}/aprovar`, {})
  }

  rejeitar(id: number) {
    return this.http.put(`${this.api}/${id}/rejeitar`, {})
  }

  emAnalise(id: number) {
    return this.http.put(`${this.api}/${id}/em-analise`, {})
  }

}