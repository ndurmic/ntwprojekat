package etf.nwt.korisnicimikroservis.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import etf.nwt.korisnicimikroservis.Services.KorisnikService;
import etf.nwt.korisnicimikroservis.Models.*;

public class KorisnikController {
    // korisnici
    // korisnici/id
    // dodajkorisnika
    // obrisikorisnika
    // azurirajkorisnika
    @Autowired
    private KorisnikService korisnikService;

    @RequestMapping("/korisnici")
    public List<KorisnikModel> listaSvihKorisnika() {
        return (List<KorisnikModel>) korisnikService.findAll();
    }

    @RequestMapping("/korisnici/{id}")
    public Optional<KorisnikModel> dajKorisnika(@PathVariable Integer id) {
        return korisnikService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/dodajkorisnika")
    public void dodajKorisnika(@RequestBody KorisnikModel korisnik) {
        korisnikService.addKorisnik(korisnik);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/azurirajkorisnika/{id}")
    public void azurirajKorisnika(@RequestBody KorisnikModel korisnik, @PathVariable int id) {
        korisnikService.azurirajKorisnika(korisnik, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/obrisikorisnika/{id}")
    public void obrisiKorisnika(@PathVariable Integer id) {
        korisnikService.obrisiKorisnika(id);
    }
}
