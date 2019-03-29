package etf.nwt.korisnicimikroservis.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import etf.nwt.korisnicimikroservis.Models.*;
import etf.nwt.korisnicimikroservis.Services.KnjigaService;

public class KnjigaController {
    // knjige
    // knjige/id
    // dodajknjigu
    @Autowired
    private KnjigaService knjigaService;

    @RequestMapping("/knjige")
    public List<KnjigaModel> listaSvihKnjiga() {
        return (List<KnjigaModel>) knjigaService.findAll();
    }

    @RequestMapping("/knjige/{id}")
    public Optional<KnjigaModel> dajKnjigu(@PathVariable Integer id) {
        return knjigaService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/dodajknjigu")
    public void dodajKnjigu(@RequestBody KnjigaModel knjiga) {
        knjigaService.addKnjiga(knjiga);
    }

}