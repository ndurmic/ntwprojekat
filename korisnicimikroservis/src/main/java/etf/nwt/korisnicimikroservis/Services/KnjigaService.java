package etf.nwt.korisnicimikroservis.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import etf.nwt.knjigemikroservis.model.Knjiga;
import etf.nwt.korisnicimikroservis.Models.Knjiga;
import etf.nwt.korisnicimikroservis.Models.KorisnikModel;
import etf.nwt.korisnicimikroservis.Repositories.KnjigaRepository;

@Service
public class KnjigaService {

	@Autowired
	KnjigaRepository knjigaRepositori;

	public Iterable<Knjiga> findAll() {
		return knjigaRepositori.findAll();
	}

	public Optional<Knjiga> findById(int id) {
		return knjigaRepositori.findById(id);
	}

	public String addKnjiga(Knjiga k) {
		try {
			knjigaRepositori.save(k);
		} catch (Exception e) {
			//return e.toString();
			return "Nisu podaci validni";
		}
		return "Knjiga uspješno dodana";
	}
	
	public String azurirajKnjigu (Knjiga knjiga, Integer id){
        //JPA prepozna ako nema objekta onda ce ga dodati, ako ima azurirat ce ga u zavisnosti od ID koji se nalazi u entitetu
        //Zbog toga nema potrebe za metodom update, save radi oboje
        knjiga.setId(id);
        knjigaRepositori.save(knjiga);
        return "Knjiga uspješno ažurirana";
    }
	
	public String azurirajKnjigu1 (Knjiga knjiga){
        //JPA prepozna ako nema objekta onda ce ga dodati, ako ima azurirat ce ga u zavisnosti od ID koji se nalazi u entitetu
        //Zbog toga nema potrebe za metodom update, save radi oboje
        knjigaRepositori.save(knjiga);
        return "Knjiga uspješno ažurirana";
    }

    public String obrisiKnjigu(Integer id){
        knjigaRepositori.deleteById(id);
        return "Knjiga uspješno obrisana";
    }
}
