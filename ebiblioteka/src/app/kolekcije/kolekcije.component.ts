import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-kolekcije',
  templateUrl: './kolekcije.component.html',
  styleUrls: ['./kolekcije.component.css']
})
export class KolekcijeComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
    this.router.navigate(['kolekcije/personalne']);
  }

}
