import { ProductsService } from './../acervo.service';
import { Livro } from './../livro.model';
import { Router, ActivatedRoute } from '@angular/router';
import { EmprestimoService } from './../emprestimo.service';
import { Emprestimo } from './../emprestimo.model';
import { Component, OnInit } from '@angular/core';
import { ShowOnDirtyErrorStateMatcher } from '@angular/material/core';

@Component({
  selector: 'app-acervo-emprestimo',
  templateUrl: './acervo-emprestimo.component.html',
  styleUrls: ['./acervo-emprestimo.component.css']
})
export class AcervoEmprestimoComponent implements OnInit {

  emprestimos: Emprestimo;
  livros: Livro;

  constructor(private emprestimoService: EmprestimoService, private acervoService: ProductsService, private router: Router,
    private route: ActivatedRoute) { }

  ngOnInit(): void {

    const idAcervo = this.route.snapshot.paramMap.get('id')
    this.acervoService.readByIdLivro(idAcervo).subscribe(livros =>{
      this.livros = livros
    })

    const idEmprestimo = this.route.snapshot.paramMap.get('id')
    this.emprestimoService.readByIdEmprestimo(idEmprestimo).subscribe(emprestimos =>{
      this.emprestimos = emprestimos
    })
  }
  fazerEmprestimo():void{
    this.emprestimoService.showMessage("Emprestimo Realizado com Sucesso!")
  }
  cancel():void{
    this.router.navigate(['/bibliotech/livros'])
  }

}
