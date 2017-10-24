package edu.usyd.medivise.web;

import java.security.Principal;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.usyd.medivise.domain.Answer;
import edu.usyd.medivise.domain.Question;
import edu.usyd.medivise.domain.User;
import edu.usyd.medivise.service.AnswerService;
import edu.usyd.medivise.service.QuestionService;
import edu.usyd.medivise.service.UserService;
import utils.ValidationError;

@Controller
@RequestMapping(value = "/message/")
public class MessageController {

	@Resource(name = "UserService")
	private UserService userService;

	@Resource(name = "AnswerService")
	private AnswerService answerService;
	
	@Resource(name = "QuestionService")
	private QuestionService qService;

	private static final Logger logger = LoggerFactory.getLogger(ForumController.class);

	@RequestMapping(value = "/doctors/", method = RequestMethod.GET)
	public String index(Model uiModel) {
		
		List<User> doctors = userService.getAllDoctors();

		uiModel.addAttribute("doctors", doctors);
		return "doctorlist";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String changePassword(HttpServletRequest req, Model uiModel, Principal principal) {

		if (principal != null) {

			User u = userService.getUserByUsername(principal.getName());
			uiModel.addAttribute("username", u.getUsername());

			String password = req.getParameter("password");
			String password2 = req.getParameter("password2");
			if (!password.equals(password2)) {
				return "redirect:../profile/";
			}

			try {
				this.userService.changePassword(u, password2);
				return "redirect:..";
			} catch (ValidationError e) {
				return "redirect:../profile/";
			}

		}
		// else not logged in
		return "redirect:..";

	}
}
