import { Component, OnInit, QueryList, ViewChildren } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { SortableHeaderProjectDirective, SortProjectEvent } from '../directives/sortable-header-project.directive';
import { Project } from '../models/project';
import { Risk } from '../models/risk';
import { FireserviceService } from '../service/fireservice.service';
import { ProjectService } from '../service/project.service';
import { faEye, faFolderPlus, faArrowUpRightFromSquare, faTrashCan } from '@fortawesome/free-solid-svg-icons';


@Component({
  selector: 'app-project-detail',
  templateUrl: './project-detail.component.html',
  styleUrls: ['./project-detail.component.css']
})
export class ProjectDetailComponent implements OnInit {
  @ViewChildren(SortableHeaderProjectDirective) headers: QueryList<SortableHeaderProjectDirective> | undefined;

  compare = (v1: string | Date | [string] | [Risk], v2: string | Date | [string] | [Risk]) => v1 < v2 ? -1 : v1 > v2 ? 1 : 0;

  faEye = faEye;
  faFolderPlus = faFolderPlus;
  faArrowUpRightFromSquare = faArrowUpRightFromSquare;
  faTrashCan = faTrashCan;

  userLogged = this.afAuth.getUserLogged();
  uid: any;
  disabled: boolean = false;

  projects: Project[] = [];
  user: any = '';

  page: number = 1;

  constructor(
    private afAuth: FireserviceService,
    private projectService: ProjectService
  ) { }

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

  onSort({column, direction}: SortProjectEvent) {
    // resetting other headers
    this.headers?.forEach(header => {
      if (header.sortable !== column) {
        header.direction = '';
      }
    });

    if(direction === '' || column === ''){
      this.getProjects();
    } else {
      this.projects.sort((a, b) => {
        const res = this.compare(a[column], b[column]);
        return direction === 'asc' ? res : -res;
      });
    }
  }

}
