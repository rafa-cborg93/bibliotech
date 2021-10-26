import { Observable } from 'rxjs';
import { Emprestimo } from './emprestimo.model';
import { MatSnackBar } from '@angular/material/snack-bar';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EmprestimoService {

  api_url =" http://localhost:8080/emprestimos"

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

  //metodos do emprestimo
  createEmprestimo(emprestimo: Emprestimo): Observable<Emprestimo> {
    return this.http.post<Emprestimo>(this.api_url, emprestimo)
  }
  readEmprestimo(): Observable<Emprestimo[]> {
    return this.http.get<Emprestimo[]>(this.api_url)
  }
  readByIdEmprestimo(id: string): Observable<Emprestimo> {
    const url = `${this.api_url}/${id}`
    return this.http.get<Emprestimo>(url)
  }
  updateEmprestimo(emprestimo: Emprestimo):Observable<Emprestimo> {
    const url = `${this.api_url}/${emprestimo.id}`
    return this.http.put<Emprestimo>(url, emprestimo)
  }
  deleteEmprestimo(id: number): Observable<Emprestimo> {
    const url = `${this.api_url}/${id}`
    return this.http.delete<Emprestimo>(url)
  }
}
