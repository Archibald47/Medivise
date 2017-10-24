package edu.usyd.medivise.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.usyd.medivise.domain.Appointment;
import edu.usyd.medivise.domain.Comment;
import edu.usyd.medivise.domain.User;
import utils.ValidationError;

@Service(value = "AppointmentService")
@Transactional
public class AppointmentServiceProvider implements AppointmentService {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public long addAppointment(User user, String cat, String Availiabililty) throws ValidationError {
		if (cat != null && cat.length() > 0 && Availiabililty != null && Availiabililty.length() > 0) {
			return (long) this.sessionFactory.getCurrentSession().save(new Appointment(user, cat, Availiabililty));
		} else {
			throw new ValidationError("Comment title and content cannot be empty.");
		}
	}

	@Override
	public List<Appointment> getAll() {
		return this.sessionFactory.getCurrentSession().createCriteria(Appointment.class).list();
	}

}
