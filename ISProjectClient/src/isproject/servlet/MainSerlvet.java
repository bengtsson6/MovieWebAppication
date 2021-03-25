package isproject.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
				user.setEmail(request.getParameter("txtEmail"));
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
		}
	}

}
