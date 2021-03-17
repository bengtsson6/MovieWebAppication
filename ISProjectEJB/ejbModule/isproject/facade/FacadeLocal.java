package isproject.facade;

import java.util.List;

import javax.ejb.Local;

import isproject.ejb.UserProfile;

@Local
public interface FacadeLocal {
	public UserProfile findUserByEmail(String email);
	public UserProfile createUser(UserProfile user);
	public UserProfile updateUser(UserProfile user);
	public void deleteUser(String email);
	public List<UserProfile> findAllUsers();
	public List<UserProfile> findUserByName(String name);
}
