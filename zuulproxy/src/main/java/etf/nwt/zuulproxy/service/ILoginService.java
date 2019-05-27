package etf.nwt.zuulproxy.service;

import etf.nwt.zuulproxy.bean.auth.KorisnikModel;

public interface ILoginService {
    String login(String username, String password);
    KorisnikModel saveUser(KorisnikModel user);

    boolean logout(String token);

    Boolean isValidToken(String token);

    String createNewToken(String token);
}
