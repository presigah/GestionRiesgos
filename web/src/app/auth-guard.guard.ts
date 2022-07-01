import { Injectable } from '@angular/core';
import { ActivatedRoute, CanActivate, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { FireserviceService } from './service/fireservice.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardGuard implements CanActivate {
  constructor(private afAuth: FireserviceService, private router: Router) { }

  canActivate(): boolean {
    if(!this.afAuth.userData){
      this.router.navigate(['welcome']);
      return false;
    }
    return true;
  }
  
}
