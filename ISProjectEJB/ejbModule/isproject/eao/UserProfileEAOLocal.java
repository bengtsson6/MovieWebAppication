package isproject.eao;

import javax.ejb.Local;

import isproject.ejb.UserProfile;

@Local
public interface UserProfileEAOLocal {
	public UserProfile findByEmail(String email);
	public UserProfile createUser(UserProfile user);
	public UserProfile updateUser(UserProfile user);
	public void deleteUser(String email);
}
