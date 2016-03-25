package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import bean.BookBean;

public class BookDAO {

	private DataSource ds;
	private int book;

	public BookDAO() throws ClassNotFoundException {
		try {
			ds = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/EECS");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public BookBean retrieveBook(String bookID) throws SQLException {
		String query = "select B.BID, B.TITLE, B.PRICE, B.CATEGORY from BOOK B where B.BID = '" + bookID + "'";
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		BookBean book = null;
		while (r.next()) {
			String bid = r.getString("BID");
			String title = r.getString("TITLE");
			int price = r.getInt("PRICE");
			String category = r.getString("CATEGORY");
			book = new BookBean(bid, title, price, category);
		}
		r.close();
		p.close();
		con.close();
		return book;
	}
	
	public Map<String, BookBean> retrieveAll() throws SQLException {
		String query = "select * from BOOK";
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		Map<String, BookBean> rv = new HashMap<String, BookBean>();
		while (r.next()) {
			String bid = r.getString("BID");
			String title = r.getString("TITLE");
			int price = r.getInt("PRICE");
			String category = r.getString("CATEGORY");
			BookBean book = new BookBean(bid, title, price, category);
			rv.put(bid, book);
		}
		r.close();
		p.close();
		con.close();
		return rv;
	}
	
	public ArrayList<String> retrieveCategories() throws SQLException {
		String query = "select distinct category from BOOK order by category";
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		ArrayList<String> rv = new ArrayList<String>();
		while (r.next()) { 
			String category = r.getString("CATEGORY");;
			rv.add(category);
		}
		r.close();
		p.close();
		con.close();
		return rv;
	}
	
	public Map<String, BookBean> retrieveCategory(String category) throws SQLException {
		String query = "select * from BOOK B where B.category = " + "\'" + category + "\'" + "order by B.category";
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		Map<String, BookBean> rv = new HashMap<String, BookBean>();
		while (r.next()) {
			String bid = r.getString("BID");
			String title = r.getString("TITLE");
			int price = r.getInt("PRICE");
			String cate = r.getString("CATEGORY");
			BookBean book = new BookBean(bid, title, price, cate);
			rv.put(bid, book);
		}
		r.close();
		p.close();
		con.close();
		return rv;
	}
	

}
