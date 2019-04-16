package etf.nwt.knjigemikroservis.controller;


import etf.nwt.knjigemikroservis.amqpProducer.AutorSender;
import etf.nwt.knjigemikroservis.model.Autor;
import etf.nwt.knjigemikroservis.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class AutorController {

    @Autowired
    private AutorService autorService;
    
    @Autowired
    private AutorSender autorSender;

    @RequestMapping("/autori")
    public List<Autor> listaSvihAutora (){
        return   autorService.listaSvihAutora();
    }

    @RequestMapping("/autori/{id}")
    public Optional<Autor> dajAutora (@PathVariable Integer id){
        return   autorService.dajAutora(id);
    }

    @RequestMapping(method= RequestMethod.POST, value="/autori")
    public Autor dodajAutora(@RequestBody @Valid Autor autor, Errors errors) {

        if(errors.hasErrors()){
            System.out.println(errors.getAllErrors());
        }

        autorSender.dodajAutora(autor);
        return autorService.dodajAutora(autor);

    }

    @RequestMapping(method=RequestMethod.PUT, value="/autori/{id}")
    public Autor azurirajAutora(@RequestBody @Valid Autor autor, @PathVariable Integer id, Errors errors) {

        if(errors.hasErrors()){
            System.out.println(errors.getAllErrors());
        }

        autorSender.azurirajAutora(autor, id);

        return autorService.azurirajAutora(autor, id);


    }

    @RequestMapping(method=RequestMethod.DELETE, value="/autori/{id}")
    public String obrisiAutora (@PathVariable Integer id){

        autorSender.obrisiAutora(id);

        return autorService.obrisiAutora(id);
    }


}
