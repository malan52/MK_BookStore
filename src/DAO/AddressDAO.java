package DAO;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import bean.AddressBean;
import bean.CustomerBean;

public class AddressDAO {

	private DataSource ds;

	public AddressDAO() throws ClassNotFoundException {
		try {
			ds = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/EECS");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public AddressBean retrieveAddr(String addressID) throws SQLException {
		String query = "SELECT * from ADDRESS A where A.ID = '" + addressID + "'";
		AddressBean address = null;
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		if (r.next()) {
			String id = r.getString("ID");
			String street = r.getString("STREET");
			String province = r.getString("PROVINCE");
			String country = r.getString("COUNTRY");
			String zip = r.getString("ZIP");
			String phone = r.getString("PHONE");
			address = new AddressBean(id, street, province, country, zip, phone);
		}
		r.close();
		p.close();
		con.close();
		return address;
	}

	/*
	 * Update a new customer' address or update an exist customer's address
	 */
	public void updateAddr(AddressBean addr) throws SQLException {
		String queryget = "SELECT * FROM Address WHERE id = '" + addr.getId() + "'";
		String queryadd = "INSERT INTO Address VALUES ('" + addr.getId() + "', '" + addr.getStreet() + "', '"
				+ addr.getProvince() + "', '" + addr.getCountry() + "', '" + addr.getZip() + "', '" + addr.getPhone()
				+ "')";
		String queryupdate = "UPDATE Address SET \"STREET\"='" + addr.getStreet() + "', \"PROVINCE\"='"
				+ addr.getProvince() + "', \"COUNTRY\"='" + addr.getCountry() + "', \"ZIP\"='" + addr.getZip()
				+ "', \"PHONE\"='" + addr.getPhone() + "' WHERE \"ID\"='" + addr.getId() + "'";
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

	public Map<String, AddressBean> retrieveAll() throws SQLException {
		String query = "SELECT * from ADDRESS";
		Map<String, AddressBean> rv = new HashMap<String, AddressBean>();
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		while (r.next()) {
			String id = r.getString("ID");
			String street = r.getString("STREET");
			String province = r.getString("PROVINCE");
			String country = r.getString("COUNTRY");
			String zip = r.getString("ZIP");
			String phone = r.getString("PHONE");
			AddressBean address = new AddressBean(id, street, province, country, zip, phone);
			rv.put(id, address);
		}
		r.close();
		p.close();
		con.close();
		return rv;
	}
}
