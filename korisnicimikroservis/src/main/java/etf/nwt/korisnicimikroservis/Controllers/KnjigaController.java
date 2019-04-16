package etf.nwt.korisnicimikroservis.Controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//import etf.nwt.knjigemikroservis.model.Knjiga;
import etf.nwt.korisnicimikroservis.Models.*;
import etf.nwt.korisnicimikroservis.Services.KnjigaService;

@RestController
public class KnjigaController {
    // knjige
    // knjige/id
    // dodajknjigu
	// azurirajknjigu
	// obrisiknjigu
    @Autowired
    private KnjigaService knjigaService;

    @Autowired
    private RestTemplate restTemplate;
    
    @RequestMapping("/knjige")
    public List<Knjiga> listaSvihKnjiga() {
        return (List<Knjiga>) knjigaService.findAll();
    }

    @RequestMapping("/knjige/{id}")
    public Optional<Knjiga> dajKnjigu(@PathVariable Integer id) {
        return knjigaService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/dodajknjigu")
    public String dodajKnjigu(@RequestBody Knjiga knjiga) {
        return knjigaService.addKnjiga(knjiga);
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = "/azuzirajknjigu/{id}")
    public String azurirajKnjigu(@RequestBody Knjiga knjiga, @PathVariable int id) {
    	return knjigaService.azurirajKnjigu(knjiga,id);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/obrisiknjigu/{id}")
    public String obrisiKnjigu (@PathVariable Integer id){
        return knjigaService.obrisiKnjigu(id);
    }
    // self test
    @RequestMapping("/sveknjige/{id}")
    public Knjiga sveKnjige(@PathVariable Integer id){
    	Knjiga knjiga = restTemplate.getForObject("http://korisnici-mikroservis/knjige/"+id,Knjiga.class);
    	return knjiga;
    }
    

}