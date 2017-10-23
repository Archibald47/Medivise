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

import edu.usyd.medivise.domain.Comment;
import edu.usyd.medivise.domain.Question;
import edu.usyd.medivise.domain.User;
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
	private CommentService cServise;
	

	private static final Logger logger = LoggerFactory.getLogger(ForumController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Locale locale, Model uiModel) {
		List<Question> q = this.qService.getQuestions();
		uiModel.addAttribute("questions", q);
		return "forum/index";
	}

	@RequestMapping(value = "/{id}/", method = RequestMethod.GET)
	public String getQuestion(@PathVariable("id") Long id, Model uiModel) {

		Question q = this.qService.getQuestionById(id);
		uiModel.addAttribute("question", q);
		//modified for comments
		List<Comment> c = this.cServise.getComments();
		uiModel.addAttribute("comment", c);
		return "forum/question";
	}

	@RequestMapping(value = "/{id}/delete/", method = RequestMethod.POST)
	public String removeQuestion(@PathVariable("id") Long id) {
		this.qService.deleteQuestionById(id);
		logger.info("Question with id " + id + " deleted.");
		return "redirect:../..";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newQuestion() {
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
	
	@RequestMapping(value = "/{id}/comment/", method = RequestMethod.GET)
	public String newComment(@PathVariable("id") Long id) {
		return "forum/question" + id + "/";
	}
	
	@RequestMapping(value = "/{id}/comment/", method = RequestMethod.POST)
	public String addComment(@PathVariable("id") Long id,HttpServletRequest req, Principal principal) {
		String content = req.getParameter("content");
		User user = userService.getUserByUsername(principal.getName());
		//logger.info("Question with id " + id + " deleted.");
		//return "redirect:../..";
		try {
			long thiscid = this.cServise.addComment(id, content, user);
			logger.info("Comment created with id " + id + ".");
			return "forum/question" + id + "/";
		} catch (ValidationError e) {
			return "forum/";
		}
	}
	
	
	/*
	@RequestMapping(value = "/{id}/comment/", method = RequestMethod.GET)
	public String newComment() {
		return "redirect:../" + "comment" + "/";
	}
	
	@RequestMapping(value = "/{id}/comment/", method = RequestMethod.POST)
	public String addComment(@PathVariable("id") Long id,HttpServletRequest req, Principal principal) {
		String content = req.getParameter("content");
		User user = userService.getUserByUsername(principal.getName());
		//logger.info("Question with id " + id + " deleted.");
		//return "redirect:../..";
		try {
			long thiscid = this.cServise.addComment(id, content, user);
			logger.info("Comment created with id " + id + ".");
			return "forum/" + id + "/";
		} catch (ValidationError e) {
			return "forum/new";
		}
	}
	*/
	
}
