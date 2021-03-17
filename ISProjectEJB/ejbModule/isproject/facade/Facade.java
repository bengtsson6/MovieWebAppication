package isproject.facade;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import isproject.eao.UserProfileEAOLocal;
import isproject.ejb.UserProfile;


@Stateless
public class Facade implements FacadeLocal {
	
	@EJB
	private UserProfileEAOLocal userProfileEAO;
    public Facade() {
        
    }
    public UserProfile findUserByEmail(String email) {
    	return userProfileEAO.findByEmail(email);
    }
    public UserProfile createUser(UserProfile user) {
    	return userProfileEAO.createUser(user);
    }
    public UserProfile updateUser(UserProfile user) {
    	return userProfileEAO.updateUser(user);
    }
    public void deleteUser(String email) {
    	userProfileEAO.deleteUser(email);
    }
}
