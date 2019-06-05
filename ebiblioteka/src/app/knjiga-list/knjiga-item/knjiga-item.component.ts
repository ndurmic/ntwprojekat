import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';
import { Knjiga } from 'src/app/zmodels/knjiga.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-knjiga-item',
  templateUrl: './knjiga-item.component.html',
  styleUrls: ['./knjiga-item.component.css']
})
export class KnjigaItemComponent implements OnInit {
  
  @Input() knjiga: Knjiga;
  

  constructor(private router: Router) { }

  ngOnInit() {
  }
  
  knjigaSelected(){
    console.log("radi");
    this.router.navigate(['knjige/'+this.knjiga.id]);
  }

}
