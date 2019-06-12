import { Component, OnInit } from '@angular/core';
import { Knjiga } from '../zmodels/knjiga.model';
import { KnjigeService } from '../services/knjige.service';

@Component({
  selector: 'app-knjiga-list',
  templateUrl: './knjiga-list.component.html',
  styleUrls: ['./knjiga-list.component.css']
})
export class KnjigaListComponent implements OnInit {

  public knjige: Knjiga[];

  constructor(private knjigeService: KnjigeService) { }

  ngOnInit() {
    this.knjige=this.knjigeService.getKnjige();
    
  }

  

}
