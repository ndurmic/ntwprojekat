package etf.nwt.korisnicimikroservis.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "knjige")
public class KnjigaModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	@Column(name = "naslov")
	private String naslov;
	@Column(name = "opis")
	private String opis;
	@Column(name = "datumIzdavanja")
	private Date datumIzdavanja;
	@Column(name = "id_kategorije", unique = true, nullable = false)
	private Integer id_kategorije;
	@Column(name = "id_autoraKnjige", unique = true, nullable = false)
	private Integer id_autoraKnjige;

	public KnjigaModel(String naslov, String opis, Date date, Integer id_kategorije, Integer id_autoraKnjige) {
		super();
		this.naslov = naslov;
		this.opis = opis;
		this.datumIzdavanja = date;
		this.id_kategorije = id_kategorije;
		this.id_autoraKnjige = id_autoraKnjige;
	}

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

	public Date getDatumIzdavanja() {
		return datumIzdavanja;
	}

	public void setDatumIzdavanja(Date datumIzdavanja) {
		this.datumIzdavanja = datumIzdavanja;
	}

	public Integer getId_kategorije() {
		return id_kategorije;
	}

	public void setId_kategorije(Integer id_kategorije) {
		this.id_kategorije = id_kategorije;
	}

	public Integer getId_autoraKnjige() {
		return id_autoraKnjige;
	}

	public void setId_autoraKnjige(Integer id_autoraKnjige) {
		this.id_autoraKnjige = id_autoraKnjige;
	}
}
