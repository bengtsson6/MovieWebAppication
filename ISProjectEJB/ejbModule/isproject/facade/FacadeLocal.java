package isproject.facade;

import javax.ejb.Local;

import isproject.ejb.UserProfile;

@Local
public interface FacadeLocal {
	public UserProfile findUserByEmail(String email);
	public UserProfile createUser(UserProfile user);
	public UserProfile updateUser(UserProfile user);
	public void deleteUser(String email);
}
