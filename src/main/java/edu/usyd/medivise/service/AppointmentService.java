package edu.usyd.medivise.service;

import java.util.List;

import edu.usyd.medivise.domain.Appointment;
import edu.usyd.medivise.domain.User;
import utils.ValidationError;

public interface AppointmentService {
	public long addAppointment(User user, String category, String Availiabililty) throws ValidationError;
	public List<Appointment> getAll();
}
