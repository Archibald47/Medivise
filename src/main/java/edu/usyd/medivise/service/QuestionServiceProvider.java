package edu.usyd.medivise.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.usyd.medivise.domain.Question;
import edu.usyd.medivise.domain.User;
import utils.NotFoundException;
import utils.ValidationError;

@Service(value = "QuestionService")
@Transactional
public class QuestionServiceProvider implements QuestionService {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public List<Question> getQuestions() {
		System.out.println(this.sessionFactory.getCurrentSession().createCriteria(Question.class).list());
		return this.sessionFactory.getCurrentSession().createCriteria(Question.class).list();
	}

	@Override
	public long addQuestion(String title, String content, User user) throws ValidationError {
		if (title != null && title.length() > 0 && content != null && content.length() > 0) {
			return (long) this.sessionFactory.getCurrentSession().save(new Question(title, content, user));
		} else {
			throw new ValidationError("Question title and content cannot be empty.");
		}
	}

	@Override
	public Question getQuestionById(long id) {
		Question q = (Question) this.sessionFactory.getCurrentSession().get(Question.class, id);
		if (q == null) {
			throw new NotFoundException();
		}
		return q;
	}

	@Override
	public void deleteQuestionById(long id) {
		this.sessionFactory.getCurrentSession().delete(getQuestionById(id));
	}

}
