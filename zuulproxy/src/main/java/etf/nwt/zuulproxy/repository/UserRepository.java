package etf.nwt.zuulproxy.repository;

import etf.nwt.zuulproxy.bean.auth.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    User findByEmail(String email);
}
