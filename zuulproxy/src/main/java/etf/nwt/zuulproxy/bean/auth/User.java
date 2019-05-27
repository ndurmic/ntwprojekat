package etf.nwt.zuulproxy.bean.auth;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	@Pattern(regexp = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$")
	@Column(name = "email", unique = true)
	private String email;
	@Pattern(regexp = "^[a-zA-Z0-9._-]{3,}$")
	@Column(name = "username")
	private String username;
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{7,20}$")
	@Column(name = "password")
	private String password;
	@Column(name="active")
	private Integer active;
	@Column(name="is_loacked")
    private boolean isLoacked;
	@Column(name="is_expired")
    private boolean isExpired;
	@Column(name="is_enabled")
    private boolean isEnabled;
    @Column(name = "rola")
    private String rola;


    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public String getRola() {
        return rola;
    }

    public void setRola(String rola) {
        this.rola = rola;
    }
    public boolean isLoacked() {
        return isLoacked;
    }

    public void setLoacked(boolean loacked) {
        isLoacked = loacked;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public void setExpired(boolean expired) {
        isExpired = expired;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

}
