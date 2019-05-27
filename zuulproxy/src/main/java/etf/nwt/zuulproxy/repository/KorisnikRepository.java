package etf.nwt.zuulproxy.repository;

import etf.nwt.zuulproxy.bean.auth.KorisnikModel;
import etf.nwt.zuulproxy.bean.auth.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KorisnikRepository extends CrudRepository<KorisnikModel,Integer> {
    KorisnikModel findByEmail(String email);
}
