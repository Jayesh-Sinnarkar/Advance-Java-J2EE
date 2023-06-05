package com.app.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.TeamDao;
import com.app.dao.TeamDaoImpl;

/**
 * Servlet implementation class TeamsServelet
 */
@WebServlet("/team")
public class TeamsServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TeamDao teamDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamsServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    @Override
	public void init() throws ServletException {
		ServletConfig sc = getServletConfig();
		String url = sc.getInitParameter("url");
		String uname = sc.getInitParameter("userName");
		String passwd = sc.getInitParameter("password");
		try {
			teamDao = new TeamDaoImpl(url,uname,passwd);
			System.out.println("Connection Success");
		
		} catch (SQLException e) {
			
			throw new ServletException("Error in init"+e.getMessage());
		}

	}
    
    @Override  
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		res.setContentType("text/html");
		try(PrintWriter pw = res.getWriter())
		{
			pw.write("<h1>Hello</h1>");
			
			
		}catch(Exception e)
		{
			System.out.println("Error in doGet");
			throw e;
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("In destroy");
		
	}

	

}
