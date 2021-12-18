import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute } from '@angular/router';

import { first } from 'rxjs/operators';

import { AuthenticationService } from 'src/app/services/authentication';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  email: string = '';
  password: string = '';
  error: string = '';
  returnUrl: string;
  constructor(public router: Router, public authenticationService: AuthenticationService, private route: ActivatedRoute,
  ) {


  }

  login() {


    this.authenticationService.login(this.email, this.password)
      .pipe(first())
      .subscribe(
        data => {

          this.router.navigateByUrl('/home')
        },
        error => {
          this.error = 'Nombre de usuario o Contraseña incorrectas';

        });

  }

  ngOnInit() {

    // elimino las credenciales del usuario, si es que existen
    
    this.authenticationService.logout();

    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
  }

}
