package isproject.junit;

import javax.naming.Context;
import javax.naming.InitialContext;

import isproject.ejb.UserProfile;
import isproject.facade.FacadeLocal;
import junit.framework.TestCase;

public class FacadeBeanTest extends TestCase {
	
	FacadeLocal facade;
	UserProfile user = new UserProfile();

	public FacadeBeanTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		Context context = new InitialContext(); 
		facade = (FacadeLocal)context.lookup("java:app/ISProjectEJB/Facade!isproject.facade.FacadeLocal");
		user.setEmail("test@Gmail.com");
		user.setUserName("test");
		user.setBirthYear("1996");
		
	}

	public void testFacadeUserCRUDMethods() throws Exception {
		assertEquals(facade.createUser(user),user);
		assertNotNull(facade.findUserByEmail(user.getEmail()));
		user.setEmail("update@Gmail.com");
		assertEquals(facade.updateUser(user), user);
		facade.deleteUser(user.getEmail());
		assertNull(facade.findUserByEmail(user.getEmail()));
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
		facade = null;
		user = null;
	}
}
