package etf.nwt.korisnicimikroservis.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "ocjene")
public class OcjenaModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true)
	private Integer id;
	@Pattern(regexp = "^([1-5])$")
	@Column(name = "ocjena")
	private Double ocjena;
	@Column(name = "komentar")
	private String komentar;

	@ManyToOne
	@JoinColumn(name = "id_knjige", referencedColumnName = "id", nullable = true)
	private KnjigaModel knjiga;
	@ManyToOne
	@JoinColumn(name = "id_korisnika", referencedColumnName = "id", nullable = true)
	private KorisnikModel korisnik;

	public OcjenaModel(Double ocjena, String komentar, KnjigaModel knjiga, KorisnikModel korisnik) {
		super();
		this.ocjena = ocjena;
		this.komentar = komentar;
		this.knjiga = knjiga;
		this.korisnik = korisnik;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getOcjena() {
		return ocjena;
	}

	public void setOcjena(Double ocjena) {
		this.ocjena = ocjena;
	}

	public String getKomentar() {
		return komentar;
	}

	public void setKomentar(String komentar) {
		this.komentar = komentar;
	}

}
