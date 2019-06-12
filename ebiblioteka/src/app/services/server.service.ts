import { Injectable } from '@angular/core';
import {Http, Headers } from '@angular/http';
import { Komentar } from '../zmodels/komentar.model';
import { Knjiga } from '../zmodels/knjiga.model';
import { Kolekcija } from '../zmodels/kolekcija.model';
import { AuthService } from './auth.service';

@Injectable() 
export class ServerService{
    constructor(private http: Http, private authService:AuthService){}

    headers=new Headers({'Authorization': 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJlbWFpbDFAZW1haWwuY29tIiwiYXV0aCI6InJvbGFhIiwiaWF0IjoxNTYwMjk4MTY1LCJleHAiOjE1NjAzMDE3NjV9.YU5hkLQ5gdR0e9FnjB0Mcd26j93vSG0N-enXspiyoKA'});


    getKnjige(){
        console.log(this.authService.token);
        return this.http.get('http://10.0.75.2:9000/knjige-mikroservis/knjige',{headers: this.headers});
    }

    getKnjigaById(id:number){
        return this.http.get('http://10.0.75.2:9000/knjige-mikroservis/knjige/'+id,{headers: this.headers});
    }

    addKomentar(idKnjige: number, komentar: Komentar){
        return this.http.post('',komentar);
    }
    updateKnjiga(knjiga: Knjiga){
        return this.http.put('http://10.0.75.2:9000/knjige-mikroservis/knjige/'+knjiga.id, {naslov:knjiga.naziv,opis:knjiga.opis,datumIzdavanja:"1.1.2000"},{headers: this.headers});
    }

    getKolekcije(){
        return this.http.get('http://10.0.75.2:9000/kolekcije-mikroservis/kolekcije',{headers: this.headers});
    }

    addKolekcija(kolekcija: Kolekcija){
        var vidljiva=0;

        if(kolekcija.javna==true){
            vidljiva=1;
        }
        else{
            vidljiva=0;
        }

        return this.http.post('http://10.0.75.2:9000/kolekcije-mikroservis/kolekcije/'+this.authService.getLoggedUserId(), {naziv:kolekcija.naziv, opis:"Opis kolekcije",kolekcijaVidljiva:vidljiva},{headers: this.headers} );
    }

    addKnjigaByKolekcijaId(idKolekcije: number, knjiga: Knjiga){
        return this.http.post('',knjiga);
    }
}