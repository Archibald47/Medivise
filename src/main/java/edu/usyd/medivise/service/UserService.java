package edu.usyd.medivise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.usyd.medivise.domain.User;
import utils.ValidationError;

import org.hibernate.SessionFactory;

@Service("UserService")
@Transactional
public class UserService {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private PasswordEncoder pswordEncoder;
	
	private void validateUser(String username, String password) throws ValidationError {
		if (exists(username)) {
			throw new ValidationError("Username already used.");
		}
		if (username == null || username.length() == 0) {
			throw new ValidationError("Empty username");
		}
		if (password == null || password.length() == 0) {
			throw new ValidationError("Empty password");
		}
	}
	
	public String createUser(String username, String password) throws ValidationError {
		validateUser(username, password);
		password = pswordEncoder.encode(password);
		return (String) this.sessionFactory.getCurrentSession().save(new User(username, password, User.roleUser));
	}

	public String createDoctor(String username, String password) throws ValidationError {
		validateUser(username, password);
		password = pswordEncoder.encode(password);
		return (String) this.sessionFactory.getCurrentSession().save(new User(username, password, User.roleDoctor));
	}

	public boolean exists(String username) {
		return getUserByUsername(username) != null;
	}
	
	public User getUserByUsername(String username) {
		return (User) this.sessionFactory.getCurrentSession().get(User.class, username);
	}
}
