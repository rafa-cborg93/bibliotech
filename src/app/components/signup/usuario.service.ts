import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Observable } from 'rxjs';
import { Usuario } from '../signin/usuario.model';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  api_url = "http://localhost:8080/usuarios"

  httpOptions={
    headers: new HttpHeaders({
      'content-type':'application/json'
    })
  }
  constructor(private http: HttpClient, private snackBar: MatSnackBar) { }

  showMessage(msg: string, isError: boolean = false): void {
    this.snackBar.open(msg, 'X', {
      duration: 3000,
      horizontalPosition: "right",
      verticalPosition: "top",
      panelClass: isError ? ['msg-error'] : ['msg-success']
    })
  }

  createUsuario(usuario: Usuario): Observable<Usuario>{
    return this.http.post<Usuario>(this.api_url, usuario)
  }
  
}
