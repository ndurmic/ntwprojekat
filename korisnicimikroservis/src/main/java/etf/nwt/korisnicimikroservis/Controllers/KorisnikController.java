package etf.nwt.korisnicimikroservis.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import etf.nwt.korisnicimikroservis.Services.KorisnikService;
import etf.nwt.korisnicimikroservis.Services.OcjenaService;
import etf.nwt.korisnicimikroservis.Models.*;

@RestController
public class KorisnikController {
    // korisnici
    // korisnici/id
    // dodajkorisnika
    // obrisikorisnika
    // azurirajkorisnika
    @Autowired
    private KorisnikService korisnikService;
    @Autowired
    private OcjenaService ocjenaService;

    @RequestMapping(method = RequestMethod.GET, value = "/korisnici")
    public Iterable<KorisnikModel> listaSvihKorisnika() {
        return korisnikService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/korisnici/{id}")
    public Optional<KorisnikModel> dajKorisnika(@PathVariable Integer id) {
        return korisnikService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/dodajkorisnika")
    public String dodajKorisnika(@RequestBody KorisnikModel korisnik) {
        return korisnikService.addKorisnik(korisnik);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/azurirajkorisnika/{id}")
    public String azurirajKorisnika(@RequestBody KorisnikModel korisnik, @PathVariable int id) {
        return korisnikService.azurirajKorisnika(korisnik, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/obrisikorisnika/{id}")
    public String obrisiKorisnika(@PathVariable Integer id) {
    	List<OcjenaModel> ocjene = (List<OcjenaModel>) ocjenaService.findAll();
    	for(OcjenaModel x : ocjene) {
    		if(x.getKorisnik().getId().equals(id))
    		ocjenaService.obrisiOcjenu(x.getId());
    	}
        return korisnikService.obrisiKorisnika(id);
    }
}
