import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Project } from '../models/project';
import { Risk } from '../models/risk';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  private url = 'https://gestionriesgossofka.herokuapp.com/';

  constructor(private http: HttpClient) { }

  
}
