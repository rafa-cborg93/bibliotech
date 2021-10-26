import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HeaderService } from 'src/app/components/template/header/header.service';

@Component({
  selector: 'app-acervo-crud',
  templateUrl: './acervo-crud.component.html',
  styleUrls: ['./acervo-crud.component.css']
})
export class ProductCrudComponent implements OnInit {

  constructor(private router: Router, private headerService: HeaderService) {
    headerService.headerdata = {
      title: 'Produtos',
      icon: 'storefront',
      routeUrl: '/products'
    }
  }

  ngOnInit(): void {
  }

  navigateToLivrosCreate(): void {
    this.router.navigate(['/bibliotech/livros/create'])
  }
}
