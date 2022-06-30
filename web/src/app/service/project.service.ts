import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable} from 'rxjs';
import { Project } from '../models/project';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  private url = 'https://gestionriesgossofka.herokuapp.com/';

  constructor(private http: HttpClient) {  }

  getProjects(): Observable<Project[]> {
    let direction = this.url + 'getAllProjects';
    return this.http.get<Project[]>(direction);
  }

  getProject(id: string): Observable<Project> {
    let direction = this.url + 'getProjectById/' + id
    return this.http.get<Project>(direction);
  }

  updateProject(project: Project): Observable<Project> {
    let direction = this.url + 'updateProject';
    return this.http.put<Project>(direction, project);
  }

  saveProject(project: Project): Observable<Project> {
    let direction = this.url + 'create';
    return this.http.post<Project>(direction, project, {
      responseType: 'text' as 'json',
    });
  }
}
