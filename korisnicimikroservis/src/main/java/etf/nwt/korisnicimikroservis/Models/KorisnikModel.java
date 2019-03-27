package etf.nwt.korisnicimikroservis.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "korisnici")
public class KorisnikModel {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
    private Integer id;
	@Column(name="email")
	private String email;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="ime")
	private String ime;
	@Column(name="prezime")
	private String prezime;
	@Column(name="rola")
	private String rola;
	@Lob
	@Column(name="slika")
	private byte[] slika;
	
	public KorisnikModel(String email, String username, String password, String ime, String prezime,
			String rola, byte[] slika) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.ime = ime;
		this.prezime = prezime;
		this.rola = rola;
		this.slika = slika;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getRola() {
		return rola;
	}
	public void setRola(String rola) {
		this.rola = rola;
	}
	
}
