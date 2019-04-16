package com.example.kolekcijeservis.Repository;
import com.example.kolekcijeservis.Models.Knjiga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface KnjigaRepository extends CrudRepository<Knjiga, Integer> {
    List<Knjiga> findByidAutorKnjige(Integer idAutorKnjige);
}
