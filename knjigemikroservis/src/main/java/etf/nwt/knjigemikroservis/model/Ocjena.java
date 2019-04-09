package etf.nwt.knjigemikroservis.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Ocjena {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private Integer id;
    @Min(1)
    @Max(5)
    @Column(name = "ocjena")
    private Integer ocjena;
    @Column(name = "komentar")
    private String komentar;

    @ManyToOne
    @JoinColumn(name = "id_knjige", referencedColumnName = "id", nullable = true)
    private Knjiga knjiga;
    @ManyToOne
    @JoinColumn(name = "id_korisnika", referencedColumnName = "id", nullable = true)
    private Korisnik korisnik;

    public Ocjena(Integer ocjena, String komentar, Knjiga knjiga, Korisnik korisnik) {
        super();
        this.ocjena = ocjena;
        this.komentar = komentar;
        this.knjiga = knjiga;
        this.korisnik = korisnik;
    }

    public Ocjena() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOcjena() {
        return ocjena;
    }

    public void setOcjena(Integer ocjena) {
        this.ocjena = ocjena;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
}
