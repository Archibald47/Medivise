package edu.usyd.medivise.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.usyd.medivise.domain.Answer;
import edu.usyd.medivise.domain.Question;
import edu.usyd.medivise.domain.User;
import utils.NotFoundException;
import utils.ValidationError;

@Service(value = "AnswerService")
@Transactional
public class AnswerServiceProvider implements AnswerService {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public List<Answer> getAnswers(Question question) {
		return this.sessionFactory.getCurrentSession().createCriteria(Answer.class)
				.add(Restrictions.eq("question", question)).list();
	}

	@Override
	public long addAnswer(Question question, String content, User user) throws ValidationError {
		if (!user.getAuthority().equals(User.roleDoctor)) {
			throw new ValidationError("Only Doctor can post answers.");
		}
		if (content != null && content.length() > 0) {
			return (long) this.sessionFactory.getCurrentSession().save(new Answer(question, content, user));
		} else {
			throw new ValidationError("Answer title and content cannot be empty.");
		}
	}

	@Override
	public Answer getAnswerById(long id) {
		Answer q = (Answer) this.sessionFactory.getCurrentSession().get(Answer.class, id);
		if (q == null) {
			throw new NotFoundException();
		}
		return q;
	}

	@Override
	public void deleteAnswerById(long id) {
		this.sessionFactory.getCurrentSession().delete(getAnswerById(id));
	}

}
