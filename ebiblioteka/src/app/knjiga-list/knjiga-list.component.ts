import { Component, OnInit } from '@angular/core';
import { Knjiga } from '../zmodels/knjiga.model';
import { KnjigeService } from '../services/knjige.service';
import { ServerService } from '../services/server.service';

@Component({
  selector: 'app-knjiga-list',
  templateUrl: './knjiga-list.component.html',
  styleUrls: ['./knjiga-list.component.css']
})
export class KnjigaListComponent implements OnInit {

  public knjige: Knjiga[];

  constructor(private knjigeService: KnjigeService, private serverService: ServerService) { }

  ngOnInit() {
    this.serverService.getKnjige().subscribe(
      (response)=> {
          console.log(response);
          console.log(response.json());
          const data=response.json();
          this.knjige=[];
          for(let x of data){
            this.knjige.push(new Knjiga(x.id,x.naslov,x.opis,'https://evrobook.rs/fajlovi/product/jezeva-kucica-jezeva-kucica_59c36d949222f.jpg', 4, ['Drama', 'Komedija'])); 
          }
          console.log(this.knjige);
        },
      (error)=>console.log(error)
  );
  }

  

}
