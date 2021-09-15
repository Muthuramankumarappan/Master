import { Component, OnInit, Input } from '@angular/core';

import { ButtonTemplate } from '../shared/model'

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  @Input() title: string = '';

  @Input('buttonFunction') functions : ButtonTemplate[] = [];

  @Input('showButton') showButton : Boolean = true;
  
  constructor() { }

  ngOnInit(): void {
  }
  

}
