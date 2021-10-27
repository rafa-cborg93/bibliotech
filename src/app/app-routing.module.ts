import { SignupComponent } from './components/signup/signup.component';
import { TemplateComponent } from './components/template/template.component';
import { LoginComponent } from './components/signin/signin.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: "",
    component: LoginComponent
  },
  {
    path: "login",
    component: LoginComponent
  },
  {
    path:'signup',
    component: SignupComponent
  },
  {
    path:'bibliotech',
    loadChildren: () => import('./components/template/template.module').then(m => m.TemplateModule),
    component: TemplateComponent
  }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
