package etf.nwt.knjigemikroservis.controller;

import etf.nwt.knjigemikroservis.model.Kategorija;
import etf.nwt.knjigemikroservis.model.Knjiga;
import etf.nwt.knjigemikroservis.model.Korisnik;
import etf.nwt.knjigemikroservis.model.Ocjena;
import etf.nwt.knjigemikroservis.service.KnjigaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.sql.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class KnjigaController {

    @Autowired
    private KnjigaService knjigaService;

    //Injecting our been
    @Autowired
    private RestTemplate restTemplate;

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

    @RequestMapping("/knjige/ocjene/{id}")
    public List<Ocjena> sveOcjeneKnjige (@PathVariable Integer id){

        Knjiga knjiga = restTemplate.getForObject("http://knjige-mikroservis/knjige/"+id,Knjiga.class);
        //Slicno ovo moze sveKnjigeAutora ili sviKomentari korisnika

        return knjigaService.sveOcjeneKnjige(knjiga);

    }


    /*@RequestMapping("/knjige/autori/{naziv}")
    public List<Optional<Knjiga>> knjigePoAutoru (@PathVariable String naziv){
        return   knjigaService.knjigePoAutoru(naziv);
    }*/

}
