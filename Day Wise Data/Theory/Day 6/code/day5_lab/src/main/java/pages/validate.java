package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PlayerDaoImpl;
import dao.TeamDaoImpl;
import pojos.Player;
import pojos.Team;

/**
 * Servlet implementation class validate
 */
@WebServlet(value="/validate",loadOnStartup = 2)
public class validate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PlayerDaoImpl player;
	private TeamDaoImpl teamDao;
	
	
       
   
    public validate() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    

	@Override
	public void init() throws ServletException {
		// create team dao instance
		try {
			teamDao = new TeamDaoImpl();
			player = new PlayerDaoImpl();
		} catch (SQLException e) {
			throw new ServletException("err in init " + getClass(), e);
		}
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try (PrintWriter pw = response.getWriter())
		{  
		//HttpSession sh = request.getSession();
		//teamDao = (TeamDaoImpl) sh.getAttribute("TeamDao");
			
		//int teamId = Integer.parseInt(request.getParameter("team_id"));
		String firstName = request.getParameter("player_fname");
		String lastName = request.getParameter("player_lname");
		Date dob = Date.valueOf(request.getParameter("dob"));
		int age = Period.between(dob.toLocalDate(), LocalDate.now()).getYears();
		double battingAvg = Double.parseDouble(request.getParameter("avg"));
		int wicketsTaken = Integer.parseInt(request.getParameter("wickets"));
		String teamAbbr = request.getParameter("teamAbbr");
		Team selectedTeam = teamDao.getTeam(teamAbbr);
		
		if(selectedTeam.getBattingAvg()>battingAvg && selectedTeam.getWicketsTaken()>wicketsTaken && selectedTeam.getMaxAge()<age)
		{
			pw.print("<h3 align='center'>Sorry!!! you are not eligible player as per selected team: </h3>");
			pw.print(selectedTeam);
		}
		else {
			int teamId = selectedTeam.getTeamId();
			System.out.println("Team id is"+teamId);
			Player selectedPlayer = new Player(firstName, lastName, dob, battingAvg, wicketsTaken, teamId);
			
			int no = player.insertPlayer(selectedPlayer); //(firstName, lastName, dob, battingAvg, wicketsTaken, teamId);
			
			if(no==1)
				pw.print("<h3 align='center'>Player "+selectedPlayer+" inserted sucessfully</h3>");
			else
				pw.print("<h3 align='center'>Could not update player in Database</h3>");

			}
		
			
			
		} catch (SQLException e) {
			
			throw new ServletException("err while accessing Teams DB " + getClass(), e);
		}

	}

}
