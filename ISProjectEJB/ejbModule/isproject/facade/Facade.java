package isproject.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import isproject.eao.MovieEAOLocal;
import isproject.eao.RatingEAOLocal;
import isproject.eao.UserProfileEAOLocal;
import isproject.ejb.Movie;
import isproject.ejb.Rating;
import isproject.ejb.UserProfile;


@Stateless
public class Facade implements FacadeLocal {
	
	@EJB
	private UserProfileEAOLocal userProfileEAO;
	@EJB
	private MovieEAOLocal movieEAO;
	@EJB
	private RatingEAOLocal ratingEAO;
	
    public Facade() {
        
    }
    public UserProfile findUserByEmail(String email) {
    	return userProfileEAO.findByEmail(email);
    }
    public UserProfile createUser(UserProfile user) {
    	return userProfileEAO.createUser(user);
    }
    public UserProfile updateUser(UserProfile user) {
    	return userProfileEAO.updateUser(user);
    }
    public void deleteUser(String email) {
    	userProfileEAO.deleteUser(email);
    }
    public List<UserProfile> findAllUsers(){
    	return userProfileEAO.findAll();
    }
    public List<UserProfile> findUserByName(String name) {
    	return userProfileEAO.findUserByName(name);
    }
    public Movie findMovieById(String movieName, String releaseYear) {
    	return movieEAO.findByMovieId(movieName, releaseYear);
    }
    public Movie createMovie(Movie movie) {
    	return movieEAO.createMovie(movie);
    }
    public Movie updateMovie(Movie movie) {
    	return movieEAO.updateMovie(movie);
    }
    public void deleteMovie(String movieName, String releaseYear) {
    	movieEAO.deleteMovie(movieName, releaseYear);
    }
    public List<Movie> findAllMovie(){
    	return movieEAO.findAll();
    }
    public List<Movie> findMovieByName(String name){
    	return movieEAO.findByName(name);
    }
	public Rating findRatingById(String movieName, String releaseYear, String email) {
		return ratingEAO.findById(movieName, releaseYear, email);
	}
	public Rating createRating(Rating rating) {
		return ratingEAO.createRating(rating);
	}
	public Rating updateRating(Rating rating) {
		return ratingEAO.updateRating(rating);
	}
	public void deleteRating(String movieName, String releaseYear, String email) {
		ratingEAO.deleteRating(movieName, releaseYear, email);
	}
}
