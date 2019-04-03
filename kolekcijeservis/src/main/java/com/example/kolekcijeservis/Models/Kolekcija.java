package com.example.kolekcijeservis.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "kolekcije")
public class Kolekcija {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private String naziv;
    private String opis;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Date getDatumKreiranja() {
        return datumKreiranja;
    }

    public void setDatumKreiranja(Date datumKreiranja) {
        this.datumKreiranja = datumKreiranja;
    }

    public int getKolekcijaVidljiva() {
        return kolekcijaVidljiva;
    }

    public void setKolekcijaVidljiva(int kolekcijaVidljiva) {
        this.kolekcijaVidljiva = kolekcijaVidljiva;
    }

    public String getKolekcijecol() {
        return Kolekcijecol;
    }

    public void setKolekcijecol(String kolekcijecol) {
        Kolekcijecol = kolekcijecol;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date datumKreiranja;

    private int kolekcijaVidljiva;
    private String Kolekcijecol;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idKorisnika", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Korisnik korisnik;

}
