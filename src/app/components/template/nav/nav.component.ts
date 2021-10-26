import { HeaderService } from 'src/app/components/template/header/header.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  constructor(public headerService: HeaderService) { }

  ngOnInit(): void {
  }

}
