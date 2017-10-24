package edu.usyd.medivise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.usyd.medivise.domain.Comment;
import edu.usyd.medivise.domain.User;
import utils.ValidationError;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

@Service("UserService")
@Transactional
public class UserService {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private PasswordEncoder pswordEncoder;
	
	private void validateUser(String username, String password) throws ValidationError {
		if (username == null || username.length() == 0) {
			throw new ValidationError("Empty username");
		}
		if (password == null || password.length() == 0) {
			throw new ValidationError("Empty password");
		}
		if (exists(username)) {
			throw new ValidationError("Username already used.");
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
	
	public void changePassword(User user, String password) throws ValidationError{
		if (password == null || password.length() == 0) {
			throw new ValidationError("Empty password");
		}
		password = pswordEncoder.encode(password);
		user.setPassword(password);
		this.sessionFactory.getCurrentSession().update(user);
	}
	
	public boolean exists(String username) {
		return getUserByUsername(username) != null;
	}
	
	public User getUserByUsername(String username) {
		return (User) this.sessionFactory.getCurrentSession().get(User.class, username);
	}

	public List<User> getAllDoctors() {
		return this.sessionFactory.getCurrentSession().createCriteria(User.class)
				.add(Restrictions.eq("authority", User.roleDoctor)).list();
	}
}
