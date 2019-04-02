package etf.nwt.korisnicimikroservis.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import etf.nwt.korisnicimikroservis.Models.*;
import etf.nwt.korisnicimikroservis.Services.OcjenaService;

@RestController
public class OcjenaController {
    // ocjene
    // ocjene/id
    // dodajocjenu
    // obrisiocjenu
    // azurirajocjenu

    @Autowired
    private OcjenaService ocjenaService;

    @RequestMapping("/ocjene")
    public List<OcjenaModel> listaSvihOcjena() {
        return (List<OcjenaModel>) ocjenaService.findAll();
    }

    @RequestMapping("/ocjene/{id}")
    public Optional<OcjenaModel> dajOcjenu(@PathVariable Integer id) {
        return ocjenaService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/dodajocjenu")
    public String dodajOcjenu(@RequestBody OcjenaModel ocjena) {
        return ocjenaService.addOcjena(ocjena);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/azurirajocjenu/{id}")
    public String azurirajOcjenu(@RequestBody OcjenaModel ocjena, @PathVariable int id) {
        return ocjenaService.azurirajOcjenu(ocjena, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/obrisiocjenu/{id}")
    public String obrisiOcjenu(@PathVariable Integer id) {
        return ocjenaService.obrisiOcjenu(id);
    }
}