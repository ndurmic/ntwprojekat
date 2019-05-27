package etf.nwt.zuulproxy.security;

import etf.nwt.zuulproxy.bean.auth.DBUserDetails;
import etf.nwt.zuulproxy.bean.auth.KorisnikModel;
import etf.nwt.zuulproxy.exception.CustomException;
import etf.nwt.zuulproxy.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService{
    @Autowired
    private KorisnikRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        KorisnikModel user = userRepository.findByEmail(email);
        if (user == null || user.getRola() == null || user.getRola().isEmpty()) {
            throw new CustomException("Invalid username or password.", HttpStatus.UNAUTHORIZED);
        }
        String [] authorities = new String[1];
        authorities[0] = "ROLE_"+user.getRola();

        DBUserDetails userDetails = new DBUserDetails(user.getEmail(),user.getPassword(),user.getActive(),
                user.isLoacked(), user.isExpired(),user.isEnabled(),authorities);
        return userDetails;
    }



}
