package pages;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TeamDaoImpl;
import pojos.Player;

/**
 * Servlet implementation class validate
 */
@WebServlet("/validate")
public class validate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public validate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		
		int teamId = Integer.parseInt(request.getParameter("team_id"));
		String firstName = request.getParameter("player_fname");
		String lastName = request.getParameter("player_lname");
		Date dob = Date.valueOf(request.getParameter("dob"));
		double battingAvg = Double.parseDouble(request.getParameter("avg"));
		int wicketsTaken = Integer.parseInt(request.getParameter("wickets"));
		
		TeamDaoImpl.getTeam(teamId);
		

	}

}
