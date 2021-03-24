package isproject.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import isproject.ejb.Rating;
import isproject.ejb.RatingId;
import isproject.facade.FacadeLocal;


@WebServlet("/RatingServlet")
public class RatingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @EJB
    FacadeLocal facade;
    
    public RatingServlet() {
        super();

    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html><html><head>");
		out.println("<title>RatingServlet</title>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("</head><body>");
		out.println("<h2>Ratings</h2>");
		
		RatingId id = new RatingId();
		Rating rating = new Rating();
		id.setEmail("Bob@gmail.com");
		id.setMovieName("Hajen");
		id.setReleaseYear("1970");
		
		rating.setId(id);
		rating.setRatingGrade(7);
		rating.setReview("Sweat horror Movie");
		
		//facade.createRating(rating);
		facade.updateRating(rating);
		Rating r = facade.findRatingById(rating.getId().getMovieName(), rating.getId().getReleaseYear(), rating.getId().getEmail());
		RatingId id2 = r.getId();
		out.println("<br><h4>Newly created rating</h4>");
		out.print("<h4>" + id2.getMovieName() + " ");
		out.print(r.getId().getReleaseYear() + " ");
		out.print(r.getId().getEmail() + " ");
		out.print(r.getRatingGrade() + " ");
		out.print(r.getReview()+"</h4>");
	}
}
