package model;

import java.sql.SQLException;
import java.util.*;

import DAO.BookDAO;
import bean.BookBean;

public class ShoppingCart {
	private Map<BookBean, Integer> books; // Key is the book object and value 
										  // is the amount of the purchased book.
	private BookDAO bookAccessor;	// The data access object.
	
	
	/**
	 *  Create a empty shopping cart object.
	 * @throws ClassNotFoundException 
	 */
	public ShoppingCart() throws ClassNotFoundException {
		super();
		this.books = new HashMap<BookBean, Integer>();
		this.bookAccessor = new BookDAO();
	}

	/**
	 * Add a book to cart.
	 * @param bid
	 */
	public void addBook(String bid){
		try {
			BookBean book = bookAccessor.retrieveBook(bid);
			if(!books.containsKey(book))
				books.put(book, 1);
			else{
				int oldAmount = books.get(book);
				books.put(book, oldAmount + 1);
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Drop a book from cart.
	 * @param bid
	 */
	public void dropBook(String bid){
		try {
			BookBean book = bookAccessor.retrieveBook(bid);
			if(books.containsKey(book)){
				if(books.get(book) == 1)
					books.remove(book);
				else{
					int oldAmount = books.get(book);
					books.put(book, oldAmount - 1);
				}
			}
				
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @return the books in cart.
	 */
	public Map<BookBean, Integer> getBooks() {
		return books;
	}

	/**
	 * @return size of cart.
	 */
	public int size(){
		return books.size();
	}
}
