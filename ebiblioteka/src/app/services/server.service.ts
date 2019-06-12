import { Injectable } from '@angular/core';
import {Http, Headers } from '@angular/http';
import { Komentar } from '../zmodels/komentar.model';
import { Knjiga } from '../zmodels/knjiga.model';
import { Kolekcija } from '../zmodels/kolekcija.model';

@Injectable()
export class ServerService{
    constructor(private http: Http){}
    getKnjige(){
        const headers=new Headers({'Authorization': 'Bearer nastoken'});
        return this.http.get('',{headers: headers});
    }
    addKomentar(idKnjige: number, komentar: Komentar){
        return this.http.post('',komentar);
    }
    updateKnjiga(knjiga: Knjiga){
        return this.http.post('', knjiga);
    }

    getKolekcije(){
        return this.http.get('',);
    }

    addKolekcija(kolekcija: Kolekcija){
        return this.http.post('', kolekcija );
    }

    addKnjigaByKolekcijaId(idKolekcije: number, knjiga: Knjiga){
        return this.http.post('',knjiga);
    }
}