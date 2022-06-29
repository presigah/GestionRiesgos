import { Injectable, PipeTransform } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BehaviorSubject, delay, Observable, Subject, tap, debounceTime, switchMap, of } from 'rxjs';
import { Project } from '../models/project';
import { SortColumn, SortDirection } from '../directives/sortable-header-project.directive';
import { Risk } from '../models/risk';

interface State {
  searchTerm: string;
  sortColumn: SortColumn;
  sortDirection: SortDirection;
}

interface SearchResult {
  projects: Project[];
}

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  compareProject = (v1: string | Date | [string] | [Risk], v2: string | Date | [string] | [Risk]) => v1 < v2 ? -1 : v1 > v2 ? 1 : 0;

  private _loading$ = new BehaviorSubject<boolean>(true);
  private _search$ = new Subject<void>();
  private _projects$ = new BehaviorSubject<Project[]>([]);
  private _total$ = new BehaviorSubject<number>(0);
  private PROJECTS: Project[] = [];

  private _state: State = {
    searchTerm: '',
    sortColumn: '',
    sortDirection: ''
  }

  private url = 'https://gestionriesgossofka.herokuapp.com/';

  constructor(private http: HttpClient) {
    this.getProjects().subscribe((data) => {
      this.PROJECTS = data;
    });
    this._search$.pipe(
      tap(() => this._loading$.next(true)),
      debounceTime(200),
      switchMap(() => this._search()),
      delay(200),
      tap(() => this._loading$.next(false))
    ).subscribe(result => {
      this._projects$.next(result.projects);
    });
   }

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

  get projects$() {
    return this._projects$.asObservable();
  }

  get loading$() {
    return this._loading$.asObservable();
  }

  get searchTerm() {
    return this._state.searchTerm;
  }

  set sortColumn(sortColumn: SortColumn){
    this._set({sortColumn});
  }

  set searchTerm(searchTerm: string) {
    this._set({searchTerm});
  }

  set sortDirection(sortDirection: SortDirection) { 
    this._set({sortDirection}); 
  }

  private _set(patch: Partial<State>) {
    Object.assign(this._state, patch);
    this._search$.next();
  }

  onSortProject(projects:Project[], column: SortColumn, direction: string): Project[] {
    if(direction === '' || column === ''){
      return projects;
    } else {
      return [...projects].sort((a, b) => {
        const res = this.compareProject(a[column], b[column]);
        return direction === 'asc' ? res : -res;
      });
    }
  }

  projectMatches(project:Project, term: string){
    //console.log(pipe.transform(project.startDate, 'yyyy,M,dd'))
    return project.name.toLowerCase().includes(term);
  }

  private _search(): Observable<SearchResult> {
    const {sortColumn, sortDirection, searchTerm} = this._state;

    let projects = this.onSortProject(this.PROJECTS, sortColumn, sortDirection);

    projects = projects.filter(project => this.projectMatches(project, searchTerm));

    return of({projects});
  }
}
