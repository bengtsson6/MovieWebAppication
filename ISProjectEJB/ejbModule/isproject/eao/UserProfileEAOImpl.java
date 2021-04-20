package isproject.eao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
    public List<UserProfile> findAll(){
    	TypedQuery<UserProfile> query = 
    			em.createNamedQuery("UserProfile.findAll", UserProfile.class);
    	List<UserProfile> allUsers = query.getResultList();
    	return allUsers;
    }
    public List<String> findAllUserEmail(){
		List<String> allEmails = new ArrayList<String>();
		List<UserProfile> allUsers = this.findAll();
		for (UserProfile user : allUsers) {
			allEmails.add(user.getEmail());
		}
		return allEmails;
	}
}
