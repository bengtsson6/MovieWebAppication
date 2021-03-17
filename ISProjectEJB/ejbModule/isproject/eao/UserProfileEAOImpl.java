package isproject.eao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import isproject.ejb.UserProfile;


@Stateless
public class UserProfileEAOImpl implements UserProfileEAOLocal {
	
	@PersistenceContext(unitName="EJBSql")
	private EntityManager em;
	
    public UserProfileEAOImpl() {
    }
    public UserProfile findByEmail(String email) {
    	return em.find(UserProfile.class, email);
    }
    public UserProfile createUser(UserProfile user) {
    	em.persist(user);
    	return user;
    }
    public UserProfile updateUser(UserProfile user) {
    	em.merge(user);
    	return user;
    }
    public void deleteUser(String email) {
    	UserProfile user = this.findByEmail(email);
    	if (user != null) {
    		em.remove(user);
    	}
    }
}
