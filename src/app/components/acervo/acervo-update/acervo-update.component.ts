import { AcervoService } from './../acervo.service';
import { Livro } from '../livro.model';

import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-product-update',
  templateUrl: './acervo-update.component.html',
  styleUrls: ['./acervo-update.component.css']
})
export class ProductUpdateComponent implements OnInit {

  livro: Livro;

  constructor(private acervoService: AcervoService, 
    private router: Router,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id')
    this.acervoService.readByIdLivro(id).subscribe(livros =>{
      this.livro = livros
    })
  }
  updateProduct(): void{
    this.acervoService.updateLivro(this.livro).subscribe(()=>{
      this.acervoService.showMessage("Livro Atualizado com sucesso!")
      this.router.navigate(['/bibliotech/livros'])
    })
  }

  cancel():void{
    this.router.navigate(['/bibliotech/livros'])
  }
}
