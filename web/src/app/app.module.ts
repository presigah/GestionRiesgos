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
import { LoginComponent } from './user/login/login/login.component'

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';

@NgModule({
  declarations: [
    AppComponent,
    SidebarComponent,
    ProyectFormComponent,
    RiskFormComponent,
    RiskTableComponent,
    LoginComponent,
  ],
  imports: [
    BrowserModule, 
    AppRoutingModule, 
    FontAwesomeModule, 
    AngularFireModule.initializeApp(environment.firebaseConfig),
    BrowserAnimationsModule,
    ToastrModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
