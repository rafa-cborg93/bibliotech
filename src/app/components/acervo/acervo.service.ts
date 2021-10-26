import { Livro } from './livro.model';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  
  api_url =" http://localhost:8080/acervos"

  httpOptions={
    headers: new HttpHeaders({
      'content-type':'application/json'
    })
  }

  constructor(private snackBar: MatSnackBar, private http: HttpClient) { }

  showMessage(msg: string, isError: boolean = false): void {
    this.snackBar.open(msg, 'X', {
      duration: 3000,
      horizontalPosition: "right",
      verticalPosition: "top",
      panelClass: isError ? ['msg-error'] : ['msg-success']
    })
  }
  
  //metodoslivros
  createLivro(livro: Livro): Observable<Livro> {
    return this.http.post<Livro>(this.api_url, livro)
  }
  
  readLivro(): Observable<Livro[]> {
    return this.http.get<Livro[]>(this.api_url)
  }
  readByIdLivro(id: string): Observable<Livro> {
    const url = `${this.api_url}/${id}`
    return this.http.get<Livro>(url)
  }
  updateLivro(livro: Livro): Observable<Livro> {
    const url = `${this.api_url}/${livro.id}`
    return this.http.put<Livro>(url, livro)
  }
  deleteLivro(id: number): Observable<Livro> {
    const url = `${this.api_url}/${id}`
    return this.http.delete<Livro>(url)
  }
}

