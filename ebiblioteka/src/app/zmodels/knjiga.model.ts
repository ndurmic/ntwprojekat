import { Komentar } from './komentar.model';

export class Knjiga {
    public naziv: string;
    public opis: string;
    public imagePath: string;
    public id: number;
    public rating: number;
    public komentari: Komentar[];
    public ocjene: number[];
    public kategorije: string[];

    constructor(id: number, naziv: string, opis: string, imagePath: string, rating: number, kategorije: string[]){
        this.id=id;
        this.naziv=naziv;
        this.opis=opis;
        this.imagePath=imagePath;
        this.rating=rating;
        this.komentari=null;
        this.ocjene=null;
        this.kategorije=kategorije;
        if(this.ocjene!=null){
            let suma=0;
            for(var x of this.ocjene) {
                suma+=x;
            }
            this.rating=suma/this.ocjene.length;
        }
    }

    addKomentar(idKorisnika: number, komentar: string){
        console.log(idKorisnika);
        console.log(komentar);
        
        if(this.komentari===null){
            this.komentari=[
                new Komentar(1, idKorisnika, komentar)
            ];
        }
        else{
           this.komentari.push(new Komentar(this.komentari.length+1, idKorisnika, komentar)); 
        }
        console.log(this.komentari);
        
    }

    addOcjena(ocjena: number){
        if(this.ocjene===null){
            this.ocjene=[
                ocjena
            ];
        }
        else{
           this.ocjene.push(ocjena); 
        }
        let suma=0;
            for(var x of this.ocjene) {
                suma+=x;
            }
            this.rating=suma/this.ocjene.length;
    }

    setKategorije(kategorije: string[]){
        this.kategorije=kategorije;
    }

    
}