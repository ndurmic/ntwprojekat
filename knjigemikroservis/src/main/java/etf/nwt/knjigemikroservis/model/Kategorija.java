package etf.nwt.knjigemikroservis.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Kategorija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String naziv;
    @Column(name="knjiga_id")
    private Integer knjiga_id;

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

    public Integer getKnjiga_id() {
        return knjiga_id;
    }

    public void setKnjiga_id(Integer knjiga_id) {
        this.knjiga_id = knjiga_id;
    }
}
