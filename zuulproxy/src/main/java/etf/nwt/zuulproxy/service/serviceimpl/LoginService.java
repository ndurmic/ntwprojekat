package etf.nwt.zuulproxy.service.serviceimpl;

import etf.nwt.zuulproxy.bean.auth.JwtToken;
import etf.nwt.zuulproxy.bean.auth.KorisnikModel;
import etf.nwt.zuulproxy.exception.CustomException;
import etf.nwt.zuulproxy.repository.JwtTokenRepository;
import etf.nwt.zuulproxy.repository.KorisnikRepository;
import etf.nwt.zuulproxy.security.JwtTokenProvider;
import etf.nwt.zuulproxy.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class LoginService implements ILoginService
{
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private KorisnikRepository userRepository;
    @Autowired
    private JwtTokenRepository jwtTokenRepository;

    @Override
    public String login(String username, String password) {
        try {
            //authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,
              //      password));
        	
            KorisnikModel user = userRepository.findByEmail(username);
            
            
            if (user == null || user.getRola() == null || user.getRola().isEmpty()) {
            	if(user==null)
                throw new CustomException("Invalid username or password - user null.", HttpStatus.UNAUTHORIZED);
            	if(user.getRola() == null)
            	throw new CustomException("Invalid username or password - rola null.", HttpStatus.UNAUTHORIZED);
            	if(user.getRola().isEmpty())
                	throw new CustomException("Invalid username or password - rola prazna.", HttpStatus.UNAUTHORIZED);
            }

            //NOTE: normally we dont need to add "ROLE_" prefix. Spring does automatically for us.
            //Since we are using custom token using JWT we should add ROLE_ prefix
            //String token =  jwtTokenProvider.createToken(username, "rolaa");
            String token =  jwtTokenProvider.createToken(username, user.getRola());
            return token;

        } catch (AuthenticationException e) {
            throw new CustomException("Invalid username or password.", HttpStatus.UNAUTHORIZED);
        }
    }

    @Override
    public KorisnikModel saveUser(KorisnikModel user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()) );
        return userRepository.save(user);
    }

    @Override
    public boolean logout(String token) {
         jwtTokenRepository.delete(new JwtToken(token));
         return true;
    }

    @Override
    public Boolean isValidToken(String token) {
        return jwtTokenProvider.validateToken(token);
    }

    @Override
    public String createNewToken(String token) {
        String username = jwtTokenProvider.getUsername(token);
        String roleList = jwtTokenProvider.getRoleList(token);
        String newToken =  jwtTokenProvider.createToken(username,roleList);
        return newToken;
    }


}
