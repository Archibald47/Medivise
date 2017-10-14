package edu.usyd.medivise.web;

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

import edu.usyd.medivise.domain.Question;
import edu.usyd.medivise.service.QuestionService;
import utils.ValidationError;

@Controller
@RequestMapping(value = "/questions/")
public class ForumController {

	@Resource(name = "QuestionService")
	private QuestionService qService;

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
		return "forum/question";
	}

	@RequestMapping(value = "/{id}/delete/", method = RequestMethod.POST)
	public String removeQuestion(@PathVariable("id") Long id) {
		this.qService.deleteQuestionById(id);
		return "redirect:../..";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newQuestion() {
		return "forum/new";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String postNewQuestion(HttpServletRequest req) {
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		try {
			long id = this.qService.addQuestion(title, content);
			return "redirect:../" + id + "/";
		} catch (ValidationError e) {
			return "forum/new";
		}
	}
}
