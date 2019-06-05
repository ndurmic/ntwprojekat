import { Component, OnInit, Input } from '@angular/core';
import { Kolekcija } from 'src/app/zmodels/kolekcija.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-kolekcija-item',
  templateUrl: './kolekcija-item.component.html',
  styleUrls: ['./kolekcija-item.component.css']
})
export class KolekcijaItemComponent implements OnInit {
  @Input() kolekcija: Kolekcija;
  constructor(private router: Router) { 
    
  }

  ngOnInit() {
  }
  
  onSelected(){
    this.router.navigate(['kolekcije/'+this.kolekcija.id]);
  }

}
