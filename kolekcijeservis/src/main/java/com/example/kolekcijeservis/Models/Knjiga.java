package com.example.kolekcijeservis.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "knjige")
public class Knjiga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private String naslov;
    private String opis;

    @Temporal(TemporalType.TIMESTAMP)
    private Date datumIzdavanja;

    private int id_kategorije;
    private int id_autorKnjige;

    public int getId_kategorije() {
        return id_kategorije;
    }

    public void setId_kategorije(int id_kategorije) {
        this.id_kategorije = id_kategorije;
    }

    public int getId(){return id;}
    public void setId(int id){this.id=id;}

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Date getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(Date datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    public int getId_autorKnjige() {
        return id_autorKnjige;
    }

    public void setId_autorKnjige(int id_autorKnjige) {
        this.id_autorKnjige = id_autorKnjige;
    }

    public String getNaslov(){return naslov;}
    public void setNaslov(String naslov){this.naslov=naslov;}



    public Knjiga(){}
    public Knjiga(int id, String nasov, String opis, Date datumIzdavanja, int idAutora, int idKatergorije){
        this.id=id;
        this.naslov=nasov;
        this.opis=opis;
        this.datumIzdavanja=datumIzdavanja;
        this.id_autorKnjige=idAutora;
        this.id_kategorije=idKatergorije;
    }
}
