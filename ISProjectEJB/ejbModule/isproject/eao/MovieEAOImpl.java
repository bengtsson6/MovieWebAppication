package isproject.eao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import isproject.ejb.Movie;
import isproject.ejb.MovieId;
import isproject.ejb.Rating;


@Stateless
public class MovieEAOImpl implements MovieEAOLocal {

	@PersistenceContext(unitName="EJBSql")
	private EntityManager em;
	
    public MovieEAOImpl() {	
    }
    
    public Movie findByMovieId(String movieName, String releaseYear) {
    	MovieId id = new MovieId(movieName, releaseYear);
    	return em.find(Movie.class, id);
    }
    
    public Movie createMovie(Movie movie) {
    	em.persist(movie);
    	return movie;
    }
    public Movie updateMovie(Movie movie) {
    	em.merge(movie);
    	return movie;
    }
    public void deleteMovie(String movieName, String releaseYear) {
    	Movie movie = this.findByMovieId(movieName, releaseYear);
    	if(movie != null) {
    		em.remove(movie);
    	}
    }
    public List<Movie> findAll(){
    	TypedQuery<Movie> query = em.createNamedQuery("Movie.findAll", Movie.class);
    	List<Movie> allMovies = query.getResultList();
    	return allMovies;
    }
    public List<Movie> findByName(String name){
    	TypedQuery<Movie> query = em.createNamedQuery("Movie.findByName", Movie.class);
    	query.setParameter("name", name);
    	List<Movie> moviesByName = query.getResultList();
    	return moviesByName;
    }
    public double getAvgRating(String movieName, String releaseYear) {
    	double avgRating = 0;
    	Movie movie = this.findByMovieId(movieName, releaseYear);
    	for(Rating rating : movie.getRatings()) {
    		avgRating += (double) rating.getRatingGrade();
    	}
    	return avgRating;
    }
} 
