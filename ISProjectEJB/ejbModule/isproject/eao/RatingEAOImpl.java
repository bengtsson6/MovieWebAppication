package isproject.eao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import isproject.ejb.Rating;
import isproject.ejb.RatingId;

@Stateless
public class RatingEAOImpl implements RatingEAOLocal {

	@PersistenceContext(name = "EJBSql")
	private EntityManager em;

	public RatingEAOImpl() {
	}

	public Rating findById(String movieName, String releaseYear, String email) {
		RatingId id = new RatingId(movieName, releaseYear, email);
		return em.find(Rating.class, id);
	}

	public Rating createRating(Rating rating) {
		em.persist(rating);
		return rating;
	}

	public Rating updateRating(Rating rating) {
		em.merge(rating);
		return rating;
	}

	public void deleteRating(String movieName, String releaseYear, String email) {
		Rating rating = this.findById(movieName, releaseYear, email);
		if (rating != null) {
			em.remove(rating);
		}
	}

}
