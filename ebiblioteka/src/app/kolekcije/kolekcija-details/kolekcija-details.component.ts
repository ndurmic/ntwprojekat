import { Component, OnInit, Output } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { KolekcijeService } from 'src/app/services/kolekcije.service';
import { Kolekcija } from 'src/app/zmodels/kolekcija.model';
import { Knjiga } from 'src/app/zmodels/knjiga.model';

@Component({
  selector: 'app-kolekcija-details',
  templateUrl: './kolekcija-details.component.html',
  styleUrls: ['./kolekcija-details.component.css']
})
export class KolekcijaDetailsComponent implements OnInit {


  id: number;
  kolekcija: Kolekcija;
  

  constructor(private route: ActivatedRoute, private kolekcijeService: KolekcijeService, private router: Router) { }


  ngOnInit() {
    this.route.params.subscribe(
      (params: Params)=>{
        this.id=+params['id'];
        this.kolekcija=this.kolekcijeService.getKolekcijaById(this.id);
      }
    );
    
  }

  onRemove(data: any){
    this.kolekcija.knjige = this.kolekcija.knjige.filter(obj => obj.id !== data.id);
    if(this.kolekcija.knjige.length==0){
      this.kolekcijeService.kolekcije=this.kolekcijeService.kolekcije.filter(obj=> obj.id !== this.kolekcija.id);
      this.router.navigate(['kolekcije']);
    }

  }

}
