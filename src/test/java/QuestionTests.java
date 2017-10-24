import static org.junit.Assert.*;

import org.junit.Test;

import edu.usyd.medivise.domain.Question;
import edu.usyd.medivise.domain.User;

public class QuestionTests{
	
	@Test
	public void testNewQuestionUser(){
		
		String username1 = "Fred";
		String password1 = "dfgvbhnkn";
		User user = new User(username1, password1, User.roleUser);
		Question question = new Question("testQuestion1", "testContent", user);
		
		assertEquals(username1,question.getUser().getUsername());
		
	}
	
	@Test
	public void testNewQuestionContent(){
		
		String username1 = "John Green";
		String password1 = "dfghjk";
		User user = new User(username1, password1, User.roleDoctor);
		Question question = new Question("Private emergency question", "My poops can't come out", user);
		
		assertEquals("My poops can't come out",question.getContent());
	}
	
	@Test
	public void testNewQuestionTitle(){
		
		String username1 = "Maven";
		String password1 = "dxfcgvhbjnkm";
		User user = new User(username1, password1, User.roleDoctor);
		Question question = new Question("My head hurts", "testContent", user);
		
		assertEquals("My head hurts",question.getTitle());
		
	}
}