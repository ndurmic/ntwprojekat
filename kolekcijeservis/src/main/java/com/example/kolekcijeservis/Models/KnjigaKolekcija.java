package com.example.kolekcijeservis.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "kolekcijeknjige")
public class KnjigaKolekcija   {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Kolekcije_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Kolekcija kolekcija;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Knjige_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Knjiga knjiga;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Kolekcija getKolekcija() {
        return kolekcija;
    }

    public void setKolekcija(Kolekcija kolekcija) {
        this.kolekcija = kolekcija;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    public KnjigaKolekcija(int id, Kolekcija kolekcija, Knjiga knjiga) {
        this.id = id;
        this.kolekcija = kolekcija;
        this.knjiga = knjiga;
    }
}
