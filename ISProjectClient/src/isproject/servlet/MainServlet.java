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

import isproject.assistance.ObjectCreator;
import isproject.ejb.Movie;
import isproject.ejb.Rating;
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

		String url = "/HomePage.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = null;
		String operation = request.getParameter("operation");
		if (operation.equals("userPage")) {
			url = "/UserPage.jsp";
			String email = request.getParameter("txtEmail");
			String name = request.getParameter("txtUserName");
			String birthYear = request.getParameter("selBirthYear");
			if (request.getParameter("btnSubmit").equals("Add User")) {
				if (facade.findUserByEmail(email) == null) {
					UserProfile user = ObjectCreator.createUserObject(email, name, birthYear);
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

				if (facade.findUserByEmail(request.getParameter("txtEmail")) != null) {
					UserProfile user = ObjectCreator.createUserObject(email, name, birthYear);
					facade.updateUser(user);
					List<UserProfile> allUsers = facade.findAllUsers();
					request.setAttribute("allUsers", allUsers);
					request.setAttribute("Success", "User was succesfully updated");
				} else {
					List<UserProfile> allUsers = facade.findAllUsers();
					request.setAttribute("allUsers", allUsers);
					request.setAttribute("Failure", "Couldn't find user to update, try add user instead");
				}
			} else if (request.getParameter("btnSubmit").equals("Delete User")) {
				if (facade.findUserByEmail(email) != null) {
					facade.deleteUser(email);
					List<UserProfile> allUsers = facade.findAllUsers();
					request.setAttribute("allUsers", allUsers);
					request.setAttribute("Success", "User was succesfully deleted");
				} else {
					List<UserProfile> allUsers = facade.findAllUsers();
					request.setAttribute("allUsers", allUsers);
					request.setAttribute("Failure", "Coudn't find user to delete");
				}
			}
		}
		if (operation.equals("userPageAllUsers")) {
			url = "/UserPage.jsp";
			List<UserProfile> allUsers = facade.findAllUsers();
			request.setAttribute("allUsers", allUsers);

		}
		if (operation.equals("moviePage")) {
			url = "/MoviePage.jsp";
			String movieName = request.getParameter("txtName");
			String releaseYear = request.getParameter("selReleaseYear");
			String director = request.getParameter("txtDirector");
			String genre = request.getParameter("selGenre");
			String streamingService = request.getParameter("selStreamingService");
			if (request.getParameter("btnSubmit").equals("Add Movie")) {
				if (facade.findMovieById(movieName, releaseYear) == null) {
					Movie movie = ObjectCreator.createMovieObject(movieName, releaseYear, director, genre, streamingService);
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
				if (facade.findMovieById(movieName, releaseYear) != null) {
					Movie movie = ObjectCreator.createMovieObject(movieName, releaseYear, director, genre, streamingService);
					facade.updateMovie(movie);
					List<Movie> allMovies = facade.findAllMovie();
					request.setAttribute("allMovies", allMovies);
					request.setAttribute("Success", "Movie was succesfully updated");
				} else {
					List<Movie> allMovies = facade.findAllMovie();
					request.setAttribute("allMovies", allMovies);
					request.setAttribute("Failure", "Coudn't find movie to update, try add the movie");
				}
			} else if (request.getParameter("btnSubmit").equals("Delete Movie")) {
				if (facade.findMovieById(movieName, releaseYear) != null) {
					facade.deleteMovie(movieName, releaseYear);
					List<Movie> allMovies = facade.findAllMovie();
					request.setAttribute("allMovies", allMovies);
					request.setAttribute("Success", "Movie was succesfully deleted");
				} else {
					List<Movie> allMovies = facade.findAllMovie();
					request.setAttribute("allMovies", allMovies);
					request.setAttribute("Failure", "Coudn't find movie to delete");
				}
			}
		}
		if (operation.equals("moviePageAllMovies")) {
			url = "/MoviePage.jsp";
			List<Movie> allMovies = facade.findAllMovie();
			request.setAttribute("allMovies", allMovies);
		}
		if (operation.equals("ratingPage")) {
			url = "/RatingPage.jsp";
			String email = request.getParameter("selEmail");
			String movieName = request.getParameter("txtTitle");
			String releaseYear = request.getParameter("txtReleaseYear");
			int grade = Integer.parseInt(request.getParameter("selRating"));
			String review = request.getParameter("textAreaReview");
			if (facade.findRatingById(movieName, releaseYear, email) == null) {
				Rating rating = ObjectCreator.createRatingObject(movieName, releaseYear, email, grade, review);
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
