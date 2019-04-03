package etf.nwt.knjigemikroservis.service;

import etf.nwt.knjigemikroservis.model.Kategorija;
import etf.nwt.knjigemikroservis.repository.KategorijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class KategorijaService {

    @Autowired
    private KategorijaRepository kategorijaRepository;

    public List<Kategorija> listaSvihKategorija(){
        List<Kategorija> kategorije = new ArrayList<>();
        kategorijaRepository.findAll().forEach(kategorije::add);
        return  kategorije;
    }

    //Optional for object/values which may be null
    public Optional<Kategorija> dajKategoriju(Integer id){
        return kategorijaRepository.findById(id); //tip parametra zavisi od tipa definisanog u repozitoriju
    }

    public void dodajKategoriju (Kategorija kategorija){
        kategorijaRepository.save(kategorija);
    }

    public void azurirajKategoriju (Kategorija kategorija, Integer id){
        //JPA prepozna ako nema objekta onda ce ga dodati, ako ima azurirat ce ga u zavisnosti od ID koji se nalazi u entitetu
        //Zbog toga nema potrebe za metodom update, save radi oboje
        kategorija.setId(id);
        kategorijaRepository.save(kategorija);
    }

    public void obrisiKategoriju(Integer id){
        kategorijaRepository.deleteById(id);
    }

}
