package etf.nwt.knjigemikroservis.service;

import etf.nwt.knjigemikroservis.model.AutorKnjige;
import etf.nwt.knjigemikroservis.repository.AutorKnjigeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AutorKnjigeService {

    @Autowired
    private AutorKnjigeRepository autorKnjigeRepository;

    public List<AutorKnjige> listaSvihAutorKnjige(){
        List<AutorKnjige> autorKnjige = new ArrayList<>();
        autorKnjigeRepository.findAll().forEach(autorKnjige::add);
        return  autorKnjige;
    }

    //Optional for object/values which may be null
    public Optional<AutorKnjige> dajAutorKnjigu(Integer id){
        return autorKnjigeRepository.findById(id); //tip parametra zavisi od tipa definisanog u repozitoriju
    }

    public void dodajAutorKnjigu (AutorKnjige autorKnjige){
        autorKnjigeRepository.save(autorKnjige);
    }

    public void azurirajAutorKnjigu (AutorKnjige autorKnjige, Integer id){
        //JPA prepozna ako nema objekta onda ce ga dodati, ako ima azurirat ce ga u zavisnosti od ID koji se nalazi u entitetu
        //Zbog toga nema potrebe za metodom update, save radi oboje
        autorKnjigeRepository.save(autorKnjige);
    }

    public void obrisiAutorKnjigu(Integer id){
        autorKnjigeRepository.deleteById(id);
    }


}
