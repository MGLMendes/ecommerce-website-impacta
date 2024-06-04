import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(
    private router: Router
  ) {

  }

  loaded(): any {
    let token = localStorage.getItem("Authorization")
    if (token) {
      return true
    }
  }
  title = 'angular-ecommerce';

  logout() {
      this.router.navigateByUrl("/login")
  }
}
