import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Project } from '../models/project';
import { Risk } from '../models/risk';
import { FireserviceService } from '../service/fireservice.service';
import { ProjectService } from '../service/project.service';

@Component({
  selector: 'app-project-id',
  templateUrl: './project-id.component.html',
  styleUrls: ['./project-id.component.css'],
})
export class ProjectIdComponent implements OnInit {
  project: Project | undefined;
  risks: Risk[] = [];
  id: string | undefined;

  projects: Project[] | undefined;

  constructor(
    private route: ActivatedRoute,
    private projectService: ProjectService,
    private asfAuth: FireserviceService
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.getProject(`${id}`);
  }

  getProject(id: string) {
    this.projectService.getProject(id).subscribe((data) => {
      console.log({ data });
      this.project = data;
      this.risks = data.risks;
      console.log({ risks3: this.risks });
    });
  }
}
