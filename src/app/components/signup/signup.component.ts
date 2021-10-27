import { ThisReceiver } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from '../signin/usuario.model';
import { UsuarioService } from './usuario.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  usuario: Usuario = {
    nome: '',
    email: '',
    senha:'',
    perfil:'CLIENTE'
  }
  constructor(private usuarioService: UsuarioService, private route : Router) { }

  ngOnInit(): void {
  }
  cadastrarUsuario(): void{
    this.usuarioService.createUsuario(this.usuario).subscribe(() => {
      this.usuarioService.showMessage('Usuário Cadastrado!')
      this.route.navigate(['/login'])
    })
  }
  cancel(): void {
    this.route.navigate(['/login'])
  }

}
