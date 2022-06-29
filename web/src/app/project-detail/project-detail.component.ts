import { Component, OnInit, PipeTransform, QueryList, ViewChildren } from '@angular/core';
import { SortableHeaderProjectDirective, SortProjectEvent } from '../directives/sortable-header-project.directive';
import { Project } from '../models/project';
import { Risk } from '../models/risk';
import { FireserviceService } from '../service/fireservice.service';
import { ProjectService } from '../service/project.service';
import { faEye, faFolderPlus, faArrowUpRightFromSquare, faTrashCan } from '@fortawesome/free-solid-svg-icons';
import { DatePipe } from '@angular/common';
import { map, Observable, startWith  } from 'rxjs';
import { FormControl } from '@angular/forms';


@Component({
  selector: 'app-project-detail',
  templateUrl: './project-detail.component.html',
  styleUrls: ['./project-detail.component.css'],
  providers: [DatePipe]
})
export class ProjectDetailComponent implements OnInit {
  
  @ViewChildren(SortableHeaderProjectDirective) headers!: QueryList<SortableHeaderProjectDirective>;


  faEye = faEye;
  faFolderPlus = faFolderPlus;
  faArrowUpRightFromSquare = faArrowUpRightFromSquare;
  faTrashCan = faTrashCan;

  userLogged = this.afAuth.getUserLogged();
  uid: any;
  disabled: boolean = false;

  projects: Project[] = [];
  user: any = '';

  projects$: Observable<Project[]>;

  page: number = 1;

  constructor(
    private afAuth: FireserviceService,
    public projectService: ProjectService,
    private pipe: DatePipe
  ) { 
    this.projects$ = projectService.projects$;
  }

  ngOnInit(): void {
    this.getProjects();
    this.traerdatos();
  }

  getProjects() {
    this.userLogged.subscribe(value => {
      this.uid = value?.uid;
    });
    this.projectService.getProjects().subscribe((data) => {
      this.projects = data;
    });
  }

  traerdatos() {
    this.userLogged.subscribe((value) => {     
      if (value?.email == undefined) {
        this.disabled = true;       
      } else {
        this.disabled = false;     
      }
    });
  }

  onSort({column, direction}: SortProjectEvent){
    this.headers.forEach(header => {
      if (header.sortable !== column) {
        header.direction = '';
      }
    });

    this.projectService.sortColumn = column;
    this.projectService.sortDirection = direction;
  }

}
