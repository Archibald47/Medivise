package edu.usyd.medivise.service;

import java.util.List;

import edu.usyd.medivise.domain.Answer;
import edu.usyd.medivise.domain.Question;
import edu.usyd.medivise.domain.User;
import utils.ValidationError;

public interface AnswerService {

	public List<Answer> getAnswers(Question questoin);

	public long addAnswer(Question question, String content, User user) throws ValidationError;

	public Answer getAnswerById(long id);

	public void deleteAnswerById(long id);

}
