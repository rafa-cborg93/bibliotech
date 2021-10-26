import { AcervoEmprestimoComponent } from './../acervo/acervo-emprestimo/acervo-emprestimo.component';
import { ProductDeleteComponent } from '../acervo/acervo-delete/acervo-delete.component';
import { ProductUpdateComponent } from '../acervo/acervo-update/acervo-update.component';
import { ProductCreateComponent } from '../acervo/acervo-create/acervo-create.component';
import { ProductCrudComponent } from '../../views/acervo-crud/acervo-crud.component';
import { HomeComponent } from './../../views/home/home.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path:'',
    redirectTo:'home',
    pathMatch:'full'
  },
  {
    path:'home',
    component:HomeComponent
  },
  {
     path: "livros",
     component: ProductCrudComponent
     },
     {
      path: "livros/create",
       component: ProductCreateComponent
     },
    {
       path: "livros/update/:id",
       component: ProductUpdateComponent
     },
     {
       path: "livros/delete/:id",
       component: ProductDeleteComponent
     },
     {
       path: "livros/emprestimo/:id",
       component: AcervoEmprestimoComponent
     }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TemplateRoutingModule { }
