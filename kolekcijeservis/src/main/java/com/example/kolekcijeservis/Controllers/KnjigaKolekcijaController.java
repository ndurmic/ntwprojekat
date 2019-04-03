package com.example.kolekcijeservis.Controllers;


import com.example.kolekcijeservis.Models.KnjigaKolekcija;
import com.example.kolekcijeservis.Repository.KnjigaKolekcijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class KnjigaKolekcijaController {
    @Autowired
    KnjigaKolekcijaRepository knjigaKolekcijaRepository;

    /**
     * Saves KnjigaKolekcija in database
     * @param knjigaKolekcija
     * @return status
     */
    @PostMapping("/knjigaKolekcije")
    public KnjigaKolekcija createKnjigaKolekcija(@Valid @RequestBody KnjigaKolekcija knjigaKolekcija) {
        return knjigaKolekcijaRepository.save(knjigaKolekcija);
    }

    /**
     *
     * @return List of KnjigaKolekcija
     */
    @GetMapping("/knjigaKolekcije")
    public List<KnjigaKolekcija> getAllKnjigaKolekcije() {
        return (List<KnjigaKolekcija>) knjigaKolekcijaRepository.findAll();
    }

    /**
     *
     * @param knjigaKolekcijaId
     * @return KnjigaKolekcija by id
     */
    @GetMapping("/knjigaKolekcije/{id}")
    public Optional<KnjigaKolekcija> getKnjigaKolekcijaById(@PathVariable(value = "id") int knjigaKolekcijaId) {
        return knjigaKolekcijaRepository.findById(knjigaKolekcijaId);
    }


    /**
     * Deletes KnjigaKolekcija by id
     * @param knjigaKolekcijaId
     * @return status
     */
    @DeleteMapping("/knjigaKolekcije/{id}")
    public Optional<?> deleteKnjigaKolekcija(@PathVariable(value = "id") int knjigaKolekcijaId) {
        return knjigaKolekcijaRepository.findById(knjigaKolekcijaId).map(knjigaKolekcija -> {
            knjigaKolekcijaRepository.delete(knjigaKolekcija);
            return ResponseEntity.ok().build();
        }); //.orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }
}
