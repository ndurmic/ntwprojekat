package etf.nwt.knjigemikroservis.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Kategorija {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String naziv;

    public Kategorija(String naziv) {
        this.naziv = naziv;
    }

    public Kategorija() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
