package com.example.kolekcijeservis.Controllers;


import com.example.kolekcijeservis.Models.Knjiga;
import com.example.kolekcijeservis.Repository.KnjigaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
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
    public Optional<Knjiga> updatePost(@PathVariable(value = "knjigaId") int knjigaId, @Valid @RequestBody Knjiga knjigaRequest) {
        return knjigaRepository.findById(knjigaId).map(knjiga -> {
            knjiga.setDatumIzdavanja(knjigaRequest.getDatumIzdavanja());
            knjiga.setNaslov(knjigaRequest.getNaslov());
            knjiga.setOpis(knjigaRequest.getOpis());
            knjiga.setId_autorKnjige(knjigaRequest.getId_autorKnjige());
            knjiga.setId_kategorije(knjigaRequest.getId_kategorije());

            return knjigaRepository.save(knjiga);
        });
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

    @PostMapping("/knjigePoslijeDatuma")
    public List<Optional<Knjiga>> knjigePoslijeDatuma(@RequestBody Date datum){
        List<Knjiga> sveKnjige = new ArrayList<>();
        List<Optional<Knjiga>> knjige = new ArrayList<>();
        knjigaRepository.findAll().forEach(sveKnjige::add);

        for(int i=0;i<sveKnjige.size();i++)
        {
            if(sveKnjige.get(i).getDatumIzdavanja().after(datum))
                knjige.add(Optional.ofNullable(sveKnjige.get(i)));
        }
        return  knjige;
    }
}
