package isproject.ejb;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="Rating")
public class Rating implements Serializable{
	
	private RatingId id;
	private int ratingGrade;
	private String review;
	private Movie movie;
	private UserProfile userProfile;
	
	@EmbeddedId
	public RatingId getId() {
		return id;
	}
	public void setId(RatingId id) {
		this.id = id;
	}
	@Column(name="rating")
	public int getRatingGrade() {
		return ratingGrade;
	}
	public void setRatingGrade(int ratingGrade) {
		this.ratingGrade = ratingGrade;
	}
	@Column(name="review")
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="movieName", referencedColumnName="movieName",
				nullable = false, insertable = false, updatable = false),
		@JoinColumn(name="releaseYear", referencedColumnName="releaseYear", 
				nullable = false, insertable = false, updatable = false),
		})
	public Movie getMovie() {
		return this.movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	@ManyToOne
	@JoinColumn(name="email", referencedColumnName="email",
			nullable = false, insertable = false, updatable = false)
	public UserProfile getUserProfile() {
		return this.userProfile;
	}
	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
}
