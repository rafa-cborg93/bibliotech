import { AcervoService } from './../acervo.service';
import { Livro } from '../livro.model';
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-product-read',
  templateUrl: './acervo-read.component.html',
  styleUrls: ['./acervo-read.component.css']
})
export class ProductReadComponent implements OnInit {

  livros: Livro[]
  displayedColumns = ['id', 'titulo', 'autor', 'editora','assunto','ano','qtd', 'action']

  constructor(private acervoService: AcervoService) { }

  ngOnInit(): void {
    
    this.acervoService.readLivro().subscribe(livros => {
      this.livros = livros
      console.log(livros)
    })
  }

}
