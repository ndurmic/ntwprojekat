import { Kolekcija } from '../zmodels/kolekcija.model';

export class KolekcijeService {
    
    public kolekcije: Kolekcija[] = [
        new Kolekcija(1,'Kolekcija 1',true),
        new Kolekcija(2,'Kolekcija 2',true),
        new Kolekcija(3,'Kolekcija 3',true),
        new Kolekcija(4,'Kolekcija 4',true),
        new Kolekcija(5,'Kolekcija 5',true),
        new Kolekcija(6,'Kolekcija 6',true)
      ];

      getKolekcije(){
          return this.kolekcije;
      }
      getKolekcijaById(id: number){
        return this.kolekcije.find(x=> x.id===id);
      }

      addKolekcija(naziv: string){
          this.kolekcije.push(new Kolekcija(this.kolekcije.length,naziv,true));
      }
}
