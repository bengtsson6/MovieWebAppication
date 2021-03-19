package isproject.ejb;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQueries({
	@NamedQuery(name="UserProfile.findAll", query="SELECT u FROM UserProfile u"),
	@NamedQuery(name="UserProfile.findUserByName", query="SELECT u FROM UserProfile u WHERE u.userName LIKE: name"),
})
@Table(name="UserProfile")
public class UserProfile implements Serializable {
	
	private String email;
	private String userName;
	private String birthYear;
	private Set<Rating> ratings;
	
	@Id
	@Column(name ="email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name ="userName")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Column(name ="birthYear")
	public String getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}
	@OneToMany(fetch = FetchType.EAGER, mappedBy ="userProfile")
	public Set<Rating> getRatings(){
		return this.ratings;
	}
	public void setRatings(Set<Rating> ratings) {
		this.ratings = ratings;
	}
}
