import { Knjiga } from '../zmodels/knjiga.model';
import { ServerService } from './server.service';
import { Injectable } from '@angular/core';
import { AuthService } from './auth.service';
import { Komentar } from '../zmodels/komentar.model';
@Injectable()
export class KnjigeService {
    private knjige: Knjiga[]; 
    ucitao:boolean=false;

      constructor(private serverService: ServerService, private authService: AuthService){
          this.fetchAllKnjige();
          console.log("Konstruktor brzi");
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
                  const data=response.json();
                  this.knjige=[];
                  for(let x of data){
                    this.knjige.push(new Knjiga(x.id,x.naslov,x.opis,'https://evrobook.rs/fajlovi/product/jezeva-kucica-jezeva-kucica_59c36d949222f.jpg', 4, ['Drama', 'Komedija'])); 
                  }
                  console.log(this.knjige);
                  this.ucitao=true;
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