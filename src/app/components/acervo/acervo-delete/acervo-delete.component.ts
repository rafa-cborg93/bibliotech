import { AcervoService } from './../acervo.service';
import { Livro } from '../livro.model';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-product-delete',
  templateUrl: './acervo-delete.component.html',
  styleUrls: ['./acervo-delete.component.css']
})
export class ProductDeleteComponent implements OnInit {
 
  livro: Livro;

  constructor(private acervoService: AcervoService,
    private router: Router,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id')
    this.acervoService.readByIdLivro(id).subscribe(livro => {
      this.livro = livro
    })
  }
  deleteProduct(): void {
    this.acervoService.deleteLivro(this.livro.id).subscribe(() => {
      this.acervoService.showMessage('Livro excluído com sucesso!')
      this.router.navigate(['/bibliotech/livros'])
    })
  }
  cancel(): void {
    this.router.navigate(['/bibliotech/livros'])
  }
}
