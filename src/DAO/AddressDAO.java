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

	/**
	 * Return the only billing address of this customer
	 * @param username
	 * @return the only billing address of this customer
	 * @throws SQLException
	 */
	public AddressBean retrieveBillingAddr(String username) throws SQLException {
		String query = "SELECT * from ADDRESS where USERNAME = '" + username + "' AND TYPE = 'Billing'";//only one billing address for one user
		AddressBean address = null;
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		if (r.next()) {
			//int id = r.getInt("ID");
			String addrusername = r.getString("USERNAME");
			String street = r.getString("STREET");
			String province = r.getString("PROVINCE");
			String country = r.getString("COUNTRY");
			String zip = r.getString("ZIP");
			String phone = r.getString("PHONE");
			String type = r.getString("TYPE");
			address = new AddressBean(addrusername, street, province, country, zip, phone, type);
		}
		r.close();
		p.close();
		con.close();
		return address;
	}
	
	/**
	 * Return an username's all past shipping address in a map with index
	 * @param addressID
	 * @return
	 * @throws SQLException
	 */
	public Map<Integer, AddressBean> retrieveShippingAddr(String username) throws SQLException {
		String query = "SELECT * from ADDRESS where USERNAME = '" + username + "' AND TYPE = 'Shipping'";//one user may have more than one shipping address
		Map<Integer, AddressBean> map = new HashMap<Integer, AddressBean>();
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		while (r.next()) {
			int id = r.getInt("ID");
			String addrusername = r.getString("USERNAME");
			String street = r.getString("STREET");
			String province = r.getString("PROVINCE");
			String country = r.getString("COUNTRY");
			String zip = r.getString("ZIP");
			String phone = r.getString("PHONE");
			String type = r.getString("TYPE");
			map.put(id, new AddressBean(addrusername, street, province, country, zip, phone, type));
		}
		r.close();
		p.close();
		con.close();
		return map;
	}
	
	public AddressBean retrieveAddr(int addrID) throws SQLException {
		String query = "SELECT * FROM Address WHERE ID = " + addrID;
		AddressBean address = null;
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		if (r.next()) {
			String addrusername = r.getString("USERNAME");
			String street = r.getString("STREET");
			String province = r.getString("PROVINCE");
			String country = r.getString("COUNTRY");
			String zip = r.getString("ZIP");
			String phone = r.getString("PHONE");
			String type = r.getString("TYPE");
			address = new AddressBean(addrusername, street, province, country, zip, phone, type);
		}
		r.close();
		p.close();
		con.close();
		return address;
	}
	
	/**
	 * Update a new customer' address
	 */
	public void updateAddr(AddressBean addr) throws SQLException {
		String queryadd = "INSERT INTO Address VALUES ('" + addr.getUsername() + "', '" + addr.getStreet() + "', '"
				+ addr.getProvince() + "', '" + addr.getCountry() + "', '" + addr.getZip() + "', '" + addr.getPhone()
				+ "', '" + addr.getType() + "')";
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(queryadd);
		p.executeUpdate();
		p.close();
		con.close();
	}

	/*public Map<String, AddressBean> retrieveAll() throws SQLException {
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
			String type = r.getString("TYPE");
			AddressBean address = new AddressBean(id, street, province, country, zip, phone, type);
			rv.put(id, address);
		}
		r.close();
		p.close();
		con.close();
		return rv;
	}*/
}
