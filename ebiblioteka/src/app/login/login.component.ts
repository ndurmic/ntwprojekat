import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { FormControl } from '@angular/forms';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  message: string = '';
  mail: string;
  password: string;
  loginFormGroup: FormGroup;
  constructor(private authService: AuthService) { }

  ngOnInit() {
    this.loginFormGroup = new FormGroup({
      'mail': new FormControl(),
      'password': new FormControl()
   });
  }

  onLogin(){
    console.log(this.mail+this.password);
    if(this.mail!=null && this.password!=null){
      this.authService.login(this.mail, this.password).subscribe(
        (response) => {
          const data= response.json();
          console.log("login"+data);
          if(response!=null){
            this.authService.token=data.accessToken;
            this.authService.onLoggedInSuccesfully('user');
          }
          else{
            this.message="Username or password was incorrect";
          }
        },
        (error)=>console.log(error)
      );
    }
  }

}
