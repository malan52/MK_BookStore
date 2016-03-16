package ctrl;

<<<<<<< HEAD
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
=======
import java.io.*;
import java.sql.*;
import java.util.*;
>>>>>>> malan

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
import DAO.BookDAO;
import bean.BookBean;
=======
import bean.*;
import DAO.*;
import model.*;
>>>>>>> malan

/**
 * Servlet implementation class Start
 */
<<<<<<< HEAD
@WebServlet({"/Start"})
public class Start extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Start() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

=======
@WebServlet("/Start")
public class Start extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
    	// TODO Auto-generated method stub
    }
    
>>>>>>> malan
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		request.getRequestDispatcher("/test.jspx").forward(request, response);
		try {
			Map <String, BookBean> temp = new BookDAO().retrieve("b001");
			this.getServletContext().setAttribute("temp", temp.get("b001"));
			System.out.println(temp.get("b001"));
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
=======
		response.setContentType("text/html");
		
		try {
			Map <String, BookBean> temp = new BookDAO().retrieve("b001");
			System.out.println(temp.get("b001").toString());
			request.setAttribute("temp", temp);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/Hello.jspx").forward(request, response);
>>>>>>> malan
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
