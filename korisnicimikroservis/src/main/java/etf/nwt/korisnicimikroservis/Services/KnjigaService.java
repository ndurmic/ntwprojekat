package etf.nwt.korisnicimikroservis.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import etf.nwt.korisnicimikroservis.Models.KnjigaModel;
import etf.nwt.korisnicimikroservis.Models.KorisnikModel;
import etf.nwt.korisnicimikroservis.Repositories.KnjigaRepository;

@Service
public class KnjigaService {

	@Autowired
	KnjigaRepository knjigaRepositori;

	public Iterable<KnjigaModel> findAll() {
		return knjigaRepositori.findAll();
	}

	public Optional<KnjigaModel> findById(int id) {
		return knjigaRepositori.findById(id);
	}

	public String addKnjiga(KnjigaModel k) {
		try {
			knjigaRepositori.save(k);
		} catch (Exception e) {
			//return e.toString();
			return "Nisu podaci validni";
		}
		return "Knjiga uspješno dodana";
	}
}
