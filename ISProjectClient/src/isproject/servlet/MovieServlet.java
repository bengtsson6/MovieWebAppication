package isproject.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import isproject.ejb.Movie;
import isproject.ejb.MovieId;
import isproject.ejb.Rating;
import isproject.facade.FacadeLocal;

/**
 * Servlet implementation class MovieServlet
 */
@WebServlet("/MovieServlet")
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	FacadeLocal facade;

	public MovieServlet() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html><html><head>");
		out.println("<title>MovieServlet</title>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("</head><body>");
		out.println("<h2>Movie</h2>");
		out.println("</body></html>");

//		MovieId id = new MovieId("Hajen", "1970");
//		Movie movie = new Movie();
//		movie.setId(id);
//		movie.setGenre("Thriller");
//		movie.setDirector("Someone");
//		movie.setStreamingService("Netflix");
//
//		facade.createMovie(movie);

		List<Movie> allMovies = facade.findAllMovie();
		List<Movie> allMoviesByName = facade.findMovieByName("%Hajen%");

		out.println("<h2>All Movies</h2>");

		for (Movie tmpMovie : allMovies) {
			out.print("<h4>" + tmpMovie.getId().getMovieName() + " ");
			out.print(tmpMovie.getId().getReleaseYear() + " ");
			out.print(tmpMovie.getGenre() + " ");
			out.print(tmpMovie.getStreamingService() + " ");
			out.print(tmpMovie.getDirector() + "</h4>");
		}

		out.println("<br><h4>Is named Hajen</h4>");

		for (Movie tmpMovie2 : allMoviesByName) {
			out.print("<h4>" + tmpMovie2.getId().getMovieName() + " ");
			out.print(tmpMovie2.getId().getReleaseYear() + " ");
			out.print(tmpMovie2.getGenre() + " ");
			out.print(tmpMovie2.getStreamingService() + " ");
			out.print(tmpMovie2.getDirector() + "</h4>");
		}
		out.println("<br><h4>All Ratings of Hajen</h4>");
		Movie hajen = facade.findMovieById("Hajen", "1970");
		for (Rating r : hajen.getRatings()) {
			out.print("<h4>" + r.getId().getMovieName() + " ");
			out.print(r.getId().getReleaseYear() + " ");
			out.print(r.getId().getEmail() + " ");
			out.print(r.getRatingGrade() + " ");
			out.print(r.getReview()+"</h4>");
		
		}
	}
}
