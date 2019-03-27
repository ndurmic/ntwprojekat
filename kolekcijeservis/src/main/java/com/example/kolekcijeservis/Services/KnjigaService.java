package com.example.kolekcijeservis.Services;

import com.example.kolekcijeservis.Models.Knjiga;
import com.example.kolekcijeservis.Repository.KnjigaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KnjigaService {
    @Autowired
    private KnjigaRepository knjigaRepository;

    public void insertKnjiga(Knjiga knjiga){
        knjigaRepository.save(knjiga);
    }
}
