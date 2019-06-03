import { Component, OnInit } from '@angular/core';
import { Kolekcija } from 'src/app/zmodels/kolekcija.model';

@Component({
  selector: 'app-kolekcija-list',
  templateUrl: './kolekcija-list.component.html',
  styleUrls: ['./kolekcija-list.component.css']
})
export class KolekcijaListComponent implements OnInit {

  kolekcije: Kolekcija[] = [
    new Kolekcija('Kolekcija 1',true),
    new Kolekcija('Kolekcija 2',true),
  ];
  constructor() { }

  ngOnInit() {
  }

}
