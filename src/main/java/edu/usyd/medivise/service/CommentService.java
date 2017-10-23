package edu.usyd.medivise.service;

import java.util.List;

import edu.usyd.medivise.domain.Comment;
import edu.usyd.medivise.domain.Question;
import edu.usyd.medivise.domain.User;
import utils.ValidationError;

public interface CommentService {

	public List<Comment> getComments(Question questoin);

	public long addComment(Question question, String content, User user) throws ValidationError;

	public Comment getCommentById(long id);

	public void deleteCommentById(long id);

}
