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
@RequestMapping(value = "/profile/")
public class ProfileController {

	@Resource(name = "UserService")
	private UserService userService;

	@Resource(name = "AnswerService")
	private AnswerService answerService;
	
	@Resource(name = "QuestionService")
	private QuestionService qService;

	private static final Logger logger = LoggerFactory.getLogger(ForumController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model uiModel, Principal principal) {

		if (principal != null) {

			User u = userService.getUserByUsername(principal.getName());
			uiModel.addAttribute("myName", u.getUsername());

			String myAuth = u.getAuthority();
			if (myAuth.equals(User.roleDoctor)) {
				//uiModel.addAttribute("myName", u.getUsername());

				List<Answer> myAnswers = this.answerService.getAnswersByUser(u);
				uiModel.addAttribute("answers", myAnswers);
				return "doctorProfile";
			} else {
				//uiModel.addAttribute("myName", u.getUsername());

				List<Question> myQuestions = this.qService.getQuestionsByUser(u);
				uiModel.addAttribute("questions", myQuestions);
				return "userProfile";
			}
		}

		else
			return "redirect:..";

	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String changePassword(HttpServletRequest req, Model uiModel, Principal principal) {

		if (principal != null) {

			User u = userService.getUserByUsername(principal.getName());
			uiModel.addAttribute("myName", u.getUsername());

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
