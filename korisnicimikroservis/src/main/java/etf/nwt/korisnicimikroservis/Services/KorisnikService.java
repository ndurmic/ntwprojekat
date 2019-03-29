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
			return e.toString();
		}
		return "Radi";
	}

	public String azurirajKorisnika(KorisnikModel korisnik, int id) {
		try {
			korisnikRepositori.save(korisnik);
		} catch (Exception e) {
			return e.toString();
		}
		return "";
	}

	public String obrisiKorisnika(Integer id) {
		try {
			korisnikRepositori.deleteById(id);
		} catch (Exception e) {
			return e.toString();
		}
		return "";
	}

}
