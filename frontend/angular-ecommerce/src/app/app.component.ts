import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  loaded(): any {
    let token = localStorage.getItem("Authorization")
    if (token) {
      return true
    }
  }
  title = 'angular-ecommerce';
}
