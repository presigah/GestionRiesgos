import { Project } from './../../models/project';
import { ProjectService } from './../../service/project.service';
import { Component, OnInit, Input } from '@angular/core';
import { ProjectSave } from 'src/app/models/projectSave';

@Component({
  selector: 'app-edit-project',
  templateUrl: './edit-project.component.html',
  styleUrls: ['./edit-project.component.css'],
})
export class EditProjectComponent implements OnInit {
  @Input() project?: ProjectSave;
  @Input() show = false;
  projectEdit?: ProjectSave;
  tags?: string;
  emails?: string;

  constructor(private service: ProjectService) {}

  ngOnInit(): void {
    console.log(this.emails), this.tags;
  }

  ngOnChanges() {
    this.getvalues();
  }

  editProject() {
    if (this.tags != undefined && this.project != undefined) {
      this.project.labels = this.tags.split(',');
    }

    if (this.emails != undefined && this.project != undefined) {
      this.project.emails = this.emails.split(',');
    }
    console.log('email' + this.project?.emails);
    console.log('etiqueta' + this.project?.labels);
    this.project = this.getProyectEdit();
    if (this.project !== undefined) {
      this.service.updateProject(this.project).subscribe(() => {
        setTimeout(() => {
          window.location.reload();
        }, 1000);
      });
    }
  }

  getvalues() {
    this.tags = this.project?.labels.join(',');
    console.log('3' + this.tags);
    console.log('4' + this.project?.labels);

    this.emails = this.project?.emails.join(',');
    console.log('1' + this.emails);
    console.log('2' + this.project?.emails);
  }

  closeModal() {
    this.show = false;
    this.getvalues();
    // this.errorMessage = false;
  }

  getProyectEdit() {
    if (this.project != undefined) {
      return {
        id: this.project.id,
        name: this.project?.name,
        startDate: this.project.startDate,
        endingDate: this.project.endingDate,
        labels: this.project.labels,
        emails: this.project.emails,
        description: this.project.description,
        status: this.project.status,
      };
    }
    return undefined;
  }
}
