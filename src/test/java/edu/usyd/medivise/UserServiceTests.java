package edu.usyd.medivise;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.usyd.medivise.service.UserService;
import utils.ValidationError;

public class UserServiceTests {
	
	@Test(expected = ValidationError.class)
	public void testInvalid1() throws ValidationError {
		UserService us = new UserService();
		
		us.createUser(null, null);
	}

	@Test(expected = ValidationError.class)
	public void testInvalid2() throws ValidationError {
		UserService us = new UserService();
		
		us.createUser(null, "");
	}

	@Test(expected = ValidationError.class)
	public void testInvalid3() throws ValidationError {
		UserService us = new UserService();
		
		us.createUser("", null);
	}

	@Test(expected = ValidationError.class)
	public void testInvalid4() throws ValidationError {
		UserService us = new UserService();
		
		us.createUser("", "");
	}

	@Test(expected = ValidationError.class)
	public void testInvalid5() throws ValidationError {
		UserService us = new UserService();
		
		us.createUser("username", "");
	}

	@Test(expected = ValidationError.class)
	public void testInvalid6() throws ValidationError {
		UserService us = new UserService();
		
		us.createUser("", "password");
	}

}
