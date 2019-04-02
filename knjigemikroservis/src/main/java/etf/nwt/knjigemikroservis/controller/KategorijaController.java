package etf.nwt.knjigemikroservis.controller;

import etf.nwt.knjigemikroservis.model.Kategorija;
import etf.nwt.knjigemikroservis.service.KategorijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class KategorijaController {

    @Autowired
    private KategorijaService kategorijaService;

    @RequestMapping("/kategorije")
    public List<Kategorija> listaSvihKategorija (){
        return   kategorijaService.listaSvihKategorija();
    }

    @RequestMapping("/kategorije/{id}")
    public Optional<Kategorija> dajKategoriju (@PathVariable Integer id){
        return   kategorijaService.dajKategoriju(id);
    }

    @RequestMapping(method= RequestMethod.POST, value="/kategorije")
    public void dodajKategoriju(@RequestBody Kategorija kategorija) {
        kategorijaService.dodajKategoriju(kategorija);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/kategorije/{id}")
    public void azurirajKategoriju(@RequestBody Kategorija kategorija, @PathVariable Integer id) {
        kategorijaService.azurirajKategoriju(kategorija, id);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/kategorije/{id}")
    public void obrisiKategoriju (@PathVariable Integer id){
        kategorijaService.obrisiKategoriju(id);
    }

}
