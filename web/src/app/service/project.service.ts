import { ProjectSave } from './../models/projectSave';
import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Project } from '../models/project';

@Injectable({
  providedIn: 'root',
})
export class ProjectService {
  private url = 'https://gestionriesgossofka.herokuapp.com/';

  constructor(private http: HttpClient) {}

  getProjects(): Observable<Project[]> {
    let direction = this.url + 'getAllProjects';
    return this.http.get<Project[]>(direction);
  }

  getProject(id: string): Observable<Project> {
    let direction = this.url + 'getProjectById/' + id;
    return this.http.get<Project>(direction);
  }

  updateProject(project: Project): Observable<Project> {
    let direction = this.url + 'updateProject';
    return this.http.put<Project>(direction, project);
  }

  saveProject(project: ProjectSave): Observable<ProjectSave> {
    let direction = this.url + 'createProject';
    return this.http.post<ProjectSave>(direction, project, {
      responseType: 'text' as 'json',
    });
  }
}
