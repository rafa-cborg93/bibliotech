import { AcervoService } from './../acervo.service';
import { Livro } from '../livro.model';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-acervo-create',
  templateUrl: './acervo-create.component.html',
  styleUrls: ['./acervo-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  livro: Livro = {

    titulo:'',
    autor:'',
    editora:'',
    ano:null,
    assunto:'',
    qtd:null
  }
  

  constructor(private acervoService: AcervoService,
    private router: Router) { }

  ngOnInit(): void {
  }

  createProduct(): void {
    this.acervoService.createLivro(this.livro).subscribe(() => {
      this.acervoService.showMessage('Livro Criado!')
      this.router.navigate(['/bibliotech/livros'])
    })
  }
  cancel(): void {
    this.router.navigate(['/bibliotech/livros'])
  }

}
