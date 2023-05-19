package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class HelloServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in do-get"+ Thread.currentThread());
		//set response content type
		resp.setContentType("text/html");
		//get PW to send buffered text data from server to client
		try(PrintWriter pw=resp.getWriter())
		{
//			pw.print("<h4>Hello from servelet,  Servlet TS: "+LocalDateTime.now()+"</h4>");
			pw.print("<h4> Add a player to IPL team </h4><br>"
					+ "Select Team: <select name='selTeam' value='Select Team'> "
					+ "<option>MI</option>"
					+"<option>RCB</option>"
					+ "<option>CSK</option>"
					+"<select>");
			
		}

	}

	@Override
	public void destroy() {
		System.out.println("in destroy"+ Thread.currentThread());

	}

	@Override
	public void init() throws ServletException {
		System.out.println("in init"+ Thread.currentThread());
	}
	

}
