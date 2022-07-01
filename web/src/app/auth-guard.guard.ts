import { Injectable } from '@angular/core';
import { ActivatedRoute, CanActivate, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { FireserviceService } from './service/fireservice.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardGuard implements CanActivate {
  userLogged = this.afAuth.getUserLogged();
  logged: boolean = false;

  constructor(private afAuth: FireserviceService, private router: Router) { }

  canActivate(): boolean {
    this.checkUser();
    return this.logged;
  }

  checkUser(){
    this.userLogged.subscribe((value) => {
      if (value === null) {
        console.log(value+ ' desde auth guard');
        this.router.navigate(['welcome']);
        this.logged = false;       
      }else{
        console.log(value)
        this.logged=true;
      }
    })
  }
  
}
