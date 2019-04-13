package etf.nwt.knjigemikroservis.service;

//Creating a  Spring business service

import etf.nwt.knjigemikroservis.model.*;
import etf.nwt.knjigemikroservis.repository.AutorRepository;
import etf.nwt.knjigemikroservis.repository.KategorijaRepository;
import etf.nwt.knjigemikroservis.repository.KnjigaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

@Service
public class KnjigaService {

        @Autowired
        private KnjigaRepository knjigaRepository;
        @Autowired
        private KategorijaRepository kategorijaRepository;
        @Autowired
        private AutorRepository autorRepository;

        public List<Knjiga> listaSvihKnjiga(){
            List<Knjiga> knjige = new ArrayList<>();
            knjigaRepository.findAll().forEach(knjige::add);
            return  knjige;
        }

        //Optional for object/values which may be null
        public Optional<Knjiga> dajKnjigu(Integer id){
           return knjigaRepository.findById(id); //tip parametra zavisi od tipa definisanog u repozitoriju
        }

        public void dodajKnjigu (Knjiga knjiga){
            knjigaRepository.save(knjiga);
        }

        public void azurirajKnjigu (Knjiga knjiga, Integer id){
            //JPA prepozna ako nema objekta onda ce ga dodati, ako ima azurirat ce ga u zavisnosti od ID koji se nalazi u entitetu
            //Zbog toga nema potrebe za metodom update, save radi oboje
            knjiga.setId(id);
            knjigaRepository.save(knjiga);
        }

        public void obrisiKnjigu(Integer id){
            knjigaRepository.deleteById(id);
        }

        public List<Optional<Knjiga>> knjigePoKategoriji(String naziv){
            List<Optional<Knjiga>> knjige = new ArrayList<>();
            List<Kategorija> listaKategorija = new ArrayList<>();
            kategorijaRepository.findByNaziv(naziv).forEach(listaKategorija::add);

            for(int i=0;i<listaKategorija.size();i++)
            {
               // knjige.add(knjigaRepository.findById(listaKategorija.get(i)));
            }
            return  knjige;
        }


        //Najpopularnije ocjene - u korisnicima

        //Najapopularniji autori u kolekcijama

        //Najpopularnije knjige u kolekcijama

}
