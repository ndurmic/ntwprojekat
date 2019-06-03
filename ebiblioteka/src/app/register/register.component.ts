import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { FormControl } from '@angular/forms';

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
  constructor() { }

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
    
    
  }

}
