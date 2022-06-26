import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { EmptyProject } from '../models/empty-project';
import { Project } from '../models/project';
import { Risk } from '../models/risk';
import { FireserviceService } from '../service/fireservice.service';


@Component({
  selector: 'app-project-detail',
  templateUrl: './project-detail.component.html',
  styleUrls: ['./project-detail.component.css']
})
export class ProjectDetailComponent implements OnInit {
  userLogged = this.afAuth.getUserLogged();
  uid: any;

  projects: Project[] = [];
  user: any = '';

  constructor(
    private afAuth: FireserviceService
  ) { }

  ngOnInit(): void {
  }



}
