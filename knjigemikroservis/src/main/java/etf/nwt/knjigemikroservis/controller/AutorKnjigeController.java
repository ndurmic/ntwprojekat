package etf.nwt.knjigemikroservis.controller;


import etf.nwt.knjigemikroservis.model.AutorKnjige;
import etf.nwt.knjigemikroservis.service.AutorKnjigeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AutorKnjigeController {


    @Autowired
    private AutorKnjigeService autorKnjigeService;

    @RequestMapping("/autorKnjige")
    public List<AutorKnjige> listaSvihAutorKnjige (){
        return   autorKnjigeService.listaSvihAutorKnjige();
    }

    @RequestMapping("/autorKnjige/{id}")
    public Optional<AutorKnjige> dajAutorKnjigu (@PathVariable Integer id){
        return   autorKnjigeService.dajAutorKnjigu(id);
    }

    @RequestMapping(method= RequestMethod.POST, value="/autorKnjige")
    public void dodajAutorKnjigu(@RequestBody AutorKnjige autorKnjige) {
        autorKnjigeService.dodajAutorKnjigu(autorKnjige);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/autorKnjige/{id}")
    public void azurirajAutorKnjigu(@RequestBody AutorKnjige autorKnjige, @PathVariable Integer id) {
        autorKnjigeService.azurirajAutorKnjigu(autorKnjige, id);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/autorKnjige/{id}")
    public void obrisiAutorKnjigu (@PathVariable Integer id){
        autorKnjigeService.obrisiAutorKnjigu(id);
    }


}
