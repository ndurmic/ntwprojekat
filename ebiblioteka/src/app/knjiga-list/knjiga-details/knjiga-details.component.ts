import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Knjiga } from 'src/app/zmodels/knjiga.model';
import { KnjigeService } from 'src/app/services/knjige.service';

@Component({
  selector: 'app-knjiga-details',
  templateUrl: './knjiga-details.component.html',
  styleUrls: ['./knjiga-details.component.css']
})
export class KnjigaDetailsComponent implements OnInit {
  id: number;
  knjiga: Knjiga;
  constructor(private route: ActivatedRoute, private knjigeService: KnjigeService) { 

  }

  ngOnInit() {
    this.route.params.subscribe(
      (params: Params)=>{
        this.id=+params['id'];
        this.knjiga=this.knjigeService.getKnjigaById(this.id);
      }
    );
  }

}
