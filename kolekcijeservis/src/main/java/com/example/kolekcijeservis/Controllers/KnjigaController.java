package com.example.kolekcijeservis.Controllers;


import com.example.kolekcijeservis.Models.Knjiga;
import com.example.kolekcijeservis.Repository.KnjigaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping
public class KnjigaController {
    @Autowired
    KnjigaRepository knjigaRepository;

    /**
     * Saves Knjiga in database
     * @param knjiga
     * @return Knjiga
     */

    @PostMapping("/knjige")
    public Knjiga createKnjiga(@Valid @RequestBody Knjiga knjiga) {
        return knjigaRepository.save(knjiga);
    }

    /**
     *
     * @return List of all Knjigas
     */
    @GetMapping("/knjige")
    public List<Knjiga> getAllKnjige() {
        return (List<Knjiga>) knjigaRepository.findAll();
    }

    /**
     *
     * @param knjigaId
     * @return Knjiga by id
     */
    @GetMapping("/knjige/{id}")
    public Optional<Knjiga> getKnjigaById(@PathVariable(value = "id") int knjigaId) {
        return knjigaRepository.findById(knjigaId);
    }

    /**
     * Updates Knjiga
     * @param knjigaId
     * @param knjigaRequest
     * @return status
     */
    @PutMapping("/knjige/{knjigaId}")
    public Optional<Knjiga> updatePost(@PathVariable(value = "id") int knjigaId, @Valid @RequestBody Knjiga knjigaRequest) {
        return knjigaRepository.findById(knjigaId).map(knjiga -> {
            knjiga.setDatumIzdavanja(knjigaRequest.getDatumIzdavanja());
            knjiga.setNaslov(knjigaRequest.getNaslov());
            knjiga.setOpis(knjigaRequest.getOpis());

            return knjigaRepository.save(knjiga);
        });//.orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }

    /**
     * Deletes Knjiga by id
     * @param knjigaId
     * @return status
     */
    @DeleteMapping("/knjige/{id}")
    public Optional<?> deleteKnjiga(@PathVariable(value = "id") int knjigaId) {
        return knjigaRepository.findById(knjigaId).map(knjiga -> {
            knjigaRepository.delete(knjiga);
            return ResponseEntity.ok().build();
        }); //.orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }
}
