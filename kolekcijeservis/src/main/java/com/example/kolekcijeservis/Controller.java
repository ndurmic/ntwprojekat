package com.example.kolekcijeservis;


import com.example.kolekcijeservis.Models.Knjiga;
import com.example.kolekcijeservis.Repository.KnjigaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController
@RequestMapping
public class Controller {
    @Autowired
    KnjigaRepository knjigaRepository;

    @PostMapping("/knjige")
    public Knjiga createNote(@Valid @RequestBody Knjiga note) {
        return knjigaRepository.save(note);
    }
}
