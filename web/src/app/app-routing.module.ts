import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RiskDetailComponent } from './risk-detail/risk-detail.component';

const routes: Routes = [{ path: 'risk', component: RiskDetailComponent }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
