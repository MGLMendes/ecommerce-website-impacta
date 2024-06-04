import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Credentials } from '../common/credentials';
import { RegisterUser } from '../common/register-user';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private loginUrl = "http://localhost:8080/api/login"
  private registerUrl = "http://localhost:8080/api/user/register"

  private validateTokenUrl = "http://localhost:8080/api/auth/check-token/"

  constructor(
    private httpClient: HttpClient
  ) { }



  login(credential: Credentials): Observable<any> {
    return this.httpClient.post<Credential>(this.loginUrl, credential, {
      observe: 'response',
    });
  }

  register(registerUser: RegisterUser): Observable<any> {
    return this.httpClient.post<RegisterUser>(this.registerUrl, registerUser, {
      observe: 'response',
    });
  }


  isTokenValid(authToken: string):Observable<any> {
    return this.httpClient.get<Boolean>(this.validateTokenUrl+authToken)
  }

  successfullLogin(authToken: string) {
    localStorage.setItem("Authorization", authToken)
  }

  getAuthToken(): string {
    return localStorage.getItem("Authorization")
  }

  getAuthHeader() {
    return {"headers": {
      "Authorization": "Bearer " + this.getAuthToken()
    }}
  }
}
