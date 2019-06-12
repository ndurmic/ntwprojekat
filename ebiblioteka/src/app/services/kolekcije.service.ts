import { Kolekcija } from '../zmodels/kolekcija.model';
import { Injectable } from '@angular/core';
import { AuthService } from './auth.service';
import { Knjiga } from '../zmodels/knjiga.model';
import { ServerService } from './server.service';

@Injectable()
export class KolekcijeService {
    
    public kolekcije: Kolekcija[] = [
        new Kolekcija(1,1,'Kolekcija 1',true),
        new Kolekcija(2,1,'Kolekcija 2',true),
        new Kolekcija(3,1,'Kolekcija 3',true),
        new Kolekcija(4,2,'Kolekcija 4',true),
        new Kolekcija(5,2,'Kolekcija 5',false),
        new Kolekcija(6,2,'Kolekcija 6',true)
      ];

      constructor(private authService: AuthService, private serverService: ServerService){
          this.fetchAllKolekcije();
      }

      getKolekcije(){
          return this.kolekcije;
      }
      getKolekcijeByLoggedKorisnikId(){
        return this.kolekcije.filter(x=> x.korisnikId===this.authService.getLoggedUserId());
      }
      getJavneKolekcije(){
        return this.kolekcije.filter(x=> x.javna===true);
      }
      getKolekcijaById(id: number){
        return this.kolekcije.find(x=> x.id===id);
      }

      fetchAllKolekcije(){
        this.serverService.getKolekcije().subscribe(
          (response)=> {
              console.log(response);
              console.log(response.json());
            },
          (error)=>console.log(error)
      );
      }

      addKolekcija(naziv: string, korisnikId: number){
          this.kolekcije.push(new Kolekcija(this.kolekcije.length+1, korisnikId, naziv,true));
          console.log(this.kolekcije);
          this.serverService.addKolekcija(new Kolekcija(this.kolekcije.length+1, korisnikId, naziv,true)).subscribe(
            (response)=> {
                console.log(response);
                console.log(response.json());
              },
            (error)=>console.log(error)
        );
      }
      addKnjigaToKolekcijaByKolekcijaId(id: number, knjiga: Knjiga){
        this.kolekcije.find(x=> x.id===id).addKnjiga(knjiga);
        this.serverService.addKnjigaByKolekcijaId(id, knjiga).subscribe(
          (response)=> {
              console.log(response);
              console.log(response.json());
            },
          (error)=>console.log(error)
      );
      }
}
