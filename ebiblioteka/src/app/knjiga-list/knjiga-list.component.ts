import { Component, OnInit } from '@angular/core';
import { Knjiga } from '../zmodels/knjiga.model';

@Component({
  selector: 'app-knjiga-list',
  templateUrl: './knjiga-list.component.html',
  styleUrls: ['./knjiga-list.component.css']
})
export class KnjigaListComponent implements OnInit {

  public knjige: Knjiga[] = [
    new Knjiga('Knjiga 1','Lorem ipsum dolor sit amet consectetur adipisicing elit. Velit quos eius id maxime quasi ratione, modi recusandae voluptas necessitatibus dolores labore voluptatem quia repellendus architecto, mollitia quae consequuntur expedita sint?','https://evrobook.rs/fajlovi/product/jezeva-kucica-jezeva-kucica_59c36d949222f.jpg'),
    new Knjiga('Knjiga 2','Lorem ipsum dolor sit amet consectetur adipisicing elit. Velit quos eius id maxime quasi ratione, modi recusandae voluptas necessitatibus dolores labore voluptatem quia repellendus architecto, mollitia quae consequuntur expedita sint?','https://evrobook.rs/fajlovi/product/jezeva-kucica-jezeva-kucica_59c36d949222f.jpg')
  ];

  constructor() { }

  ngOnInit() {
  }

}
