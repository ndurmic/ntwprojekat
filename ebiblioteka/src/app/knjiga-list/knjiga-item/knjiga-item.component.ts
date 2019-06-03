import { Component, OnInit, Input } from '@angular/core';
import { Knjiga } from 'src/app/zmodels/knjiga.model';

@Component({
  selector: 'app-knjiga-item',
  templateUrl: './knjiga-item.component.html',
  styleUrls: ['./knjiga-item.component.css']
})
export class KnjigaItemComponent implements OnInit {
  
  @Input() knjiga: Knjiga;

  constructor() { }

  ngOnInit() {
  }

}
