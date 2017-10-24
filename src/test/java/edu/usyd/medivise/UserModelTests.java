package edu.usyd.medivise;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.usyd.medivise.domain.User;

public class UserModelTests {

	private final String testUserName = "username";
	private final String testPassword = "password";
	private final String testAuthority = "ROLE_USER";
	

	@Test
	public void testUserSimpleCreation() {
		User u = new User();
	}

	@Test
	public void testUserArgCreation() {
		User u = new User(testUserName, testPassword, testAuthority);
	}

	@Test
	public void testUserGetters() {
		User u = new User(testUserName, testPassword, testAuthority);
		
		assertEquals(u.getUsername(), testUserName);
		assertEquals(u.getPassword(), testPassword);
		assertEquals(u.getAuthority(), testAuthority);
	}

	@Test
	public void testUserSetters() {
		User u = new User(testUserName, testPassword, testAuthority);
		
		assertEquals(u.getUsername(), testUserName);
		assertEquals(u.getPassword(), testPassword);
		assertEquals(u.getAuthority(), testAuthority);
		
		u.setPassword("12345678");
		assertEquals(u.getPassword(), "12345678");
	}

}
