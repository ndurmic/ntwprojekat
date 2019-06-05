import { Injectable } from '@angular/core';
import {Http } from '@angular/http';

@Injectable()
export class ServerService{
    constructor(private http: Http){}
    getKnjige(){
        return this.http.get('');
    }

}