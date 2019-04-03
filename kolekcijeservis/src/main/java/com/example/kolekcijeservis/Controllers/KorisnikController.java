package com.example.kolekcijeservis.Controllers;

import com.example.kolekcijeservis.Models.Korisnik;
import com.example.kolekcijeservis.Repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class KorisnikController {
    @Autowired
    KorisnikRepository korisnikRepository;

    /**
     * Saves Korisnik in database
     * @param korisnik
     * @return Korisnik
     */
    @PostMapping("/korisnici")
    public Korisnik createKorisnik(@Valid @RequestBody Korisnik korisnik) {
        return korisnikRepository.save(korisnik);
    }

    /**
     * Returns all Korisniks
     * @return
     */
    @GetMapping("/korisnici")
    public List<Korisnik> getAllKorisnici() {
        return (List<Korisnik>) korisnikRepository.findAll();
    }

    /**
     *
     * @param korisnikId
     * @return Korisnik by id
     */
    @GetMapping("/korisnici/{id}")
    public Optional<Korisnik> getKorisnikById(@PathVariable(value = "id") int korisnikId) {
        return korisnikRepository.findById(korisnikId);
    }

    /**
     * Updates Korisnik by id
     * @param korisnikId
     * @param korisnikRequest
     * @return status
     */
    @PutMapping("/korisnici/{korisnikId}")
    public Optional<Korisnik> updateKorisnik(@PathVariable(value = "id") int korisnikId, @Valid @RequestBody Korisnik korisnikRequest) {
        return korisnikRepository.findById(korisnikId).map(korisnik -> {
            korisnik.setEmail(korisnikRequest.getEmail());
            korisnik.setIme(korisnikRequest.getIme());
            korisnik.setPrezime(korisnikRequest.getPrezime());
            korisnik.setUsername(korisnikRequest.getUsername());
            korisnik.setPassword(korisnikRequest.getPassword());
            korisnik.setRola(korisnikRequest.getRola());
            korisnik.setSlika(korisnikRequest.getSlika());


            return korisnikRepository.save(korisnik);
        });//.orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }

    /**
     * Deletes Korsnik by id
     * @param korisnikId
     * @return status
     */
    @DeleteMapping("/korisnici/{id}")
    public Optional<?> deleteKorisnik(@PathVariable(value = "id") int korisnikId) {
        return korisnikRepository.findById(korisnikId).map(korisnik -> {
            korisnikRepository.delete(korisnik);
            return ResponseEntity.ok().build();
        }); //.orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }
}