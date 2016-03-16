package DAO;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import bean.POItemBean;

public class POItemDAO {

	private DataSource ds;

	public POItemDAO() throws ClassNotFoundException {
		try {
			ds = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/EECS");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public Map<String, POItemBean> retrieve(String POID, String bookID) throws SQLException {
		String query = "select P.ID, P.BID, P.PRICE from POITEM P where P.ID = " + Integer.parseInt(POID) 
				+ " and P.BID = '" + bookID + "'";
		Map<String, POItemBean> rv = new HashMap<String, POItemBean>();
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		while (r.next()) {
			int id = r.getInt("ID");
			String bid = r.getString("BID");
			int price = r.getInt("PRICE");
			POItemBean POItem = new POItemBean(id, bid, price);
			rv.put(id + "", POItem);
		}
		r.close();
		p.close();
		con.close();
		return rv;
	}

}
