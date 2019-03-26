package etf.nwt.korisnicimikroservis;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OcjenaModel {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	private Double ocjena;
	private String komentar;
	private Integer id_knjige;
	private Integer id_Korisnika;
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
	public Integer getId_knjige() {
		return id_knjige;
	}
	public void setId_knjige(Integer id_knjige) {
		this.id_knjige = id_knjige;
	}
	public Integer getId_Korisnika() {
		return id_Korisnika;
	}
	public void setId_Korisnika(Integer id_Korisnika) {
		this.id_Korisnika = id_Korisnika;
	}
	
}
