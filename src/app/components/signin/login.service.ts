import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

const API_URL = 'http://localhost:8080';



@Injectable({
  providedIn: 'root'
})
export class LoginService {

  authenticated = false;

  httpOptions={
    headers: new HttpHeaders({
      'content-type':'application/json',
      'Access-Control-Allow-Origin': '*',
      'Acess-Control-Allow_methods':'POST, PUT, GET, OPTIONS, DELETE',
      'Access-Control-Allow-Headers': 'Origin, X-Requested-With, Content-Type, Accept'
    })
  }

  constructor(private http: HttpClient) { }

  autenticar(username: string, password: string){
    return this.http.post(API_URL + '/login', {username, password})
  }

}
