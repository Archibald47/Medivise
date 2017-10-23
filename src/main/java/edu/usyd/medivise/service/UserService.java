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
	
	public String create(String username, String password) throws ValidationError {
		if (username != null && username.length() > 0) {
			password = pswordEncoder.encode(password);
			return (String) this.sessionFactory.getCurrentSession().save(new User(username, password));
		} else {
			throw new ValidationError("Empty username");
		}
	}

	public boolean exists(String username) {
		return getUserByUsername(username) != null;
	}
	
	public User getUserByUsername(String username) {
		return (User) this.sessionFactory.getCurrentSession().get(User.class, username);
	}
}
