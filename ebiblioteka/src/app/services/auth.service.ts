import { Router } from '@angular/router';
import { Headers, Http} from "@angular/http";
import { Injectable } from "@angular/core";

@Injectable()
export class AuthService{
    loggedIn: boolean =true;
    role:string="user";
    loggedUserId: number=1;
    token:string;

    constructor(private router: Router, private http: Http){

    }

    isAuth(){
        return this.loggedIn;
    }
    setLoggedStatus(status: boolean){
        this.loggedIn=status;
    }

    getLoggedUserId(){
        return this.loggedUserId;
    }


    register(mail: string, password: string){
        return this.http.get('');
    }


    login(mail: string, password: string){
        return this.http.get('');
    }
    onLoggedInSuccesfully(role: string){
        this.loggedIn=true;
        this.role=role;
        this.router.navigate(['/']);
    }

    logOut(){
    this.setLoggedStatus(false);
    this.role="";
    this.router.navigate(['/']);
    }

    getRole(){
        return this.role;
    }
}