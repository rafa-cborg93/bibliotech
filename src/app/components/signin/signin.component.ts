import { Router } from '@angular/router';
import { LoginService } from './login.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class LoginComponent implements OnInit {

 loginForm: FormGroup;
  
  constructor(
    private formBuilder: FormBuilder, 
    private loginService: LoginService, 
    private router: Router) { }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      userName:['', Validators.required],
      password:['', Validators.required]
    });
    
  }
  login(){
    
    const userName = this.loginForm.get('userName').value;
    const password = this.loginForm.get('password').value;

    this.loginService.autenticar(userName,password)
        .subscribe(
          () => this.router.navigate(['/bibliotech/home']),
          err => {
            console.log(err);
            console.log(userName,password)
            this.loginForm.reset();
          }
        );
  }

}
