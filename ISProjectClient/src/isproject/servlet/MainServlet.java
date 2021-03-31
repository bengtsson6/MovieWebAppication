package isproject.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
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
		System.out.println(operation);
		if (operation.equals("userPage")) {
			url = "/UserPage.jsp";
			if (request.getParameter("btnSubmit").equals("Add User")) {
				UserProfile user = new UserProfile();
				if (!request.getParameter("txtEmail").equals("")) {
					user.setEmail(request.getParameter("txtEmail"));
				}
				user.setUserName(request.getParameter("txtUserName"));
				user.setBirthYear(request.getParameter("selBirthYear"));
				facade.createUser(user);
				List<UserProfile> allUsers = facade.findAllUsers();
				request.setAttribute("Success", "New User was succesfully added");
				request.setAttribute("allUsers", allUsers);
			} else if (request.getParameter("btnSubmit").equals("Update User")) {
				UserProfile user = new UserProfile();
				user.setEmail(request.getParameter("txtEmail"));
				user.setUserName(request.getParameter("txtUserName"));
				user.setBirthYear(request.getParameter("selBirthYear"));
				facade.updateUser(user);
				List<UserProfile> allUsers = facade.findAllUsers();
				request.setAttribute("allUsers", allUsers);
				request.setAttribute("Success", "New User was succesfully updated");
			} else if (request.getParameter("btnSubmit").equals("Delete User")) { // Delete, anv�nds ej i GUI i nul�get.
				String email = request.getParameter("txtEmail");
				facade.deleteUser(email);
			}
		}
		if (operation.equals("userPageAllUsers")) {
			System.out.println("HEJ");
			url = "/UserPage.jsp";
			List<UserProfile> allUsers = facade.findAllUsers();
			request.setAttribute("allUsers", allUsers);
			
		}
		if (operation.equals("moviePage")) {
			url = "/MoviePage.jsp";
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
				request.setAttribute("Success", "New movie was succesfully added");
			} else if (request.getParameter("btnSubmit").equals("Update Movie")) {
				Movie movie = new Movie();
				MovieId id = new MovieId();
				id.setMovieName(request.getParameter("txtName"));
				id.setReleaseYear(request.getParameter("selReleaseYear"));
				movie.setId(id);
				movie.setDirector(request.getParameter("txtDirector"));
				movie.setGenre(request.getParameter("txtGenre"));
				movie.setStreamingService(request.getParameter("txtStreamingService"));
				facade.updateMovie(movie);
				request.setAttribute("Success", "Movie was succesfully updated");
			} else if (request.getParameter("btnSubmit").equals("Delete Movie")) { // Delete, anv�nds ej i GUI i
																					// nul�get.
				String movieName = request.getParameter("txtName");
				String releaseYear = request.getParameter("selReleaseYear");
				facade.deleteMovie(movieName, releaseYear);
			}
		}

		if (url != null) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
	}

}