package com.example.kolekcijeservis.Controllers;

import com.example.kolekcijeservis.Models.Kolekcija;
import com.example.kolekcijeservis.Models.Kolekcija;
import com.example.kolekcijeservis.Repository.KolekcijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class KolekcijaController {
    @Autowired
    KolekcijaRepository kolekcijaRepository;

    /**
     * Saves Kolekcija in database
     * @param kolekcija
     * @return Kolekcija
     */
    @PostMapping("/kolekcije")
    public Kolekcija createKoekcija(@Valid @RequestBody Kolekcija kolekcija) {
        return kolekcijaRepository.save(kolekcija);
    }

    /**
     *
     * @return List of all Kolekcijas
     */
    @GetMapping("/kolekcije")
    public List<Kolekcija> getAllKolekcije() {
        return (List<Kolekcija>) kolekcijaRepository.findAll();
    }


    /**
     *
     * @param kolekcijaId
     * @return Kolekcija by id
     */
    @GetMapping("/kolekcije/{id}")
    public Optional<Kolekcija> getKolekcijaById(@PathVariable(value = "id") int kolekcijaId) {
        return kolekcijaRepository.findById(kolekcijaId);
    }

    /**
     * Updates Kolekcija by id
     * @param kolekcijaId
     * @param kolekcijaRequest
     * @return status
     */
    @PutMapping("/kolekcije/{kolekcijaId}")
    public Optional<Kolekcija> updatePost(@PathVariable(value = "id") int kolekcijaId, @Valid @RequestBody Kolekcija kolekcijaRequest) {
        return kolekcijaRepository.findById(kolekcijaId).map(kolekcija -> {
            kolekcija.setKolekcijaVidljiva(kolekcijaRequest.getKolekcijaVidljiva());
            kolekcija.setNaziv(kolekcijaRequest.getNaziv());
            kolekcija.setOpis(kolekcijaRequest.getOpis());
            kolekcija.setKorisnik(kolekcijaRequest.getKorisnik());


            return kolekcijaRepository.save(kolekcija);
        });//.orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }

    /**
     * Deletes kolekcija by id
     * @param kolekcijaId
     * @return
     */
    @DeleteMapping("/kolekcije/{id}")
    public Optional<?> deleteKolekcija(@PathVariable(value = "id") int kolekcijaId) {
        return kolekcijaRepository.findById(kolekcijaId).map(kolekcija -> {
            kolekcijaRepository.delete(kolekcija);
            return ResponseEntity.ok().build();
        }); //.orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }
}