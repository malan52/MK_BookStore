package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import DAO.*;
import bean.*;

public class BSData {
	
	private AddressDAO address;
	private BookDAO book;
	private CustomerDAO customer;
	private PODAO PO;
	private POItemDAO POItem;
	private ReviewDAO review;
	private VisitEventDAO VisitEvent;

	public BSData() {
		try {
			address = new AddressDAO();
			book = new BookDAO();
			customer = new CustomerDAO();
			PO = new PODAO();
			POItem = new POItemDAO();
			review = new ReviewDAO();
			VisitEvent = new VisitEventDAO();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public BookBean retrieveBook(String bookID) throws Exception {
		return book.retrieveBook(bookID);
	}
	
	public ArrayList<ReviewBean> retrieveAllReview(String bookID) throws Exception {
		return review.retrieveAllReview(bookID);
	}
}
