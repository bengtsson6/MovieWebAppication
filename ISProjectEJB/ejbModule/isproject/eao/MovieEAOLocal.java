package isproject.eao;

import java.util.List;

import javax.ejb.Local;

import isproject.ejb.Movie;

@Local
public interface MovieEAOLocal {
	
	public Movie findByMovieId(String movieName, String releaseYear);
	public Movie createMovie(Movie movie);
	public Movie updateMovie(Movie movie);
	public void deleteMovie(String movieName, String releaseYear);
	public List<Movie> findAll();
	public List<Movie> findByName(String name);
}
