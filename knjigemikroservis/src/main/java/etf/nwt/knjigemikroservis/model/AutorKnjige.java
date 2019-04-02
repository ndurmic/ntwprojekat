package etf.nwt.knjigemikroservis.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AutorKnjige {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer id_autora;
    private Integer id_knjige;

    public AutorKnjige(Integer id_autora, Integer id_knjige) {
        this.id_autora = id_autora;
        this.id_knjige = id_knjige;
    }

    public AutorKnjige() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_autora() {
        return id_autora;
    }

    public void setId_autora(Integer id_autora) {
        this.id_autora = id_autora;
    }

    public Integer getId_knjige() {
        return id_knjige;
    }

    public void setId_knjige(Integer id_knjige) {
        this.id_knjige = id_knjige;
    }
}
