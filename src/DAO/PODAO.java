package DAO;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import bean.POBean;

public class PODAO {

	private DataSource ds;

	public PODAO() throws ClassNotFoundException {
		try {
			ds = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/EECS");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public POBean retrievePO(String POID) throws SQLException {
		String query = "SELECT P.ID, P.LNAME, P.FNAME, P.STATUS, P.ADDRESS from PO where P.ID = '" + Integer.parseInt(POID) + "'";
		POBean po = null;
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		while (r.next()) {
			int id = r.getInt("ID");
			String lname = r.getString("LNAME");
			String fname = r.getString("FNAME");
			String status = r.getString("STATUS");
			int address = r.getInt("ADDRESS");
			po = new POBean(id, lname, fname, status, address);
		}
		r.close();
		p.close();
		con.close();
		return po;
	}
	
	public Map<String, POBean> retrieveAll() throws SQLException {
		String query = "SELECT * from PO";
		Map<String, POBean> rv = new HashMap<String, POBean>();
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		while (r.next()) {
			int id = r.getInt("ID");
			String lname = r.getString("LNAME");
			String fname = r.getString("FNAME");
			String status = r.getString("STATUS");
			int address = r.getInt("ADDRESS");
			POBean po = new POBean(id, lname, fname, status, address);
			rv.put(id + "", po);
		}
		r.close();
		p.close();
		con.close();
		return rv;
	}

}
