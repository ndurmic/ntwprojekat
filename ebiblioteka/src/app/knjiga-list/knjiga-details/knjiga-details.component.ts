import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Knjiga } from 'src/app/zmodels/knjiga.model';
import { KnjigeService } from 'src/app/services/knjige.service';
import { ServerService } from 'src/app/services/server.service';
import { KolekcijeService } from 'src/app/services/kolekcije.service';
import { FormGroup } from '@angular/forms';
import { FormControl } from '@angular/forms';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-knjiga-details',
  templateUrl: './knjiga-details.component.html',
  styleUrls: ['./knjiga-details.component.css']
})
export class KnjigaDetailsComponent implements OnInit {
  id: number;
  knjiga: Knjiga;
  selectedKolekcijeIds: number[];
  mojeKolekcije = [
];


noviKomentar: string;
ocjena: number;
addKomentarFormGroup: FormGroup;

  constructor(private route: ActivatedRoute, private knjigeService: KnjigeService,private serverService: ServerService, public kolekcijeService: KolekcijeService, private authService: AuthService) { 

  }

  ngOnInit() {
    this.addKomentarFormGroup = new FormGroup({
      'noviKomentar': new FormControl(),
      'ocjena': new FormControl()
   });

    this.route.params.subscribe(
      (params: Params)=>{
        this.id=+params['id'];

        this.serverService.getKnjigaById(this.id).subscribe(
          (response)=> {
              const data=response.json();
              this.knjiga=new Knjiga(data.id,data.naslov,data.opis,'https://evrobook.rs/fajlovi/product/jezeva-kucica-jezeva-kucica_59c36d949222f.jpg', 4, ['Drama', 'Komedija']);
            },
          (error)=>console.log(error)
      );

      }
    );
      this.mojeKolekcije=this.kolekcijeService.getKolekcijeByLoggedKorisnikId();
    
  }

  saveToCollections(){
    console.log(this.selectedKolekcijeIds);
    for(let x of this.selectedKolekcijeIds){
      this.kolekcijeService.addKnjigaToKolekcijaByKolekcijaId(x, this.knjiga);
    }
    this.selectedKolekcijeIds=[];
    
    
  }

  onAddKomentar(){
    console.log(this.noviKomentar);
    this.knjigeService.addKomentar(this.knjiga.id, this.noviKomentar);
    console.log(this.knjiga);
  }

  onAddOcjena(){
    this.knjigeService.addOcjena(this.knjiga.id, this.ocjena);
    
  }
  
  
}
