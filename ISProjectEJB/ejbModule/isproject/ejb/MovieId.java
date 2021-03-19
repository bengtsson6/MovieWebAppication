package isproject.ejb;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class MovieId implements Serializable {

	private String movieName;
	private String releaseYear;
	
	public MovieId() {}
	public MovieId(String movieName, String releaseYear) {
		this.movieName = movieName;
		this.releaseYear = releaseYear;
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

	public boolean equals(Object otherMovieId) {
		if (this == otherMovieId) {
			return true;
		}
		if (otherMovieId == null) {
			return false;
		}
		if (!(otherMovieId instanceof MovieId)) {
			return false;
		}
		MovieId castMovieId = (MovieId) otherMovieId;

		return ((this.getMovieName() == castMovieId.getMovieName()) || (this.getMovieName() != null
				&& castMovieId.getMovieName() != null && this.getMovieName().equals(castMovieId.getMovieName())))
				&& ((this.getReleaseYear() == castMovieId.getReleaseYear())
						|| (this.getReleaseYear() != null && castMovieId.getReleaseYear() != null
								&& this.getReleaseYear().equals(castMovieId.getReleaseYear())));

	}
	public int hashCode() {
		return super.hashCode();
	}
}
