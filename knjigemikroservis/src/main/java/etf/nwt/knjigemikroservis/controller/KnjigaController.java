package etf.nwt.knjigemikroservis.controller;

import etf.nwt.knjigemikroservis.model.Kategorija;
import etf.nwt.knjigemikroservis.model.Knjiga;
import etf.nwt.knjigemikroservis.service.KnjigaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public void dodajKnjigu(@RequestBody @Valid Knjiga knjiga, Errors errors) {
        if(errors.hasErrors()){
            System.out.println(errors.getAllErrors());
        }
        else{
            knjigaService.dodajKnjigu(knjiga);
        }
    }

    @RequestMapping(method=RequestMethod.PUT, value="/knjige/{id}")
    public void azurirajKnjigu(@RequestBody @Valid Knjiga knjiga, @PathVariable Integer id, Errors errors) {
        if(errors.hasErrors()){
            System.out.println(errors.getAllErrors());
        }
        else{
            knjigaService.azurirajKnjigu(knjiga, id);
        }
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/knjige/{id}")
    public void obrisiKnjigu (@PathVariable Integer id){
        knjigaService.obrisiKnjigu(id);
    }

    @RequestMapping("/knjige/kategorije/{naziv}")
    public List<Optional<Knjiga>> knjigePoKategoriji (@PathVariable String naziv){
        return   knjigaService.knjigePoKategoriji(naziv);
    }

    /*@RequestMapping("/knjige/autori/{naziv}")
    public List<Optional<Knjiga>> knjigePoAutoru (@PathVariable String naziv){
        return   knjigaService.knjigePoAutoru(naziv);
    }*/

}
