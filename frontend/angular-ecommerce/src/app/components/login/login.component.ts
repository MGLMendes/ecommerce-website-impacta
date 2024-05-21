import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Credentials } from 'src/app/common/credentials';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  creds: Credentials = {
    email:  '',
    password: ''
  }

  email = new FormControl(null, Validators.email)
  password = new FormControl(null, Validators.minLength(3))

  constructor(
    private service: LoginService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.isTokenValid();
  }

  validaCampos() {
    return this.email.valid && this.password.valid
  }



  login()  {
    this.service.login(this.creds).subscribe(
      data => {
        this.service.successfullLogin(data.headers.get('Authorization').substring(7))
        this.router.navigateByUrl("/products")
      }, () => {
        alert("Email ou senha inválidos")
      }
    );
  }

  isTokenValid() {
    this.service.isTokenValid(this.service.getAuthToken()).subscribe(
      response => {
        if (response) {
          this.router.navigateByUrl("/products")
        }
      }
    )
  }

}
