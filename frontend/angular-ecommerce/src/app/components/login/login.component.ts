import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Credentials } from 'src/app/common/credentials';

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

  constructor() { }

  ngOnInit(): void {
  }

  validaCampos() {
    return this.email.valid && this.password.valid
  }


  login() {
    console.log(this.creds.email)
    console.log(this.creds.password)
  }

}
