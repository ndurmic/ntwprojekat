package etf.nwt.korisnicimikroservis.Repositories;

import etf.nwt.korisnicimikroservis.Models.Autor;
//import etf.nwt.knjigemikroservis.model.Kategorija;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AutorRepository extends CrudRepository<Autor,Integer> {

    List<Autor> findByIme(String naziv);

}
