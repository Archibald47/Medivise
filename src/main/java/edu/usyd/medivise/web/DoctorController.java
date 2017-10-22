package edu.usyd.medivise.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.usyd.medivise.domain.Doctor;
import edu.usyd.medivise.service.DoctorService;



@Controller()
@RequestMapping("/doctor")
public class DoctorController {
	@Autowired
	private DoctorService doctorService;
	
	@RequestMapping("")
	public String setupForm(Map<String, Object> map){
		Doctor doctor = new Doctor();
		map.put("doctor", doctor);
		map.put("doctorList", doctorService.getAllDoctor());
		return "doctor" ;
	} 
	
	@RequestMapping(value="/doctor.do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute Doctor doctor, BindingResult result, @RequestParam String action, Map<String, Object> map){
		Doctor doctorResult = new Doctor();
		switch(action.toLowerCase()){	//only in Java7 you can put String in switch
		case "add":
			doctorService.add(doctor);
			doctorResult = doctor;
			break;
		case "edit":
			doctorService.edit(doctor);
			doctorResult = doctor;
			break;
		case "delete":
			doctorService.delete(doctor.getId());
			doctorResult = new Doctor();
			break;
		case "search":
			Doctor searchedDoctor = doctorService.getDoctor(doctor.getId());
			doctorResult = searchedDoctor!=null ? searchedDoctor : new Doctor();
			break;
		}
		map.put("doctor", doctorResult);
		map.put("doctorList", doctorService.getAllDoctor());
		return "doctor";
	}
}
