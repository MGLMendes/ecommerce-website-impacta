import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RegisterUser } from 'src/app/common/register-user';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerUser: RegisterUser = {
    name:  '',
    email:  '',
    password:  '',
    birthday:  '',
    membro: true
  }

  name = new FormControl(null, Validators.email)
  email = new FormControl(null, Validators.email)
  password = new FormControl(null, Validators.minLength(3))
  birthday = new FormControl(null, Validators.email)


  constructor(
    private service: LoginService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }


  register()  {
    this.service.register(this.registerUser).subscribe(
      data => {
        this.router.navigateByUrl("/login")
      }, (error) => {
        console.log()
        alert(error.error)
      }
    );
  }

  login()  {
    this.router.navigateByUrl("/login")
  }

}
