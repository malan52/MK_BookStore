package ctrl;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.*;
import model.*;
import bean.*;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			BookDAO bdao = new BookDAO();
			PODAO poDAO = new PODAO();
			AddressDAO aDAO = new AddressDAO();
			POData podata = new POData();
			ShoppingCart sc = new ShoppingCart();

			/*Map<POBean, Map<String, Integer>> sample = new HashMap<POBean, Map<String, Integer>>();
			Map<String, Integer> book = new HashMap<String, Integer>();
			book.put("b001", 1);
			book.put("b002", 2);
			sample.put(new POBean("Roger", POBean.ORDERED, aDAO.retrieveAddrByID(1), "Hehe", "Meng"), book);
			book.put("b003", 3);
			sample.put(new POBean("Roger", POBean.DENIED, aDAO.retrieveAddrByID(411), "Zhao", "Rihe"), book);*/

			
			request.setAttribute("sample", podata.retrievePO("Roger"));
			request.getRequestDispatcher("/myAccount.jspx").forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
