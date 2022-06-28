import { Observable } from 'rxjs';
import { Risk } from './../models/risk';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class RiskService {
  private url = 'https://gestionriesgossofka.herokuapp.com/';
  constructor(private http: HttpClient) {}

  saveRisk(risk: Risk): Observable<any> {
    let direction = this.url + 'createRisk';
    return this.http.post<any>(direction, risk);
  }
}
