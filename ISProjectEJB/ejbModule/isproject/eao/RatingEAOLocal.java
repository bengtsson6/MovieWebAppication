package isproject.eao;

import javax.ejb.Local;

import isproject.ejb.Rating;

@Local
public interface RatingEAOLocal {

		public Rating findById(String movieName, String releaseYear, String email);
		public Rating createRating(Rating rating);
		public Rating updateRating(Rating rating);
		public void deleteRating(String movieName, String releaseYear, String email);
}
