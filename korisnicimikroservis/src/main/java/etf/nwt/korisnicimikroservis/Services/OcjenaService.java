package etf.nwt.korisnicimikroservis.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import etf.nwt.korisnicimikroservis.Models.OcjenaModel;
import etf.nwt.korisnicimikroservis.Repositories.KnjigaRepository;
import etf.nwt.korisnicimikroservis.Repositories.KorisnikRepository;
import etf.nwt.korisnicimikroservis.Repositories.OcjenaRepository;

@Service
public class OcjenaService {

	@Autowired
	OcjenaRepository ocjenaRepositori;
	@Autowired
	KorisnikRepository korisnikRepositori;
	@Autowired
	KnjigaRepository knjigaRepositori;

	public Iterable<OcjenaModel> findAll() {
		return ocjenaRepositori.findAll();
	}

	public Optional<OcjenaModel> findById(int id) {
		return ocjenaRepositori.findById(id);
	}

	public String addOcjena(OcjenaModel k) {
		try {
			
			ocjenaRepositori.save(k);
		} catch (Exception e) {
			//return e.toString();
			return "Nisu podaci validni";
		}
		return "Ocjena uspješno dodana";
	}

	public String azurirajOcjenu(OcjenaModel ocjena, int id) {
		try {
			ocjenaRepositori.findById(id).map(o ->{
				o.setOcjena(ocjena.getOcjena());
				o.setKomentar(ocjena.getKomentar());
				o.setKorisnik(ocjena.getKorisnik());
				o.setKnjiga(ocjena.getKnjiga());
				return ocjenaRepositori.save(o);
			});
			ocjenaRepositori.save(ocjena);
		} catch (Exception e) {
			//return e.toString();
			return "Nisu podaci validni";
		}
		return "Ocjena uspješno ažurirana";
	}

	public String obrisiOcjenu(Integer id) {
		try {
			ocjenaRepositori.deleteById(id);
		} catch (Exception e) {
			//return e.toString();
			return "Greška prilikom brisanja ocjene";
		}
		return "Ocjena uspješno obrisana";
	}

}
