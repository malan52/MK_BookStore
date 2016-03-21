package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import bean.*;

public class ReviewDAO {

	private DataSource ds;

	public ReviewDAO() throws ClassNotFoundException {
		try {
			ds = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/EECS");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Giving an username return a CustomerBean with the username and stored
	 * password if username exist. Return null CostomerBean if username is not
	 * exist in database
	 */
	public ReviewBean retrieveReview(String bookID, String username) throws SQLException {
		String query = "SELECT * FROM Review WHERE bid = '" + bookID + "' AND username = '" + username + "'";
		ReviewBean review = null;
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		if (r.next())
			review = new ReviewBean(bookID, username, r.getInt("RATING"), r.getString("REVIEW"));
		r.close();
		p.close();
		con.close();
		return review;
	}

	/*
	 * Update a new customer or update an exist customer's password
	 */
	public void updateReview(ReviewBean review) throws SQLException {
		String queryget = "SELECT * FROM Review WHERE bid = '" + review.getBid() + "' AND username = '"
				+ review.getUsername() + "'";
		String queryadd = "INSERT INTO Review VALUES ('" + review.getBid() + "', '" + review.getUsername() + "', "
				+ review.getRating() + ", '" + review.getReview() + "')";
		String queryupdate = "UPDATE Review SET \"RATING\"=" + review.getRating() + ", \"REVIEW\"='"
				+ review.getReview() + "' WHERE \"BID\"='" + review.getBid() + "' AND \"USERNAME\"='"
				+ review.getUsername() + "'";
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(queryget);
		ResultSet r = p.executeQuery();
		if (r.next()) { // user exist, update password
			p = con.prepareStatement(queryupdate);
			p.executeUpdate();
		} else { // user not exist, insert new instance
			p = con.prepareStatement(queryadd);
			p.executeUpdate();
		}
		r.close();
		p.close();
		con.close();
	}

}
