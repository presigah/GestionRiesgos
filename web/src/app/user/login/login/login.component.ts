import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FireserviceService } from 'src/app/service/fireservice.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(
    private afAuth: FireserviceService,
    private route: Router,
    private toastr: ToastrService
  ) { }

  ngOnInit(): void {
  }

  loginGoogle(){
    this.afAuth
      .loginGoogle()
      .then((res) => {
        if(res) {
          this.toastr.success('Login correcto');
          setTimeout(() => {
            this.route.navigate(['/']);
            }, 3000);
        }else {
          this.toastr.error('Rectifique sus datos');
        }
      })
  }
}
