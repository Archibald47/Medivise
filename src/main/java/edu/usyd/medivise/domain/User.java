package edu.usyd.medivise.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "User")
public class User implements Serializable {

	private static final long serialVersionUID = 4187001708855857967L;

	@Id
	@NotBlank
	@Column(name = "username", nullable = false)
	private String username;

	@NotBlank
	@Column(name = "password")
	private String password;

	@Column(name = "enabled", nullable = false)
	private boolean enabled = true;

	@Column(name = "authority")
	private String authority;

	public User() {
	}
	
	public User(String username, String password) {
		this(username, password, true, "ROLE_USER");
	}

	public User(String username, String password, boolean enabled, String authority) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.authority = authority;
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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
