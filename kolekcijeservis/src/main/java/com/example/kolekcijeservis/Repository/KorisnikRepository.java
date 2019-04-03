package com.example.kolekcijeservis.Repository;


import com.example.kolekcijeservis.Models.Korisnik;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KorisnikRepository extends CrudRepository<Korisnik, Integer> {
}
