package ctrl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Enter the Register servelet!");
		
		request.getSession().setAttribute("user", request.getParameter("usr"));
		System.out.println(request.getSession().getAttribute("user"));
		
		request.getSession().setAttribute("password", request.getParameter("password"));
		System.out.println(request.getSession().getAttribute("password"));
		/////////////////////////////////////////////////////////////////////////////////////////////////
		request.getSession().setAttribute("phone", request.getParameter("phone"));
		System.out.println(request.getSession().getAttribute("phone"));

		request.getSession().setAttribute("country", request.getParameter("country"));
		System.out.println(request.getSession().getAttribute("country"));
		
		request.getSession().setAttribute("state", request.getParameter("state"));
		System.out.println(request.getSession().getAttribute("state"));
		
		request.getSession().setAttribute("zip", request.getParameter("zip"));
		System.out.println(request.getSession().getAttribute("zip"));
		
		request.getSession().setAttribute("adrs", request.getParameter("adrs"));
		System.out.println(request.getSession().getAttribute("adrs"));
		///////////////////////////////////////////////////////////////////////////////////////////////
		request.getSession().setAttribute("sfname", request.getParameter("sfname"));
		System.out.println(request.getSession().getAttribute("sfname"));
		
		request.getSession().setAttribute("slname", request.getParameter("slname"));
		System.out.println(request.getSession().getAttribute("slname"));
		
		request.getSession().setAttribute("sphone", request.getParameter("sphone"));
		System.out.println(request.getSession().getAttribute("sphone"));

		request.getSession().setAttribute("scountry", request.getParameter("scountry"));
		System.out.println(request.getSession().getAttribute("scountry"));
		
		request.getSession().setAttribute("sstate", request.getParameter("sstate"));
		System.out.println(request.getSession().getAttribute("sstate"));
		
		request.getSession().setAttribute("szip", request.getParameter("szip"));
		System.out.println(request.getSession().getAttribute("zip"));
		
		request.getSession().setAttribute("sadrs", request.getParameter("sadrs"));
		System.out.println(request.getSession().getAttribute("sadrs"));
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
