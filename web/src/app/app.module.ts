import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { SidebarComponent } from './sidebar/sidebar.component';
import { projectFormComponent } from './forms/project-form/project-form.component';
import { RiskFormComponent } from './forms/risk-form/risk-form.component';
import { RiskTableComponent } from './risk-table/risk-table.component';
import { environment } from '../environments/environment';
import { AngularFireModule} from '@angular/fire/compat';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';
import { RiskDetailComponent } from './risk-detail/risk-detail.component';
import { ProjectDetailComponent } from './project-detail/project-detail.component';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';

@NgModule({
  declarations: [
    AppComponent,
    SidebarComponent,
    projectFormComponent,
    RiskFormComponent,
    RiskTableComponent,
    RiskDetailComponent,
    ProjectDetailComponent,
  ],
  imports: [
    BrowserModule, 
    AppRoutingModule, 
    FontAwesomeModule, 
    AngularFireModule.initializeApp(environment.firebaseConfig),
    BrowserAnimationsModule,
    HttpClientModule,
    CommonModule,
    ToastrModule.forRoot()
  ],
  providers: [HttpClientModule],
  bootstrap: [AppComponent],
})
export class AppModule {}
