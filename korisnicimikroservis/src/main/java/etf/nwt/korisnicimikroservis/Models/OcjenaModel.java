package etf.nwt.korisnicimikroservis.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "ocjene")
public class OcjenaModel {
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
	private KnjigaModel knjiga;
	@ManyToOne
	@JoinColumn(name = "id_korisnika", referencedColumnName = "id", nullable = true)
	private KorisnikModel korisnik;

	public OcjenaModel(Integer ocjena, String komentar, KnjigaModel knjiga, KorisnikModel korisnik) {
		super();
		this.ocjena = ocjena;
		this.komentar = komentar;
		this.knjiga = knjiga;
		this.korisnik = korisnik;
	}

	public OcjenaModel() {
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

	public KnjigaModel getKnjiga() {
		return knjiga;
	}

	public void setKnjiga(KnjigaModel knjiga) {
		this.knjiga = knjiga;
	}

	public KorisnikModel getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(KorisnikModel korisnik) {
		this.korisnik = korisnik;
	}

}
