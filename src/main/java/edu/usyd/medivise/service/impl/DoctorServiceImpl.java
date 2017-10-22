package edu.usyd.medivise.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.usyd.medivise.dao.DoctorDao;
import edu.usyd.medivise.domain.Doctor;
import edu.usyd.medivise.service.DoctorService;



@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorDao doctorDao;
	
	@Transactional
	public void add(Doctor doctor) {
		doctorDao.add(doctor);
		
	}

	@Transactional
	public void edit(Doctor doctor) {
		doctorDao.edit(doctor);
		
	}

	@Transactional
	public void delete(int id) {
		doctorDao.delete(id);
		
	}

	@Transactional
	public Doctor getDoctor(int id) {
		return doctorDao.getDoctor(id);
	}

	@Transactional
	public List<?> getAllDoctor() {
		return doctorDao.getAllDoctor(); 
	}

}
