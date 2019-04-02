package etf.nwt.knjigemikroservis.controller;


import etf.nwt.knjigemikroservis.model.Autor;
import etf.nwt.knjigemikroservis.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AutorController {

    @Autowired
    private AutorService autorService;

    @RequestMapping("/autori")
    public List<Autor> listaSvihAutora (){
        return   autorService.listaSvihAutora();
    }

    @RequestMapping("/autor/{id}")
    public Optional<Autor> dajAutora (@PathVariable Integer id){
        return   autorService.dajAutora(id);
    }

    @RequestMapping(method= RequestMethod.POST, value="/autori")
    public void dodajAutora(@RequestBody Autor autor) {
        autorService.dodajAutora(autor);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/autori/{id}")
    public void azurirajAutora(@RequestBody Autor autor, @PathVariable Integer id) {
        autorService.azurirajAutora(autor, id);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/autori/{id}")
    public void obrisiAutora (@PathVariable Integer id){
        autorService.obrisiAutora(id);
    }


}
