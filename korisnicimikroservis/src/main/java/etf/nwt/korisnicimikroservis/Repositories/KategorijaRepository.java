package etf.nwt.korisnicimikroservis.Repositories;

import etf.nwt.korisnicimikroservis.Models.Kategorija;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface KategorijaRepository extends CrudRepository<Kategorija,Integer> {
    List<Kategorija> findByNaziv(String naziv);
}
