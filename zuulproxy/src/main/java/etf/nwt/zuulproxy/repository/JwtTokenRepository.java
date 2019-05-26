package etf.nwt.zuulproxy.repository;

import etf.nwt.zuulproxy.bean.auth.JwtToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JwtTokenRepository extends CrudRepository<JwtToken,Integer> {

    JwtToken findByToken (String token);

}
