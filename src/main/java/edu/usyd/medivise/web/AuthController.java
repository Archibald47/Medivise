package edu.usyd.medivise.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.usyd.medivise.service.UserService;
import utils.ValidationError;

@Controller
public class AuthController {

	@Resource(name = "UserService")
	private UserService userService;

	private static final Logger logger = LoggerFactory.getLogger(ForumController.class);

	@RequestMapping(value = "/createaccount/", method = RequestMethod.POST)
	public String createAccount(HttpServletRequest req) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String password2 = req.getParameter("password2");
		String isDoctot = req.getParameter("isdoctor");
		
		if (!password.equals(password2)) {
			return "redirect:../register/";
		}

		try {
			if (isDoctot.equals("true")) {
				this.userService.createDoctor(username, password);
			} else {
				this.userService.createUser(username, password);
			}
			logger.info("User created with username " + username + ".");
			return "redirect:..";
		} catch (ValidationError e) {
			return "redirect:../register/";
		}
	}
}
