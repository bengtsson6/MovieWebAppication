package isproject.ejb;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name ="Rating")
public class Rating implements Serializable{
	
	private RatingId id;
	private int ratingGrade;
	private String review;
	
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
}
