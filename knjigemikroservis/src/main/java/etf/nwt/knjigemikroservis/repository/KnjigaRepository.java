package etf.nwt.knjigemikroservis.repository;

import etf.nwt.knjigemikroservis.model.Kategorija;
import etf.nwt.knjigemikroservis.model.Knjiga;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface KnjigaRepository extends CrudRepository<Knjiga,Integer> {

}
