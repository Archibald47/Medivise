package edu.usyd.medivise.service;

import java.util.List;

import edu.usyd.medivise.domain.Question;
import utils.ValidationError;

public interface QuestionService {

	public List<Question> getQuestions();

	public long addQuestion(String title, String content) throws ValidationError;

	public Question getQuestionById(long id);

	public void deleteQuestionById(long id);

}
