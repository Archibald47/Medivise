package edu.usyd.medivise.service;

import java.util.List;

import edu.usyd.medivise.domain.Answer;
import edu.usyd.medivise.domain.Question;
import edu.usyd.medivise.domain.User;
import utils.ValidationError;

public interface QuestionService {

	public List<Question> getQuestions();
	
	public List<Question> getQuestionsByUser(User user);
	

	public long addQuestion(String title, String content, User user) throws ValidationError;

	public Question getQuestionById(long id);

	public void deleteQuestionById(long id);

}
