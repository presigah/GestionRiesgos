import { ProjectSave } from './../../models/projectSave';

import { ProjectService } from './../../service/project.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-project-form',
  templateUrl: './project-form.component.html',
  styleUrls: ['./project-form.component.css'],
})
export class ProjectFormComponent implements OnInit {
  project: ProjectSave = this.getEmptyProject();
  tags?: string;
  emails?: string;

  constructor(private service: ProjectService) {}

  ngOnInit(): void {}

  onSubmit() {
    this.project = this.getEmptyProject();
  }

  saveProject() {
    this.project.status = 'Creado';
    if (this.tags != undefined) {
      this.project.labels = this.tags.split(',');
    }
    if (this.emails != undefined) {
      this.project.emails = this.emails.split(',');
    }
    this.service.saveProject(this.project).subscribe(() => {
      setTimeout(() => {
        window.location.reload();
      }, 1000);
    });
  }

  getEmptyProject(): ProjectSave {
    return {
      name: '',
      labels: [],
      emails: [],
      description: '',
    };
  }
}
