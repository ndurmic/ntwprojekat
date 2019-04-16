package etf.nwt.knjigemikroservis.controller;

import etf.nwt.knjigemikroservis.amqpProducer.KategorijaSender;
import etf.nwt.knjigemikroservis.model.Kategorija;
import etf.nwt.knjigemikroservis.service.KategorijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class KategorijaController {

    @Autowired
    private KategorijaService kategorijaService;
    
    @Autowired
    private KategorijaSender kategorijaSender;

    @RequestMapping("/kategorije")
    public List<Kategorija> listaSvihKategorija (){
        return   kategorijaService.listaSvihKategorija();
    }

    @RequestMapping("/kategorije/{id}")
    public Optional<Kategorija> dajKategoriju (@PathVariable Integer id){
        return   kategorijaService.dajKategoriju(id);
    }

    @RequestMapping(method= RequestMethod.POST, value="/kategorije")
    public void dodajKategoriju(@RequestBody @Valid Kategorija kategorija, Errors errors) {

        if(errors.hasErrors()){
            System.out.println(errors.getAllErrors());
        }
        else{
            kategorijaService.dodajKategoriju(kategorija);
            kategorijaSender.dodajKategoriju(kategorija);
        }

    }

    @RequestMapping(method=RequestMethod.PUT, value="/kategorije/{id}")
    public void azurirajKategoriju(@RequestBody @Valid Kategorija kategorija, @PathVariable Integer id, Errors errors) {

        if(errors.hasErrors()){
            System.out.println(errors.getAllErrors());
        }
        else{
            kategorijaService.azurirajKategoriju(kategorija, id);
            kategorijaSender.azurirajKategoriju(kategorija, id);
        }

    }

    @RequestMapping(method=RequestMethod.DELETE, value="/kategorije/{id}")
    public void obrisiKategoriju (@PathVariable Integer id){
        kategorijaService.obrisiKategoriju(id);
        kategorijaSender.obrisiKategoriju(id);
    }


}
