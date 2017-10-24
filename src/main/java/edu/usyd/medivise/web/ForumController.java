package edu.usyd.medivise.web;

import java.security.Principal;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.usyd.medivise.domain.Answer;
import edu.usyd.medivise.domain.Comment;
import edu.usyd.medivise.domain.Question;
import edu.usyd.medivise.domain.User;
import edu.usyd.medivise.service.AnswerService;
import edu.usyd.medivise.service.CommentService;
import edu.usyd.medivise.service.QuestionService;
import edu.usyd.medivise.service.UserService;
import utils.ValidationError;

@Controller
@RequestMapping(value = "/questions/")
public class ForumController {

	@Resource(name = "QuestionService")
	private QuestionService qService;

	@Resource(name = "UserService")
	private UserService userService;
	
	@Resource(name = "CommentService")
	private CommentService cService;

	@Resource(name = "AnswerService")
	private AnswerService answerService;

	private static final Logger logger = LoggerFactory.getLogger(ForumController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Locale locale, Model uiModel, Principal principal) {
		if (principal != null) {
			User u = userService.getUserByUsername(principal.getName());
			uiModel.addAttribute("auth", u.getAuthority());
			String username = principal.getName();
			uiModel.addAttribute("username", username);
		} else {
			uiModel.addAttribute("auth", null);
			uiModel.addAttribute("username", null);
		}
		
		List<Question> q = this.qService.getQuestions();
		uiModel.addAttribute("questions", q);
		return "forum/index";
	}

	@RequestMapping(value = "/{id}/", method = RequestMethod.GET)
	public String getQuestion(@PathVariable("id") Long id, Model uiModel, Principal principal) {
		
		if (principal != null) {
			User u = userService.getUserByUsername(principal.getName());
			uiModel.addAttribute("auth", u.getAuthority());
			String username = principal.getName();
			uiModel.addAttribute("username", username);
		} else {
			uiModel.addAttribute("auth", null);
			uiModel.addAttribute("username", null);
		}
		
		Question q = this.qService.getQuestionById(id);
		uiModel.addAttribute("question", q);
		
		List<Comment> c = this.cService.getComments(q);
		uiModel.addAttribute("comment", c);
		
		List<Answer> a = answerService.getAnswers(q);
		uiModel.addAttribute("answers", a);
		return "forum/question";
	}

	@RequestMapping(value = "/{id}/delete/", method = RequestMethod.POST)
	public String removeQuestion(@PathVariable("id") Long id) {
		this.qService.deleteQuestionById(id);
		logger.info("Question with id " + id + " deleted.");
		return "redirect:../..";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newQuestion(Model uiModel,Principal principal) {
		if (principal != null) {
			String username = principal.getName();
			uiModel.addAttribute("username", username);
		} else {
			uiModel.addAttribute("username", null);
		}
		return "forum/new";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String postNewQuestion(HttpServletRequest req, Principal principal) {
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		User user = userService.getUserByUsername(principal.getName());
		try {
			long id = this.qService.addQuestion(title, content, user);
			logger.info("Question created with id " + id + ".");
			return "redirect:../" + id + "/";
		} catch (ValidationError e) {
			return "forum/new";
		}
	}
	
	
	@RequestMapping(value = "/{id}/comment/", method = RequestMethod.POST)
	public String addComment(@PathVariable("id") Long qid,HttpServletRequest req, Principal principal) {
		String content = req.getParameter("content");
		User user = userService.getUserByUsername(principal.getName());
		Question q = qService.getQuestionById(qid);
		try {
			long cid = this.cService.addComment(q, content, user);
			logger.info("Comment created with id " + cid + ".");
			return "redirect:..";
		} catch (ValidationError e) {
			return "redirect:..";
		}
	}
	
	
	@RequestMapping(value = "/{id}/postanswer/", method = RequestMethod.POST)
	public String addAnswer(@PathVariable("id") Long qid,HttpServletRequest req, Principal principal) {
		String content = req.getParameter("content");
		User user = userService.getUserByUsername(principal.getName());
		Question q = qService.getQuestionById(qid);
		try {
			long aid = this.answerService.addAnswer(q, content, user);
			logger.info("Answer created with id " + aid + ".");
			return "redirect:..";
		} catch (ValidationError e) {
			return "redirect:..";
		}
	}	
}
