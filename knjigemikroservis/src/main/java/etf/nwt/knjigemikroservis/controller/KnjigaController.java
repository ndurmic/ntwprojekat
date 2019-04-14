package etf.nwt.knjigemikroservis.controller;

import etf.nwt.knjigemikroservis.model.KategorijeKnjige;
import etf.nwt.knjigemikroservis.model.Knjiga;
import etf.nwt.knjigemikroservis.model.Ocjena;
import etf.nwt.knjigemikroservis.service.KnjigaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.ArrayList;
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

    //Lista svih knjiga iz odredjene kategorije
    @RequestMapping("/knjige/kategorije/{idKategorije}")
    public  List<Optional<Knjiga>> knjigePoKategoriji (@PathVariable Integer idKategorije){
        return   knjigaService.knjigePoKategoriji(idKategorije);
    }

    //Lista svih ocjena
    @RequestMapping("/knjige/ocjene")
    public List<Ocjena> sveOcjene (){

        ResponseEntity<List<Ocjena>> response = restTemplate.exchange(
                "http://korisnici-mikroservis/ocjene",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Ocjena>>(){});
        List<Ocjena> ocjene = response.getBody();

        return ocjene;

    }

    //Sve ocjene jedne knjige
   @RequestMapping("/knjige/{id}/ocjene")
    public List<Ocjena> sveOcjeneKnjige (@PathVariable Integer id){

       //LISTA OBJEKATA KORISTECI REST TEMPLATE
       ResponseEntity<List<Ocjena>> response = restTemplate.exchange(
               "http://korisnici-mikroservis/ocjene",
               HttpMethod.GET,
               null,
               new ParameterizedTypeReference<List<Ocjena>>(){});
       List<Ocjena> ocjene = response.getBody();
       List<Ocjena> ocjeneKnjige = new ArrayList<>();

       for(int i=0;i<ocjene.size();i++)
       {
           if(ocjene.get(i).getKnjiga().getId() == id){
               ocjeneKnjige.add(ocjene.get(i));
           }
       }

        return ocjeneKnjige;

    }




}
