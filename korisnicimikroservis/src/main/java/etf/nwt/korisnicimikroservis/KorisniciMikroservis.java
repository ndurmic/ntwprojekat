package etf.nwt.korisnicimikroservis;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import etf.nwt.korisnicimikroservis.Models.KnjigaModel;
import etf.nwt.korisnicimikroservis.Models.KorisnikModel;
import etf.nwt.korisnicimikroservis.Services.KnjigaService;
import etf.nwt.korisnicimikroservis.Services.KorisnikService;
import etf.nwt.korisnicimikroservis.Services.OcjenaService;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class KorisniciMikroservis implements CommandLineRunner {
	@Autowired
	OcjenaService ocjenaServis;
	@Autowired
	KnjigaService knjigaServis;
	@Autowired
	KorisnikService korisnikServis;

	public static void main(String[] args) {
		SpringApplication.run(KorisniciMikroservis.class, args);
	}

	public void run(String... args) throws Exception {

		KnjigaModel knjiga = new KnjigaModel("Proces", "...", new Date(1900, 1, 1), 1, 1);
		System.out.println(knjigaServis.addKnjiga(knjiga));

		String str = "Example String";
		byte[] b = str.getBytes();
		KorisnikModel korisnik = new KorisnikModel("email@email.com", "username", "sifra1%Sifra", "Ime", "Prezime", "rola",
				b);
		System.out.println(korisnikServis.addKorisnik(korisnik));

	}
}
