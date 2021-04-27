package isproject.ejb.test;

import isproject.ejb.UserProfile;
import junit.framework.TestCase;

public class UserProfileTest extends TestCase {
	String expectedEmail;
	String expectedName;
	String expectedBirthYear;
	UserProfile user1;

	public UserProfileTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		expectedEmail = "gustav@gmail.com";
		expectedName = "gustav";
		expectedBirthYear = "1996";
		
		user1 = new UserProfile();
		user1.setEmail(expectedEmail);
		user1.setUserName(expectedName);
		user1.setBirthYear(expectedBirthYear);

		}

	protected void tearDown() throws Exception {
		super.tearDown();
		user1 = null;
	}

	public void testGetEmail() {
		assertNotNull(user1);
		assertEquals(expectedEmail, user1.getEmail());
	}

	public void testGetUserName() {
		assertEquals(expectedName, user1.getUserName());
	}

	public void testGetBirthYear() {
		assertEquals(expectedBirthYear, user1.getBirthYear());
	}

	public void testSetUserName() {
		String expectedName2 = "test";
		user1.setUserName(expectedName2);
		assertEquals(expectedName2, user1.getUserName());
	}
	
	public void testSetEmail() {
		String expectedEmail2 = "test";
		user1.setEmail(expectedEmail2);
		assertEquals(expectedEmail2, user1.getEmail());
	}

	public void testSetBirthYear() {
		String expectedBirthYear2 = "test";
		user1.setBirthYear(expectedBirthYear2);
		assertEquals(expectedBirthYear2, user1.getBirthYear());
	}
}
