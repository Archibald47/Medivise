package edu.usyd.medivise.dao;

import java.util.List;

import edu.usyd.medivise.domain.Doctor;


public interface DoctorDao {
	public void add(Doctor doctor);
	public void edit(Doctor doctor);
	public void delete(int id);
	public Doctor getDoctor(int id);
	public List<?> getAllDoctor();

}
 