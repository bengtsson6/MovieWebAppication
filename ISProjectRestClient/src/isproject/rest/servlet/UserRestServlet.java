package isproject.rest.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import isproject.ejb.UserProfile;
import isproject.facade.FacadeLocal;

/**
 * Servlet implementation class UserRestServlet
 */
@WebServlet("/UserRestServlet/*")
public class UserRestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	FacadeLocal facade;

	public UserRestServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		if (pathInfo == null || pathInfo.equals("/")) {
			List<UserProfile> allUsers = facade.findAllUsers();
			sendAsJson(response, allUsers);
			return;
		}
		String[] splits = pathInfo.split("/");
		if (splits.length != 2) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		String id = splits[1];
		UserProfile user = facade.findUserByEmail(id);
		sendAsJson(response, user);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		if (pathInfo == null || pathInfo.equals("/")) {
			BufferedReader reader = request.getReader();
			UserProfile user = parseJsonUser(reader);
			try {
				user = facade.createUser(user);
			} catch (Exception e){
				
			}
			sendAsJson(response, user);
		}
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		
		if(pathInfo == null || pathInfo.equals("/")) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		String[] splits = pathInfo.split("/");
		if(splits.length != 2) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		BufferedReader reader = request.getReader();
		UserProfile user = parseJsonUser(reader);
		try {
			facade.updateUser(user);	
		} catch (Exception e) {
			
		}
		sendAsJson(response, user);

	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		if (pathInfo == null || pathInfo.equals("/")) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		String[] splits = pathInfo.split("/");
		if(splits.length != 2) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		String id = splits[1];
		UserProfile user = facade.findUserByEmail(id);
		if(user != null) {
			facade.deleteUser(id);
		}
		sendAsJson(response, user);
	}

	private void sendAsJson(HttpServletResponse response, UserProfile user) throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");

		if (user != null) {
			out.print("{\"email\":");
			out.print("\"" + user.getEmail() + "\"");
			out.print(",\"name\":");
			out.print("\"" + user.getUserName() + "\"");
			out.print(",\"birthyear\":");
			out.print("\"" + user.getBirthYear() + "\"}");
		} else {
			{
			}
		}
		out.flush();
	}

	private void sendAsJson(HttpServletResponse response, List<UserProfile> allUsers) throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");

		if (allUsers != null) {
			JsonArrayBuilder array = Json.createArrayBuilder();
			for (UserProfile user : allUsers) {
				JsonObjectBuilder o = Json.createObjectBuilder();
				o.add("email", String.valueOf(user.getEmail()));
				o.add("name", String.valueOf(user.getUserName()));
				o.add("birthyear", String.valueOf(user.getBirthYear()));
				array.add(o);
			}
			JsonArray jsonArray = array.build();
			out.print(jsonArray);
		} else {
			out.print("[]");
		}
		out.flush();
	}
	
	private UserProfile parseJsonUser(BufferedReader reader) {
		JsonReader jsonReader = null;
		JsonObject jsonRoot = null;
		
		jsonReader = Json.createReader(reader);
		jsonRoot = jsonReader.readObject();
		UserProfile user = new UserProfile();
		user.setEmail(jsonRoot.getString("email"));
		user.setUserName(jsonRoot.getString("name"));
		user.setBirthYear(jsonRoot.getString("birthyear"));
		return user;
	}
}
