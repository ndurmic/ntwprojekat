package etf.nwt.korisnicimikroservis;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class KnjigaModel {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String naslov;
    private String opis;
    private String datumIzdavanja;
    private Integer id_kategorije;
    private Integer id_autorKnjige;
	public KnjigaModel() {
		super();
		// TODO Auto-generated constructor stub
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
	public void setDatumIzdavanja(String datumIzdavanja) {
		this.datumIzdavanja = datumIzdavanja;
	}
	public Integer getId_kategorije() {
		return id_kategorije;
	}
	public void setId_kategorije(Integer id_kategorije) {
		this.id_kategorije = id_kategorije;
	}
	public Integer getId_autorKnjige() {
		return id_autorKnjige;
	}
	public void setId_autorKnjige(Integer id_autorKnjige) {
		this.id_autorKnjige = id_autorKnjige;
	}
}
