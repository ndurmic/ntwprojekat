import { Component, OnInit, Input } from '@angular/core';
import { Kolekcija } from 'src/app/zmodels/kolekcija.model';
import { Router } from '@angular/router';
import { Knjiga } from 'src/app/zmodels/knjiga.model';

@Component({
  selector: 'app-kolekcija-item',
  templateUrl: './kolekcija-item.component.html',
  styleUrls: ['./kolekcija-item.component.css']
})
export class KolekcijaItemComponent implements OnInit {
  @Input() kolekcija: Kolekcija;

  knjigePreview: Knjiga[];
  constructor(private router: Router) { 
    
  }

  ngOnInit() {
    this.knjigePreview=this.kolekcija.knjige.slice(0,2);
  }
  
  onSelected(){
    this.router.navigate(['kolekcije/'+this.kolekcija.id]);
  }

}
