import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { KnjigaListComponent } from './knjiga-list/knjiga-list.component';
import { KnjigaDetailsComponent } from './knjiga-list/knjiga-details/knjiga-details.component';
import { AutorDetailsComponent } from './autor-details/autor-details.component';
import { AdminMangmentComponent } from './admin-mangment/admin-mangment.component';
import { UserManagmentComponent } from './user-managment/user-managment.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { KolekcijeComponent } from './kolekcije/kolekcije.component';
import { KolekcijaListComponent } from './kolekcije/kolekcija-list/kolekcija-list.component';
import { KolekcijaDetailsComponent } from './kolekcije/kolekcija-details/kolekcija-details.component';
import { KolekcijaItemComponent } from './kolekcije/kolekcija-item/kolekcija-item.component';
import { KnjigaItemComponent } from './knjiga-list/knjiga-item/knjiga-item.component';
import { HomeComponent } from './home/home.component';
import { AppRoutingModule } from './app-routing.module';
import { KnjigeService } from './services/knjige.service';
import { KolekcijeService } from './services/kolekcije.service';
import { ServerService } from './services/server.service';
import { HttpModule } from '@angular/http';
import { AuthService } from './services/auth.service';
import { NgSelectModule } from '@ng-select/ng-select';



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    KnjigaListComponent,
    KnjigaDetailsComponent,
    AutorDetailsComponent,
    AdminMangmentComponent,
    UserManagmentComponent,
    RegisterComponent,
    LoginComponent,
    KolekcijeComponent,
    KolekcijaListComponent,
    KolekcijaDetailsComponent,
    KolekcijaItemComponent,
    KnjigaItemComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule, FormsModule, ReactiveFormsModule, AppRoutingModule, HttpModule, NgSelectModule
  ],
  providers: [KnjigeService, KolekcijeService, ServerService, AuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }
