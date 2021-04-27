package isproject.junit;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import isproject.ejb.UserProfile;
import isproject.facade.FacadeLocal;
import junit.framework.TestCase;

public class FacadeBeanTest extends TestCase {
	
	FacadeLocal facade;
	UserProfile user;

	public FacadeBeanTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		Context context = new InitialContext(); 
		facade = (FacadeLocal)context.lookup("java:app/ISProjectEJB/Facade!isproject.facade.FacadeLocal");
		user = new UserProfile();
		user.setEmail("test@Gmail.com");
		user.setUserName("test");
		user.setBirthYear("1996");
		
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
		facade = null;
		user = null;
	}
	
	public void testFacadeUserCRUDMethods() throws Exception {
		assertEquals(facade.createUser(user), user);
		user.setUserName("update");
		assertEquals(facade.updateUser(user), user);
		assertNotNull(facade.findUserByEmail(user.getEmail()));
		facade.deleteUser(user.getEmail());
		assertNull(facade.findUserByEmail(user.getEmail()));
	}
	
	public void testFacadeFindAllMethods() throws Exception{
		assertTrue(facade.findAllUsers() instanceof List);
		assertTrue(facade.findAllMovie() instanceof List);
	}
}
