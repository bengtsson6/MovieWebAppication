package isproject.assistance;

import isproject.ejb.Movie;
import isproject.ejb.MovieId;
import isproject.ejb.Rating;
import isproject.ejb.RatingId;
import isproject.ejb.UserProfile;

public class ObjectCreator {

	public static UserProfile createUserObject(String email, String name, String birthYear) {
		UserProfile user = new UserProfile();
		user.setEmail(email);
		user.setUserName(name);
		user.setBirthYear(birthYear);
		return user;
	}
	
	public static Movie createMovieObject(String title, String releaseYear, String director, String genre, String streamingService) {
		Movie movie = new Movie();
		MovieId movieId = new MovieId();
		movieId.setMovieName(title);
		movieId.setReleaseYear(releaseYear);
		movie.setId(movieId);
		movie.setDirector(director);
		movie.setGenre(genre);
		movie.setStreamingService(streamingService);
		return movie;
	}
	public static Rating createRatingObject(String title, String releaseYear, String email, int ratingGrade, String review) {
		Rating rating = new Rating();
		RatingId ratingId = new RatingId();
		ratingId.setEmail(email);
		ratingId.setMovieName(title);
		ratingId.setReleaseYear(releaseYear);
		rating.setId(ratingId);
		rating.setRatingGrade(ratingGrade);
		rating.setReview(review);
		return rating;
	}
}
