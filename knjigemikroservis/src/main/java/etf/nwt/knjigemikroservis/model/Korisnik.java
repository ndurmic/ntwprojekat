package etf.nwt.knjigemikroservis.model;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
public class Korisnik {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Pattern(regexp = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$")
    @Column(name = "email", unique = true)
    private String email;
    @Pattern(regexp = "^[a-zA-Z0-9._-]{3,}$")
    @Column(name = "username")
    private String username;
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{7,20}$")
    @Column(name = "password")
    private String password;
    @Pattern(regexp = "[A-Z][a-z]*")
    @Column(name = "ime")
    private String ime;
    @Pattern(regexp = "[A-Z][a-z]*")
    @Column(name = "prezime")
    private String prezime;
    @Column(name = "rola")
    private String rola;
    @Lob
    @Column(name = "slika")
    private byte[] slika;

    public Korisnik(String email, String username, String password, String ime, String prezime, String rola,
                    byte[] i) {
        super();
        this.email = email;
        this.username = username;
        this.password = password;
        this.ime = ime;
        this.prezime = prezime;
        this.rola = rola;
        this.slika = i;
    }

    public Korisnik(String email, String username, String password, String ime, String prezime, String rola) {
        super();
        this.email = email;
        this.username = username;
        this.password = password;
        this.ime = ime;
        this.prezime = prezime;
        this.rola = rola;
    }


    public Korisnik() {
        super();
        // TODO Auto-generated constructor stub
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