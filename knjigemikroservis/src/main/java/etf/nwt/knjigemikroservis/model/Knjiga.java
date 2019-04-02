package etf.nwt.knjigemikroservis.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Knjiga {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String naslov;
    private String opis;
    private String datumIzdavanja;


    @ManyToOne
    private Kategorija kategorija;

    public Knjiga(String naslov, String opis, String datumIzdavanja) {
        this.naslov = naslov;
        this.opis = opis;
        this.datumIzdavanja = datumIzdavanja;
    }

    public Knjiga() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(String  datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }


}
