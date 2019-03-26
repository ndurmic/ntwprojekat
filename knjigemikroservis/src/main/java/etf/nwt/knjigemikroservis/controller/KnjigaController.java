package etf.nwt.knjigemikroservis.controller;

import etf.nwt.knjigemikroservis.model.Knjiga;
import etf.nwt.knjigemikroservis.service.KnjigaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class KnjigaController {

    @Autowired
    private KnjigaService knjigaService;

    @RequestMapping("/knjige")
    public List<Knjiga> listaSvihKnjiga (){
        return   knjigaService.listaSvihKnjiga();
    }

    @RequestMapping("/knjige/{id}")
    public Optional<Knjiga> dajKnjigu (@PathVariable Integer id){
        return   knjigaService.dajKnjigu(id);
    }

    @RequestMapping(method= RequestMethod.POST, value="/knjige")
    public void dodajKnjigu(@RequestBody Knjiga knjiga) {
        knjigaService.dodajKnjigu(knjiga);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/knjige/{id}")
    public void azurirajKnjigu(@RequestBody Knjiga knjiga, @PathVariable int id) {
        knjigaService.azurirajKnjigu(knjiga, id);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/knjige/{id}")
    public void obrisiKnjigu (@PathVariable Integer id){
        knjigaService.obrisiKnjigu(id);
    }

}
