import { Component, OnInit } from '@angular/core';
import { Kolekcija } from 'src/app/zmodels/kolekcija.model';
import { KolekcijeService } from 'src/app/services/kolekcije.service';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-kolekcija-list',
  templateUrl: './kolekcija-list.component.html',
  styleUrls: ['./kolekcija-list.component.css']
})
export class KolekcijaListComponent implements OnInit {

  kolekcije: Kolekcija[];
  showPlus=true;
  naziv: string;
  addKolekcijaFormGroup: FormGroup;
  constructor(private kolekcijeService: KolekcijeService) { }

  ngOnInit() {
    this.kolekcije=this.kolekcijeService.getKolekcije();

    this.addKolekcijaFormGroup = new FormGroup({
      'naziv': new FormControl()
   });
  }

  showAdd(){
    this.showPlus=false;
  }

  onSubmit(){
    this.showPlus=true;
    if(this.naziv!=null){
      this.kolekcijeService.addKolekcija(this.naziv);
    }
    
  }

}
