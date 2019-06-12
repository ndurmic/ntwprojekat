import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { FormControl } from '@angular/forms';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  ime: string;
  prezime: string;
  mail: string;
  password: string;
  passwordPotvrda: string;
  registerFormGroup: FormGroup;
  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit() {
    this.registerFormGroup = new FormGroup({
      'ime': new FormControl(),
      'prezime': new FormControl(),
      'mail': new FormControl(),
      'password': new FormControl(),
      'passwordPotvrda': new FormControl()
   });
  }

  onSignup(){
    
    console.log(this.mail+this.password);
    if(this.mail!=null && this.password!=null){
      this.authService.register(this.mail, this.password,this.ime, this.prezime).subscribe(
        (response) => {
          const data= response.json();
          console.log("register"+data);
          this.router.navigate(['/login']);
        },
        (error)=>console.log(error)
      );
    }
    
  }

}
