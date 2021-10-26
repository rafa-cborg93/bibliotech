import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

const API_URL = 'http://localhost:8080';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  autenticar(username: string, password: string){
    return this.http.post(API_URL + '/login', {username, password})
  }
}
