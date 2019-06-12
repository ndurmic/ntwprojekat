import { Router } from '@angular/router';
import { Headers, Http} from "@angular/http";
import { Injectable } from "@angular/core";

@Injectable()
export class AuthService{
    loggedIn: boolean =true;
    role:string="user";
    loggedUserId: number=1;
    token:string;
    
    
    headers=new Headers({'Content-Type':'application/json'});

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


    register(mail: string, password: string, ime: string, prezime: string){
        return this.http.post('http://10.0.75.2:9000/signup', {email:mail, username:"usernamee",password:password,ime:ime,prezime:prezime, rola:"user"},{headers: this.headers} );
    }


    login(mail: string, password: string){
        return this.http.post('http://10.0.75.2:9000/signin',{
            username: mail,
            password: password
        },{headers: this.headers});
    }
    onLoggedInSuccesfully(role: string){
        this.loggedIn=true;
        this.role=role;
        this.router.navigate(['/knjige']);
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