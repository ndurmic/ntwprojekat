package etf.nwt.knjigemikroservis.repository;

import etf.nwt.knjigemikroservis.model.Autor;
import etf.nwt.knjigemikroservis.model.Knjiga;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface KnjigaRepository extends CrudRepository<Knjiga,Integer> {

    Optional<Knjiga> findByListaKnjigaContains(Autor autor);
}
