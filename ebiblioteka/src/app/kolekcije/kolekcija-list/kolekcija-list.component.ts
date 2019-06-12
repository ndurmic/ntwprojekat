import { Component, OnInit } from '@angular/core';
import { Kolekcija } from 'src/app/zmodels/kolekcija.model';
import { KolekcijeService } from 'src/app/services/kolekcije.service';
import { FormGroup, FormControl } from '@angular/forms';
import { AuthService } from 'src/app/services/auth.service';
import { Router } from '@angular/router';

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
  constructor(private kolekcijeService: KolekcijeService, private authService: AuthService, private router: Router) { }

  ngOnInit() {
    if(this.router.url==='/kolekcije/personalne'){
      this.kolekcije=this.kolekcijeService.getKolekcijeByLoggedKorisnikId();
    }
    else {
      this.kolekcije=this.kolekcijeService.getJavneKolekcije();
    }
    

    this.addKolekcijaFormGroup = new FormGroup({
      'naziv': new FormControl()
   });
   console.log(this.router.url);
  }

  showAdd(){
    this.showPlus=false;
  }

  onSubmit(){
    this.showPlus=true;
    if(this.naziv!=null){
      this.kolekcijeService.addKolekcija(this.naziv, this.authService.getLoggedUserId());
    }
    if(this.router.url==='/kolekcije/personalne'){
      this.kolekcije=this.kolekcijeService.getKolekcijeByLoggedKorisnikId();
    }
    else {
      this.kolekcije=this.kolekcijeService.getJavneKolekcije();
    }
  }

}
