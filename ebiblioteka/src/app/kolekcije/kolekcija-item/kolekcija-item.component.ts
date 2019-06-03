import { Component, OnInit, Input } from '@angular/core';
import { Kolekcija } from 'src/app/zmodels/kolekcija.model';

@Component({
  selector: 'app-kolekcija-item',
  templateUrl: './kolekcija-item.component.html',
  styleUrls: ['./kolekcija-item.component.css']
})
export class KolekcijaItemComponent implements OnInit {
  @Input() kolekcija: Kolekcija;
  constructor() { 
    
  }

  ngOnInit() {
  }

}
