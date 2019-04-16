package etf.nwt.korisnicimikroservis.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class KategorijeKnjige {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer knjiga_id;

    private Integer kategorija_id;

    public KategorijeKnjige() {

    }

    public Integer getKnjiga_id() {
        return knjiga_id;
    }

    public void setKnjiga_id(Integer knjiga_id) {
        this.knjiga_id = knjiga_id;
    }

    public Integer getKategorija_id() {
        return kategorija_id;
    }

    public void setKategorija_id(Integer kategorija_id) {
        this.kategorija_id = kategorija_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }




}
