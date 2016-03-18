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
	public void addBook(String bid, int quantity){
		try {
			BookBean book = bookAccessor.retrieveBook(bid);
			if(!books.containsKey(book))
				books.put(book, quantity);
			else{
				int oldAmount = books.get(book);
				books.put(book, oldAmount + quantity);
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
				books.remove(book);
			}
				
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * In shopping cart page, use this method to update the amount of a book.
	 * @param bid book id of the book to be added or dropped.
	 * @param quantity the target amount of the book.
	 */
	public void updateBookQuantity(String bid, int quantity){
		try {
			BookBean book = bookAccessor.retrieveBook(bid);
			books.put(book, quantity);
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @return number of books in cart.
	 */
	public int getSize(){
		int totalSize = 0;
		for(Integer temp : books.values()){
			totalSize += temp;
		}
		return totalSize;
	}
	
	/**
	 * @return the total price of all items in cart.
	 */
	public int getPrice(){
		int totalPrice = 0;
		for (Map.Entry<BookBean, Integer> entry : books.entrySet()){
			totalPrice += entry.getKey().getPrice() * entry.getValue();
		}
		return totalPrice;
	}

	/**
	 * @return the books
	 */
	public Map<BookBean, Integer> getBooks() {
		return books;
	}

	
}
