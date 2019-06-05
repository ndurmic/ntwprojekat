import { Knjiga } from '../zmodels/knjiga.model';
import { ServerService } from './server.service';

export class KnjigeService {
    private knjige: Knjiga[] = [
        new Knjiga(1,'Knjiga 1','Lorem ipsum dolor sit amet consectetur adipisicing elit. Velit quos eius id maxime quasi ratione, modi recusandae voluptas necessitatibus dolores labore voluptatem quia repellendus architecto, mollitia quae consequuntur expedita sint?','https://evrobook.rs/fajlovi/product/jezeva-kucica-jezeva-kucica_59c36d949222f.jpg', 4),
        new Knjiga(2,'Knjiga 2','Lorem ipsum dolor sit amet consectetur adipisicing elit. Velit quos eius id maxime quasi ratione, modi recusandae voluptas necessitatibus dolores labore voluptatem quia repellendus architecto, mollitia quae consequuntur expedita sint?','https://evrobook.rs/fajlovi/product/jezeva-kucica-jezeva-kucica_59c36d949222f.jpg', 4.5)
      ];


      constructor(private serverService: ServerService){

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
}