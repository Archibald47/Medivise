 package edu.usyd.medivise.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.usyd.medivise.dao.DoctorDao;
import edu.usyd.medivise.domain.Doctor;


// create DAO components
@Repository
public class DoctorDaoImpl implements DoctorDao {
	@Autowired
	private SessionFactory session;
	
	public void add(Doctor doctor) {
		session.getCurrentSession().save(doctor);
	}

	@Override
	public void edit(Doctor doctor) {
		session.getCurrentSession().update(doctor);
	}

	@Override
	public void delete(int id) {		
		session.getCurrentSession().delete(getDoctor(id));
	}

	@Override
	public Doctor getDoctor(int id) {
		return (Doctor)session.getCurrentSession().get(Doctor.class, id);
	}

	@Override
	public List<?> getAllDoctor() {
		return session.getCurrentSession().createQuery("from Doctor").list();
	}
}
