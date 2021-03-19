package isproject.facade;

import java.util.List;

import javax.ejb.Local;

import isproject.ejb.Movie;
import isproject.ejb.Rating;
import isproject.ejb.UserProfile;

@Local
public interface FacadeLocal {
	public UserProfile findUserByEmail(String email);
	public UserProfile createUser(UserProfile user);
	public UserProfile updateUser(UserProfile user);
	public void deleteUser(String email);
	public List<UserProfile> findAllUsers();
	public List<UserProfile> findUserByName(String name);
    public Movie findMovieById(String movieName, String releaseYear);
    public Movie createMovie(Movie movie);
    public Movie updateMovie(Movie movie);
    public void deleteMovie(String movieName, String releaseYear);
    public List<Movie> findAllMovie();
    public List<Movie> findMovieByName(String name);
    public Rating findRatingById(String movieName, String releaseYear, String email);
    public Rating createRating(Rating rating);
    public Rating updateRating(Rating rating);
    public void deleteRating(String movieName, String releaseYear, String email);
}
