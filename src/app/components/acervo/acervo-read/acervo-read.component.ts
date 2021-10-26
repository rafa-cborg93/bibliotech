import { Livro } from '../livro.model';
import { Component, OnInit } from '@angular/core';

import { ProductsService } from '../acervo.service';

@Component({
  selector: 'app-product-read',
  templateUrl: './acervo-read.component.html',
  styleUrls: ['./acervo-read.component.css']
})
export class ProductReadComponent implements OnInit {

  livros: Livro[]
  displayedColumns = ['id', 'titulo', 'autor', 'editora','assunto','ano','qtd', 'action']

  constructor(private productService: ProductsService) { }

  ngOnInit(): void {
    
    this.productService.readLivro().subscribe(livros => {
      this.livros = livros
      console.log(livros)
    })
  }

}
