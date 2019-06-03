import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { FormControl } from '@angular/forms';

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
  constructor() { }

  ngOnInit() {
    this.loginFormGroup = new FormGroup({
      'mail': new FormControl(),
      'password': new FormControl()
   });
  }

  onLogin(){
    
  }

}
