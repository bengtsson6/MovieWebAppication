package isproject.ejb;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQueries({
	@NamedQuery(name ="Movie.findAll", query="SELECT m FROM Movie m"),
	@NamedQuery(name="Movie.findByName", query="SELECT m FROM Movie m WHERE movieName LIKE: name"),
})
@Table(name ="Movie")
public class Movie implements Serializable {
	
	private MovieId id;
	private String director;
	private String genre;
	private String streamingService;
	private Set<Rating> ratings;
	
	@EmbeddedId
	public MovieId getId() {
		return id;
	}
	public void setId(MovieId id) {
		this.id = id;
	}
	@Column(name ="director")
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	@Column(name="genre")
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	@Column(name ="streamingService")
	public String getStreamingService() {
		return streamingService;
	}
	public void setStreamingService(String streamingService) {
		this.streamingService = streamingService;
	}
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "movie")
	public Set<Rating> getRatings(){
		return this.ratings;
	}
	public void setRatings(Set<Rating> ratings) {
		this.ratings = ratings;
	}
}
