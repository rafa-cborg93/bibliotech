import { Livro } from '../livro.model';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { ProductsService } from '../acervo.service';

@Component({
  selector: 'app-product-delete',
  templateUrl: './acervo-delete.component.html',
  styleUrls: ['./acervo-delete.component.css']
})
export class ProductDeleteComponent implements OnInit {
 
  livro: Livro;

  constructor(private productService: ProductsService,
    private router: Router,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id')
    this.productService.readByIdLivro(id).subscribe(livro => {
      this.livro = livro
    })
  }
  deleteProduct(): void {
    this.productService.deleteLivro(this.livro.id).subscribe(() => {
      this.productService.showMessage('Livro excluído com sucesso!')
      this.router.navigate(['/bibliotech/livros'])
    })
  }
  cancel(): void {
    this.router.navigate(['/bibliotech/livros'])
  }
}
