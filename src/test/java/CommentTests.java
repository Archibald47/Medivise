import static org.junit.Assert.*;

import org.junit.Test;

import edu.usyd.medivise.domain.Comment;
import edu.usyd.medivise.domain.Question;
import edu.usyd.medivise.domain.User;

public class CommentTests{
	
	@Test
	public void testNewCommentUser(){
		
		String username1 = "Fred";
		String password1 = "dfgvbhnkn";
		User user = new User(username1, password1, User.roleDoctor);
		Question question = new Question("Private emergency question", "My poops can't come out", user);
		Comment comment = new Comment(question, "Hi maybe you ate stones",user);
		
		assertEquals(username1,comment.getUser().getUsername());
		
	}
	
	@Test
	public void testNewCommentContent(){
		
		String username1 = "John";
		String password1 = "vcgh bkjn";
		User user = new User(username1, password1, User.roleUser);
		Question question = new Question("Private emergency question", "My poops can't come out", user);
		Comment comment = new Comment(question, "LOL you are doomed",user);
		
		assertEquals(comment.getContent(),"LOL you are doomed");
	}
	
	@Test
	public void testNewCommentQuestion(){
		
		String username1 = "Annabell";
		String password1 = "uyg6792";
		User user = new User(username1, password1, User.roleUser);
		Question question = new Question("Private emergency question", "My poops can't come out", user);
		Comment comment = new Comment(question, "Go to the hospital!",user);
		
		assertEquals(comment.getQuestion(),question);
		
	}
}