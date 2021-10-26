import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { HeaderData } from './header-data.model';

@Injectable({
  providedIn: 'root'
})
export class HeaderService {
  
  public toggleNav: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);

  public toggle(): void {
    this.toggleNav.next(!this.toggleNav.value);
  }

  private _headerData = new BehaviorSubject<HeaderData>({
    title: 'Inicio',
    icon: 'home',
    routeUrl: ''
  })

  constructor() { }

  get headerData(): HeaderData {
    return this._headerData.value
  }

  set headerdata(headerData: HeaderData) {
    this._headerData.next(headerData)
  }
}
