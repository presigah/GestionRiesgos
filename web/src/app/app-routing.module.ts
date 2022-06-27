import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProjectDetailComponent } from './project-detail/project-detail.component';
import { ProjectIdComponent } from './project-id/project-id.component';

const routes: Routes = [
  { path: 'project/:id', component: ProjectIdComponent },
  { path: 'projects', component: ProjectDetailComponent },
  { path: '**', pathMatch: 'full' , redirectTo: 'projects' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
