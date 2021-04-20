package isproject.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import isproject.ejb.Movie;
import isproject.ejb.MovieId;
import isproject.ejb.Rating;
import isproject.ejb.RatingId;
import isproject.ejb.UserProfile;
import isproject.facade.FacadeLocal;

/**
 * Servlet implementation class MainSerlvet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	FacadeLocal facade;

	public MainServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = null;
		String operation = request.getParameter("operation");
		if (operation.equals("userPage")) {
			url = "/UserPage.jsp";
			if (request.getParameter("btnSubmit").equals("Add User")) {
				UserProfile user = new UserProfile();
				if (facade.findUserByEmail(request.getParameter("txtEmail")) == null) {
					user.setEmail(request.getParameter("txtEmail"));
					user.setUserName(request.getParameter("txtUserName"));
					user.setBirthYear(request.getParameter("selBirthYear"));
					facade.createUser(user);
					List<UserProfile> allUsers = facade.findAllUsers();
					request.setAttribute("Success", "New User was succesfully added");
					request.setAttribute("allUsers", allUsers);
				} else {
					List<UserProfile> allUsers = facade.findAllUsers();
					request.setAttribute("Failure", "User with " + request.getParameter("txtEmail") + " already exist");
					request.setAttribute("allUsers", allUsers);
				}
			} else if (request.getParameter("btnSubmit").equals("Update User")) {
				UserProfile user = new UserProfile();
				user.setEmail(request.getParameter("txtEmail"));
				user.setUserName(request.getParameter("txtUserName"));
				user.setBirthYear(request.getParameter("selBirthYear"));
				facade.updateUser(user);
				List<UserProfile> allUsers = facade.findAllUsers();
				request.setAttribute("allUsers", allUsers);
				request.setAttribute("Success", "New User was succesfully updated");
			} else if (request.getParameter("btnSubmit").equals("Delete User")) { // Delete, används ej i GUI i nuläget.
				String email = request.getParameter("txtEmail");
				facade.deleteUser(email);
			}
		}
		if (operation.equals("userPageAllUsers")) {
			url = "/UserPage.jsp";
			List<UserProfile> allUsers = facade.findAllUsers();
			request.setAttribute("allUsers", allUsers);

		}
		if (operation.equals("moviePage")) {
			url = "/MoviePage.jsp";
			if (request.getParameter("btnSubmit").equals("Add Movie")) {
				Movie movie = new Movie();
				MovieId id = new MovieId();
				String movieName = request.getParameter("txtName");
				String releaseYear = request.getParameter("selReleaseYear");
				if (facade.findMovieById(movieName, releaseYear) == null) {
					id.setMovieName(movieName);
					id.setReleaseYear(releaseYear);
					movie.setId(id);
					movie.setDirector(request.getParameter("txtDirector"));
					movie.setGenre(request.getParameter("selGenre"));
					movie.setStreamingService(request.getParameter("selStreamingService"));
					facade.createMovie(movie);
					request.setAttribute("Success", "New movie was succesfully added");
					List<Movie> allMovies = facade.findAllMovie();
					request.setAttribute("allMovies", allMovies);
				} else {
					request.setAttribute("Failure",
							"Movie with title " + movieName + " and " + releaseYear + " already exist");
					List<Movie> allMovies = facade.findAllMovie();
					request.setAttribute("allMovies", allMovies);
				}
			} else if (request.getParameter("btnSubmit").equals("Update Movie")) {
				Movie movie = new Movie();
				MovieId id = new MovieId();
				id.setMovieName(request.getParameter("txtName"));
				id.setReleaseYear(request.getParameter("selReleaseYear"));
				movie.setId(id);
				movie.setDirector(request.getParameter("txtDirector"));
				movie.setGenre(request.getParameter("selGenre"));
				movie.setStreamingService(request.getParameter("selStreamingService"));
				facade.updateMovie(movie);
				List<Movie> allMovies = facade.findAllMovie();
				request.setAttribute("allMovies", allMovies);
				request.setAttribute("Success", "Movie was succesfully updated");
			} else if (request.getParameter("btnSubmit").equals("Delete Movie")) { // Delete, används ej i GUI i
																					// nuläget.
				String movieName = request.getParameter("txtName");
				String releaseYear = request.getParameter("selReleaseYear");
				facade.deleteMovie(movieName, releaseYear);
			}
		}
		if (operation.equals("moviePageAllMovies")) {
			url = "/MoviePage.jsp";
			List<Movie> allMovies = facade.findAllMovie();
			request.setAttribute("allMovies", allMovies);
		}
		if (operation.equals("ratingPage")) {
			url = "/RatingPage.jsp";
			Rating rating = new Rating();
			RatingId id = new RatingId();
			String email = request.getParameter("selEmail");
			String movieName = request.getParameter("txtTitle");
			String releaseYear = request.getParameter("txtReleaseYear");
			if (facade.findRatingById(movieName, releaseYear, email) == null) {
				id.setEmail(email);
				id.setMovieName(movieName);
				id.setReleaseYear(releaseYear);
				rating.setId(id);
				int grade = Integer.parseInt(request.getParameter("selRating"));
				rating.setRatingGrade(grade);
				rating.setReview(request.getParameter("textAreaReview"));
				facade.createRating(rating);
				List<String> allEmails = facade.getAllUserEmails();
				request.setAttribute("Success", "Rating was succesfully added");
				request.setAttribute("allEmails", allEmails);
				request.setAttribute("title", (request.getParameter("txtTitle")));
				request.setAttribute("releaseYear", (request.getParameter("txtReleaseYear")));
			} else {
				List<String> allEmails = facade.getAllUserEmails();
				request.setAttribute("Failure", "The movie is already rated by selected user");
				request.setAttribute("allEmails", allEmails);
				request.setAttribute("title", (request.getParameter("txtTitle")));
				request.setAttribute("releaseYear", (request.getParameter("txtReleaseYear")));
			}
		}
		if (operation.equals("moviePageToRating")) {
			String title = request.getParameter("inputMovieTitle");
			String year = request.getParameter("inputReleaseYear");
			if (request.getParameter("btnValue").equals("addBtn")) {
				url = "/RatingPage.jsp";
				List<String> allEmails = facade.getAllUserEmails();
				request.setAttribute("title", title);
				request.setAttribute("releaseYear", year);
				request.setAttribute("allEmails", allEmails);
			}
			if (request.getParameter("btnValue").equals("showBtn")) {
				url = "/ShowReview.jsp";
				Movie movie = facade.findMovieById(title, year);
				String averageRating = facade.getAvgRating(title, year);
				Set<Rating> tmp = movie.getRatings();
				List<Rating> ratings = new ArrayList<Rating>(tmp);
				request.setAttribute("allRatings", ratings);
				request.setAttribute("title", title);
				request.setAttribute("year", year);
				if (averageRating != null) {
					request.setAttribute("avgRating", averageRating);
				} else {
					request.setAttribute("avgRating", "This movie hasn't any ratings");
				}
			}
		}
		if (url != null) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
	}
}
