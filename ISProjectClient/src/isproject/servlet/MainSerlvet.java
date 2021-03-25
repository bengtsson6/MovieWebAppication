package isproject.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import isproject.ejb.Movie;
import isproject.ejb.MovieId;
import isproject.ejb.UserProfile;
import isproject.facade.FacadeLocal;

/**
 * Servlet implementation class MainSerlvet
 */
@WebServlet("/MainSerlvet")
public class MainSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	FacadeLocal facade;

	public MainSerlvet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Hej");
		String operation = request.getParameter("operation");
		if (operation.equals("userPage")) {
			if (request.getParameter("btnSubmit").equals("Add User")) {
				UserProfile user = new UserProfile();
				if (!request.getParameter("txtEmail").equals("")) {
					user.setEmail(request.getParameter("txtEmail"));
				}
				user.setUserName(request.getParameter("txtUserName"));
				user.setBirthYear(request.getParameter("selBirthYear"));
				facade.createUser(user);
			}
			else if(request.getParameter("btnSubmit").equals("Update User")) {
				UserProfile user = new UserProfile();
				user.setEmail(request.getParameter("txtEmail"));
				user.setUserName(request.getParameter("txtUserName"));
				user.setBirthYear(request.getParameter("selBirthYear"));
				facade.updateUser(user);	
			}
			else if(request.getParameter("btnSubmit").equals("Delete User")) {
				String email = request.getParameter("txtEmail");
				facade.deleteUser(email);	
			}
		}
		if (operation.equals("moviePage")) {
			if (request.getParameter("btnSubmit").equals("Add Movie")) {
				Movie movie = new Movie();
				MovieId id = new MovieId();
				id.setMovieName(request.getParameter("txtName"));
				id.setReleaseYear(request.getParameter("selReleaseYear"));
				movie.setId(id);
				movie.setDirector(request.getParameter("txtDirector"));
				movie.setGenre(request.getParameter("txtGenre"));
				movie.setStreamingService(request.getParameter("txtStreamingService"));
				facade.createMovie(movie);
			}
			else if (request.getParameter("btnSubmit").equals("Update Movie")) {
				Movie movie = new Movie();
				MovieId id = new MovieId();
				id.setMovieName(request.getParameter("txtName"));
				id.setReleaseYear(request.getParameter("selReleaseYear"));
				movie.setId(id);
				movie.setDirector(request.getParameter("txtDirector"));
				movie.setGenre(request.getParameter("txtGenre"));
				movie.setStreamingService(request.getParameter("txtStreamingService"));
				facade.updateMovie(movie);
			}
			else if (request.getParameter("btnSubmit").equals("Delete Movie")) {
				String movieName = request.getParameter("txtName");
				String releaseYear = request.getParameter("selReleaseYear");
				facade.deleteMovie(movieName, releaseYear);
			}
		}
	}

}
