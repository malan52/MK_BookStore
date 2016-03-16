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

import bean.*;
import DAO.*;
import model.*;

/**
 * Servlet implementation class Start
 */
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
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
