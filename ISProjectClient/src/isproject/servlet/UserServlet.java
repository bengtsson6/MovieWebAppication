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

import isproject.ejb.UserProfile;
import isproject.facade.FacadeLocal;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    @EJB
    FacadeLocal facade;
    
	public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html><html><head>");
		out.println("<title>UserServlet</title>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("</head><body>");
		out.println("<h2>UserProfile</h2>");
		out.println("</body></html>");
		
		List<UserProfile> allUser = facade.findAllUsers();
		
		out.println("<h2>All Users</h2>");
		for(UserProfile user : allUser) {
			out.print("<h4>" + user.getEmail() + " ");
			out.print(user.getUserName() + " ");
			out.print(user.getBirthYear()+"</h4>");
		}
		
		out.println("<br><h4>Is named Gustav</h4>");
		List<UserProfile> allUsersNamedGustav = facade.findUserByName("%Gustav%");
		for (UserProfile user2 : allUsersNamedGustav) {
			out.print("<h4>" + user2.getEmail() + " ");
			out.print(user2.getUserName() + " ");
			out.print(user2.getBirthYear()+"</h4>");
		}
		out.println("</body></html>");
	}

}
