package com.example.kolekcijeservis.Repository;


import com.example.kolekcijeservis.Models.KnjigaKolekcija;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KnjigaKolekcijaRepository extends CrudRepository<KnjigaKolekcija, Integer> {
}