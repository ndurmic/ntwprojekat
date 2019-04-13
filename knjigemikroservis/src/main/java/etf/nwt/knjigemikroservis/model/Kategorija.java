package etf.nwt.knjigemikroservis.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Kategorija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String naziv;
    @ManyToMany(mappedBy = "listaKategorija")
    @JsonIgnore
    private List<Knjiga> listaKnjiga;

    public Kategorija(String naziv) {
        this.naziv = naziv;
    }

    public Kategorija(String naziv,List<Knjiga> listaKnjiga) {
        this.naziv = naziv;
        this.listaKnjiga = listaKnjiga;
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

    public List<Knjiga> getListaKnjiga() {
        return listaKnjiga;
    }

    public void setListaKnjiga(List<Knjiga> listaKnjiga) {
        this.listaKnjiga = listaKnjiga;
    }

}
