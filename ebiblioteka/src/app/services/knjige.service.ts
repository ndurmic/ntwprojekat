import { Knjiga } from '../zmodels/knjiga.model';
import { ServerService } from './server.service';
import { Injectable } from '@angular/core';
import { AuthService } from './auth.service';
import { Komentar } from '../zmodels/komentar.model';
@Injectable()
export class KnjigeService {
    private knjige: Knjiga[] = [
        new Knjiga(1,'Knjiga 1','Lorem ipsum dolor sit amet consectetur adipisicing elit. Velit quos eius id maxime quasi ratione, modi recusandae voluptas necessitatibus dolores labore voluptatem quia repellendus architecto, mollitia quae consequuntur expedita sint?','https://evrobook.rs/fajlovi/product/jezeva-kucica-jezeva-kucica_59c36d949222f.jpg', 4, ['Drama', 'Komedija']),
        new Knjiga(2,'Knjiga 2','Lorem ipsum dolor sit amet consectetur adipisicing elit. Velit quos eius id maxime quasi ratione, modi recusandae voluptas necessitatibus dolores labore voluptatem quia repellendus architecto, mollitia quae consequuntur expedita sint?','https://evrobook.rs/fajlovi/product/jezeva-kucica-jezeva-kucica_59c36d949222f.jpg', 4.5, ['Triler'])
      ];


      constructor(private serverService: ServerService, private authService: AuthService){

      }
      
      getKnjige(){
          return this.knjige;
      }
      getKnjigaById(id:number){
          return this.knjige.find(x=> x.id===id);
      }
      fetchAllKnjige(){
          this.serverService.getKnjige().subscribe(
              (response)=> {
                  console.log(response);
                  console.log(response.json());
                },
              (error)=>console.log(error)
          );
      }

      addKomentar(idKnjige: number, komentar: string){
          this.knjige.find(x=> x.id==idKnjige).addKomentar(this.authService.getLoggedUserId(), komentar);
          this.serverService.addKomentar(idKnjige, new Komentar(1,this.authService.getLoggedUserId(), komentar)).subscribe(
            (response) => {
              const data= response.json();
              console.log(data);
            },
            (error)=>console.log(error)
          );
      }

      addOcjena(idKnjige: number, ocjena: number){
        this.knjige.find(x=> x.id==idKnjige).addOcjena(ocjena);
        this.serverService.updateKnjiga(this.knjige.find(x=> x.id===idKnjige)).subscribe(
            (response) => {
              const data= response.json();
              console.log(data);
              ;
            },
            (error)=>console.log(error)
          );
      }
}