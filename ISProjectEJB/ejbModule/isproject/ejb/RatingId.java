package isproject.ejb;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class RatingId implements Serializable{
	private String movieName;
	private String releaseYear;
	private String email;

	
	public RatingId() {
	}
	public RatingId(String movieTitle, String releaseYear, String email) {
		this.movieName = movieTitle;
		this.releaseYear = releaseYear;
		this.email = email;
	}
	
	@Column(name = "movieName")
	@NotNull
	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	@Column(name = "releaseYear")
	@NotNull
	public String getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}

	@Column(name = "email")
	@NotNull
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean equals(Object otherRatingId) {
		if (this == otherRatingId) {
			return true;
		}
		if ((otherRatingId == null)) {
			return false;
		}
		if (!(otherRatingId instanceof RatingId)) {
			return false;
		}
		RatingId castRatingId = (RatingId) otherRatingId;

		return ((this.getEmail() == castRatingId.getEmail()) || (this.getEmail() != null
				&& castRatingId.getEmail() != null && this.getEmail().equals(castRatingId.getEmail())))
				&& ((this.getMovieName() == castRatingId.getMovieName())
						|| (this.getMovieName() != null && castRatingId.getMovieName() != null
								&& this.getMovieName().equals(castRatingId.getMovieName())))
				&& ((this.getReleaseYear() == castRatingId.getReleaseYear())
						|| (this.getReleaseYear() != null && castRatingId.getReleaseYear() != null
								&& this.getReleaseYear().equals(castRatingId.getReleaseYear())));
	}
	public int hashCode() {
		return super.hashCode();
	}
}
