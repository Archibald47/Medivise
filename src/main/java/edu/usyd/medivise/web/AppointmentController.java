package edu.usyd.medivise.web;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.usyd.medivise.domain.Appointment;
import edu.usyd.medivise.domain.User;
import edu.usyd.medivise.service.AppointmentService;
import edu.usyd.medivise.service.QuestionService;
import edu.usyd.medivise.service.UserService;
import utils.ValidationError;

@Controller()
@RequestMapping("/appointment/")
public class AppointmentController {

	private static final Logger logger = LoggerFactory.getLogger(ForumController.class);

	@Resource(name = "AppointmentService")
	private AppointmentService appService;

	@Resource(name = "UserService")
	private UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model uiModel, Principal principal) {
		
		if (principal != null) {
			User u = userService.getUserByUsername(principal.getName());
			uiModel.addAttribute("username", principal.getName());
			logger.info(u.getAuthority());
			logger.info(User.roleDoctor);
			if (u.getAuthority().equals(User.roleDoctor)) {
				uiModel.addAttribute("isDoctor", "true");
			}
		}
		List<Appointment> apps = appService.getAll();
		uiModel.addAttribute("appointments", apps);

		return "appointment";
	}

	@RequestMapping(value = "/add/", method = RequestMethod.POST)
	public String addAvailability(Model uiModel, HttpServletRequest req, Principal principal) {
		String category = req.getParameter("category");
		String avail = req.getParameter("availability");
		if (principal != null) {
			User u = userService.getUserByUsername(principal.getName());
			try {
				appService.addAppointment(u, category, avail);
			} catch (ValidationError e) {
				logger.info(e.toString());
			}
		}
		return "redirect:..";
	}

}
