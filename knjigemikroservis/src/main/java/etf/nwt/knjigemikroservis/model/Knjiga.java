package etf.nwt.knjigemikroservis.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
public class Knjiga {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
    @NotNull
    private String naslov;
    @NotNull
    @Size(min=20)
    private String opis;
    private String datumIzdavanja;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "KategorijeKnjige", joinColumns = @JoinColumn(name = "knjiga_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "kategorija_id", referencedColumnName = "id"))
    private List<Kategorija> listaKategorija;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "AutorKnjige", joinColumns = @JoinColumn(name = "knjiga_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id", referencedColumnName = "id"))
    private List<Autor> listaAutora;

    public Knjiga(String naslov, String opis, String datumIzdavanja, List<Kategorija> listaKategorija) {
        this.naslov = naslov;
        this.opis = opis;
        this.datumIzdavanja = datumIzdavanja;
        this.listaKategorija = listaKategorija;
    }

    public Knjiga(String naslov, String opis, String datumIzdavanja, List<Kategorija> listaKategorija, List<Autor> listaAutora) {
        this.naslov = naslov;
        this.opis = opis;
        this.datumIzdavanja = datumIzdavanja;
        this.listaKategorija = listaKategorija;
        this.listaAutora = listaAutora;
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

    public List<Kategorija> getListaKategorija() {
        return listaKategorija;
    }

    public void setListaKategorija(List<Kategorija> listaKategorija) {
        this.listaKategorija = listaKategorija;
    }

    public List<Autor> getListaAutora() {
        return listaAutora;
    }

    public void setListaAutora(List<Autor> listaAutora) {
        this.listaAutora = listaAutora;
    }

}
