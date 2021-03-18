package isproject.ejb;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class RatingId {
	private String movieTitle;
	private String releaseYear;
	private String email;

	@Column(name = "movieTitle")
	@NotNull
	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
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
				&& ((this.getMovieTitle() == castRatingId.getMovieTitle())
						|| (this.getMovieTitle() != null && castRatingId.getMovieTitle() != null
								&& this.getMovieTitle().equals(castRatingId.getMovieTitle())))
				&& ((this.getReleaseYear() == castRatingId.getReleaseYear())
						|| (this.getReleaseYear() != null && castRatingId.getReleaseYear() != null
								&& this.getReleaseYear().equals(castRatingId.getReleaseYear())));
	}
}
