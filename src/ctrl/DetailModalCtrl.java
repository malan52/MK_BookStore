package ctrl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BookBean;
import bean.ReviewBean;
import model.BSData;
import model.ShoppingCart;

/**
 * Servlet implementation class DetailModalCtrl
 */
@WebServlet("/DetailModalCtrl")
public class DetailModalCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailModalCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BSData ba = new BSData();
		String bid = (String) request.getAttribute("bid");
		if(bid != null){
			
			try {
				request.setAttribute("dm_book", ba.retrieveBook(bid));
				request.setAttribute("reviews", ba.retrieveAllReview(bid));
				BookBean book = ba.retrieveBook(bid);
				ArrayList<ReviewBean> reviews = ba.retrieveAllReview(bid);
				for(ReviewBean review : reviews){
					response.getWriter().println(review.getRating() + ","
							+ review.getReview() + "," + review.getUsername());
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
