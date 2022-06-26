import { Component, OnInit } from '@angular/core';
import { 
  faUserGear, 
  faUser, 
  faQuestion, 
  faFolderPlus, 
  faHeartCirclePlus, 
  faArrowRightToBracket,
  faArrowRightFromBracket, 
  faBolt
} from '@fortawesome/free-solid-svg-icons';

import { Router } from '@angular/router';
import { FireserviceService } from 'src/app/service/fireservice.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  userLogged = this.afAuth.getUserLogged();
  disabled: boolean = false;

  faUserGear = faUserGear;
  faUser = faUser;
  faQuestion = faQuestion;
  faFolderPlus = faFolderPlus;
  faHeartCirclePlus = faHeartCirclePlus;
  faArrowRightToBracket = faArrowRightToBracket;
  faArrowRightFromBracket = faArrowRightFromBracket;
  faBolt = faBolt;


  constructor(public afAuth: FireserviceService, private route: Router, private toastr: ToastrService) { }

  ngOnInit(): void {
    this.traerDatos();
  }

  traerDatos() {
    this.userLogged.subscribe((value) => {    
      if (value?.email == undefined) {
        this.disabled = true;        
      } else {
        this.disabled = false;       
      }
    });
  }

  loginGoogle(){
    this.afAuth
      .loginGoogle()
      .then((res) => {
        if(res) {
          this.toastr.success('Login correcto');
        }else {
          this.toastr.error('Rectifique sus datos');
        }
      })
  }

  logout() {
    this.afAuth.logout();
    window.location.reload();
    this.route.navigate(['/']);
  }

}
