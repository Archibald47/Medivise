import static org.junit.Assert.*;

import org.junit.Test;

import edu.usyd.medivise.domain.Answer;
import edu.usyd.medivise.domain.Comment;
import edu.usyd.medivise.domain.Question;
import edu.usyd.medivise.domain.User;

public class AnswerTests{
	
	@Test
	public void testNewCommentUser(){
		
		String username1 = "Fred";
		String password1 = "dfgvbhnkn";
		User user = new User(username1, password1, User.roleDoctor);
		Question question = new Question("Private emergency question", "My poops can't come out", user);
		Answer answer = new Answer(question, "Eat bananas",user);
		
		assertEquals(username1,answer.getUser().getUsername());
		
	}
	
	@Test
	public void testNewCommentContent(){
		
		String username1 = "John";
		String password1 = "vcgh bkjn";
		User user = new User(username1, password1, User.roleUser);
		Question question = new Question("Private emergency question", "My poops can't come out", user);
		Answer answer = new Answer(question, "LOL you are doomed",user);
		
		assertEquals(answer.getContent(),"LOL you are doomed");
	}
	
	@Test
	public void testNewCommentQuestion(){
		
		String username1 = "Annabell";
		String password1 = "uyg6792";
		User user = new User(username1, password1, User.roleUser);
		Question question = new Question("Private emergency question", "My poops can't come out", user);
		Answer answer = new Answer(question, "Go to the hospital!",user);
		
		assertEquals(answer.getQuestion(),question);
		
	}
}