import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { SidebarComponent } from './sidebar/sidebar.component';
import { ProyectFormComponent } from './forms/proyect-form/proyect-form.component';
import { RiskFormComponent } from './forms/risk-form/risk-form.component';
import { RiskTableComponent } from './risk-table/risk-table.component';
import { environment } from '../environments/environment';
import { AngularFireModule} from '@angular/fire/compat';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';
import { RiskDetailComponent } from './risk-detail/risk-detail.component';
import { ProjectDetailComponent } from './project-detail/project-detail.component';
import { HttpClientModule } from '@angular/common/http';
import { ProjectIdComponent } from './project-id/project-id.component';
import { HeatMapChartComponent } from './heat-map-chart/heat-map-chart.component';
import { NgxChartsModule } from '@swimlane/ngx-charts';

@NgModule({
  declarations: [
    AppComponent,
    SidebarComponent,
    ProyectFormComponent,
    RiskFormComponent,
    RiskTableComponent,
    RiskDetailComponent,
    ProjectDetailComponent,
    ProjectIdComponent,
    HeatMapChartComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FontAwesomeModule,
    AngularFireModule.initializeApp(environment.firebaseConfig),
    BrowserAnimationsModule,
    HttpClientModule,
    ToastrModule.forRoot(),
    NgxChartsModule
  ],
  providers: [HttpClientModule],
  bootstrap: [AppComponent],
})
export class AppModule {}
