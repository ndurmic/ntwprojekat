package com.example.kolekcijeservis.Repository;

import com.example.kolekcijeservis.Models.Kolekcija;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KolekcijaRepository extends CrudRepository<Kolekcija, Integer> {
}
