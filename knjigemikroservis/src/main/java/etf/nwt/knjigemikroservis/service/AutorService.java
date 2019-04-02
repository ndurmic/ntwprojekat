package etf.nwt.knjigemikroservis.service;

import etf.nwt.knjigemikroservis.model.Autor;
import etf.nwt.knjigemikroservis.model.Knjiga;
import etf.nwt.knjigemikroservis.repository.AutorRepository;
import etf.nwt.knjigemikroservis.repository.KnjigaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> listaSvihAutora(){
        List<Autor> autori = new ArrayList<>();
        autorRepository.findAll().forEach(autori::add);
        return  autori;
    }

    //Optional for object/values which may be null
    public Optional<Autor> dajAutora(Integer id){
        return autorRepository.findById(id); //tip parametra zavisi od tipa definisanog u repozitoriju
    }

    public void dodajAutora (Autor autor){
        autorRepository.save(autor);
    }

    public void azurirajAutora (Autor autor, Integer id){
        //JPA prepozna ako nema objekta onda ce ga dodati, ako ima azurirat ce ga u zavisnosti od ID koji se nalazi u entitetu
        //Zbog toga nema potrebe za metodom update, save radi oboje
        autorRepository.save(autor);
    }

    public void obrisiAutora(Integer id){
        autorRepository.deleteById(id);
    }


}
