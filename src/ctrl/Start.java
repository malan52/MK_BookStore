package ctrl;


import java.io.*;
import java.sql.*;
import java.util.*;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.*;
import DAO.*;
import model.*;

/**
 * Servlet implementation class Start
 */
@WebServlet("/Start")
public class Start extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String MAIN_URL = "/main.jspx";

    /**
     * Default constructor. 
     */
    public Start() {
        // TODO Auto-generated constructor stub
    	super();
    }

    /**
    	 * @see Servlet#init(ServletConfig)
    */
    public void init(ServletConfig config) throws ServletException {
    	BookDAO bookAccessor = null;
		try {
			bookAccessor = new BookDAO();
	    	config.getServletContext().setAttribute("bookAccessor", bookAccessor);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		HttpSession session = request.getSession();
		
		try {
			if(session.getAttribute("cart") == null){
				request.getSession().setAttribute("cart", new ShoppingCart());
			}
			
			if(session.getAttribute("categories") == null){
				ArrayList<String> categories = new BookDAO().retrieveCategories();
				request.getServletContext().setAttribute("categories", categories);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher(MAIN_URL).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
