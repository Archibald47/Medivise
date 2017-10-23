package edu.usyd.medivise.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.usyd.medivise.domain.Comment;
import edu.usyd.medivise.domain.Question;
import edu.usyd.medivise.domain.User;
import utils.NotFoundException;
import utils.ValidationError;

@Service(value = "CommentService")
@Transactional
public class CommentServiceProvider implements CommentService {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public List<Comment> getComments(Question question) {
		return this.sessionFactory.getCurrentSession().createCriteria(Comment.class)
				.add(Restrictions.eq("question", question)).list();
	}

	@Override
	public long addComment(Question question, String content, User user) throws ValidationError {
		if (content != null && content.length() > 0) {
			return (long) this.sessionFactory.getCurrentSession().save(new Comment(question, content, user));
		} else {
			throw new ValidationError("Comment title and content cannot be empty.");
		}
	}

	@Override
	public Comment getCommentById(long id) {
		Comment q = (Comment) this.sessionFactory.getCurrentSession().get(Comment.class, id);
		if (q == null) {
			throw new NotFoundException();
		}
		return q;
	}

	@Override
	public void deleteCommentById(long id) {
		this.sessionFactory.getCurrentSession().delete(getCommentById(id));
	}

}
