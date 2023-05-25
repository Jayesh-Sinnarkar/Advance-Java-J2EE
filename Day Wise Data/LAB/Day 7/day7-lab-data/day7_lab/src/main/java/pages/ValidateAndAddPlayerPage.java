package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PlayerDaoImpl;
import dao.TeamDaoImpl;

/**
 * Servlet implementation class ValidateAndAddPlayerPage
 */
@WebServlet("/validate")
public class ValidateAndAddPlayerPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			// get session
			HttpSession session = request.getSession();
			// get daos
			TeamDaoImpl teamDao = (TeamDaoImpl) session.getAttribute("team_dao");
			PlayerDaoImpl playerDao = (PlayerDaoImpl) session.getAttribute("player_dao");
			// get req params --parse --validation
			int teamId = Integer.parseInt(request.getParameter("team_id"));
			// dob : LocalDate.parse(....) --> age : Period.between --> compare max age :
			// compare it with db data --success
			//Date.valueOf(localdate)
			//in case of success : playerDao's --insert
		}
	}

}
