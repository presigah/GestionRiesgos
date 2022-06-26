import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { SidebarComponent } from './sidebar/sidebar.component';
import { ProyectFormComponent } from './forms/proyect-form/proyect-form.component';
import { RiskFormComponent } from './forms/risk-form/risk-form.component';
import { RiskTableComponent } from './risk-table/risk-table.component';
import { RiskDetailComponent } from './risk-detail/risk-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    SidebarComponent,
    ProyectFormComponent,
    RiskFormComponent,
    RiskTableComponent,
    RiskDetailComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, FontAwesomeModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
