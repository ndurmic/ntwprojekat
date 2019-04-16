package com.example.kolekcijeservis.Repository;


import com.example.kolekcijeservis.Models.Knjiga;
import com.example.kolekcijeservis.Models.KnjigaKolekcija;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KnjigaKolekcijaRepository extends CrudRepository<KnjigaKolekcija, Integer> {
    List<KnjigaKolekcija> findByKnjiga_Id(Integer Knjige_Id);
}