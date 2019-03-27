package com.example.kolekcijeservis.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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

    private int id_autorKnjige;
    private int id_kategorije;
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
