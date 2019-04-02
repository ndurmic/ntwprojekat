package etf.nwt.korisnicimikroservis.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import etf.nwt.korisnicimikroservis.Models.KorisnikModel;
import etf.nwt.korisnicimikroservis.Repositories.KorisnikRepository;

@Service
public class KorisnikService {

	@Autowired
	KorisnikRepository korisnikRepositori;

	public Iterable<KorisnikModel> findAll() {
		return korisnikRepositori.findAll();
	}

	public Optional<KorisnikModel> findById(int id) {
		return korisnikRepositori.findById(id);
	}

	public String addKorisnik(KorisnikModel k) {
		try {
			korisnikRepositori.save(k);
		} catch (Exception e) {
			//return e.toString();
			return "Nisu podaci validni";
		}
		return "Korisnik uspješno dodan";
	}

	public String azurirajKorisnika(KorisnikModel korisnik, int id) {
		try {
			korisnikRepositori.findById(id).map(k ->{
				k.setEmail(korisnik.getEmail());
				k.setIme(korisnik.getIme());
				k.setPassword(korisnik.getPassword());
				k.setPrezime(korisnik.getPrezime());
				k.setRola(korisnik.getRola());
				k.setUsername(korisnik.getUsername());
				return korisnikRepositori.save(k);
			});
			//korisnikRepositori.save(korisnik);
		} catch (Exception e) {
			//return e.toString();
			return "Nisu podaci validni";
		}
		return "Korisnik uspješno ažuriran";
	}

	public String obrisiKorisnika(Integer id) {
		try {
			korisnikRepositori.deleteById(id);
		} catch (Exception e) {
			//return e.toString();
			return "Greška prilikom brisanja";
		}
		return "Korisnik uspješno obrisan";
	}

}
