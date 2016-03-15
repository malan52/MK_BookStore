package model;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import bean.AddressBean;

public class AddressDAO {

	private DataSource ds;

	public AddressDAO() throws ClassNotFoundException {
		try {
			ds = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/EECS");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public Map<String, AddressBean> retrieve(String addressID) throws SQLException {
		String query = "SELECT A.ID, A.STREET, A.PROVINCE, A.COUNTRY, A.ZIP, A.PHONE from ADDRESS A where A.ID = " + Integer.parseInt(addressID);
		Map<String, AddressBean> rv = new HashMap<String, AddressBean>();
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		while (r.next()) {
			int id = r.getInt("ID");
			String street = r.getString("STREET");
			String province = r.getString("PROVINCE");
			String country = r.getString("COUNTRY");
			String zip = r.getString("ZIP");
			String phone = r.getString("PHONE");
			AddressBean address = new AddressBean(id, street, province, country, zip, phone);
			rv.put(id + "", address);
		}
		r.close();
		p.close();
		con.close();
		return rv;
	}

}
