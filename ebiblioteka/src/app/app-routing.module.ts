import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { KnjigaListComponent } from './knjiga-list/knjiga-list.component';
import { KolekcijeComponent } from './kolekcije/kolekcije.component';
import { KnjigaDetailsComponent } from './knjiga-list/knjiga-details/knjiga-details.component';
import { KolekcijaDetailsComponent } from './kolekcije/kolekcija-details/kolekcija-details.component';
import { KolekcijaListComponent } from './kolekcije/kolekcija-list/kolekcija-list.component';

const appRoutes: Routes = [
    { path: '', component: HomeComponent , pathMatch:"full"},
    { path: 'knjige', component: KnjigaListComponent},
    { path: 'knjige/:id', component: KnjigaDetailsComponent },
    { path: 'kolekcije', component: KolekcijeComponent, children:[
      {path: 'personalne', component: KolekcijaListComponent},
      { path: 'javne', component: KolekcijaListComponent }
    ] },
    { path: 'kolekcije/:id', component: KolekcijaDetailsComponent}
  ];

@NgModule({
    imports: [RouterModule.forRoot(appRoutes)],
    exports: [RouterModule]
})
export class AppRoutingModule{

}