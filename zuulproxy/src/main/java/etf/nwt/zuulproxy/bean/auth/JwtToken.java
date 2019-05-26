package etf.nwt.zuulproxy.bean.auth;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class JwtToken {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    private String token;

    public JwtToken(String token) {
        this.token = token;
    }

    public JwtToken() {
    }

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
