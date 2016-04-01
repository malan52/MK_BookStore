package test;

import bean.*;
import DAO.*;
import model.*;

public class TestDriver {
	
	public boolean result = true;

	public TestDriver() {
	}

	/**
	 * Test cases for AddressBean class
	 * @return String with error message
	 */
	public String checkAddressBean() {
		String username = "Cherry";
		String street = "12 Eglinton St.";
		String province = "Ontario";
		String country = "Canada";
		String zip = "M2N 6X8";
		String phone = "6471231234";
		String type = AddressBean.BILLING;
		AddressBean addr = new AddressBean(username, street, province, country, zip, phone, type);
		//t0
		if (!addr.getUsername().equals(username)) {
			result = false;
			return "t0: getUsername return wrong answer.";
		}
		//t1
		else if (!addr.getStreet().equals(street)) {
			result = false;
			return "t1: getUsername return wrong answer.";
		}
		//t2
		else if (!addr.getProvince().equals(province)) {
			result = false;
			return "t2: getProvince return wrong answer.";
		}
		//t3
		else if (!addr.getCountry().equals(country)) {
			result = false;
			return "t3: getCountry return wrong answer.";
		}
		//t4
		else if (!addr.getZip().equals(zip)) {
			result = false;
			return "t4: getZip return wrong answer.";
		}
		//t5
		else if (!addr.getPhone().equals(phone)) {
			result = false;
			return "t5: getPhone return wrong answer.";
		}
		//t6
		else if (!addr.getType().equals(type)) {
			result = false;
			return "t6: getType return wrong answer.";
		}
		String new_username = "Harry";
		String new_street = "45 McLaughlin Ave";
		String new_province = "New York";
		String new_country = "USA";
		String new_zip = "11423";
		String new_phone = "3451231234";
		String new_type = AddressBean.SHIPPING;
		//t7
		addr.setUsername(new_username);
		if (!addr.getUsername().equals(new_username)) {
			result = false;
			return "t7: setUsername not work correctly.";
		}
		//t8
		addr.setStreet(new_street);
		if (!addr.getStreet().equals(new_street)) {
			result = false;
			return "t8: setStreet not work correctly.";
		}
		//t9
		addr.setProvince(new_province);
		if (!addr.getProvince().equals(new_province)) {
			result = false;
			return "t9: setProvince not work correctly.";
		}
		//t10
		addr.setCountry(new_country);
		if (!addr.getCountry().equals(new_country)) {
			result = false;
			return "t10: setCountry not work correctly.";
		}
		//t11
		addr.setZip(new_zip);
		if (!addr.getZip().equals(new_zip)) {
			result = false;
			return "t11: setZip not work correctly.";
		}
		//t12
		addr.setPhone(new_phone);
		if (!addr.getPhone().equals(new_phone)) {
			result = false;
			return "t12: setPhone not work correctly.";
		}
		//t13
		addr.setType(new_type);
		if (!addr.getType().equals(new_type)) {
			result = false;
			return "t13: setType not work correctly.";
		}
		return "checkAddressBean test success!\n";
	}

	/**
	 * Test cases for BookBean class
	 * @return String with error message
	 */
	public String checkBookBean() {
		if (!result)
			return "";
		String bid = "b100";
		String title = "Book number 100";
		int price = 100;
		String category = "Math";
		BookBean book = new BookBean(bid, title, price, category);
		//t0
		if (!book.getBid().equals(bid)) {
			result = false;
			return "t0: getBid return wrong answer.";
		}
		//t1
		if (!book.getTitle().equals(title)) {
			result = false;
			return "t1: getTitle return wrong answer.";
		}
		//t2
		if (book.getPrice() != price) {
			result = false;
			return "t2: getPrice return wrong answer.";
		}
		//t3
		if (!book.getCategory().equals(category)) {
			result = false;
			return "t3: getCategory return wrong answer.";
		}
		String new_bid = "b200";
		String new_title = "Book number 200";
		int new_price = 200;
		String new_category = "History";
		//t4
		book.setBid(new_bid);
		if (!book.getBid().equals(new_bid)) {
			result = false;
			return "t4: setBid not work correctly.";
		}
		//t5
		book.setTitle(new_title);
		if (!book.getTitle().equals(new_title)) {
			result = false;
			return "t5: setTitle not work correctly.";
		}
		//t6
		book.setPrice(new_price);
		if (book.getPrice() != new_price) {
			result = false;
			return "t6: setPrice not work correctly.";
		}
		//t7
		book.setCategory(new_category);
		if (!book.getCategory().equals(new_category)) {
			result = false;
			return "t7: setCategory not work correctly.";
		}
		return "checkBookBean test success!\n";
	}
	
	/**
	 * Test cases for ProfileBean class
	 * @return String with error message
	 */
	public String checkProfileBean() {
		if (!result)
			return "";
		String username = "User";
		String fname = "Roger";
		String lname = "Sun";
		String email = "rogersun@gmail.com";
		ProfileBean profile = new ProfileBean(username, fname, lname, email);
		//t0
		if (!profile.getUsername().equals(username)) {
			result = false;
			return "t0: getUsername return wrong answer.";
		}
		//t1
		if (!profile.getFname().equals(fname)) {
			result = false;
			return "t1: getFname return wrong answer.";
		}
		//t2
		if (!profile.getLname().equals(lname)) {
			result = false;
			return "t1: getLname return wrong answer.";
		}
		//t3
		if (!profile.getEmail().equals(email)) {
			result = false;
			return "t1: getEmail return wrong answer.";
		}
		String new_username = "New User";
		String new_fname = "Steven";
		String new_lname = "Allen";
		String new_email = "stevenallen@hotmail.com";
		//t4
		profile.setUsername(new_username);
		if (!profile.getUsername().equals(new_username)) {
			result = false;
			return "t4: setUsername not work correctly.";
		}
		//t5
		profile.setFname(new_fname);
		if (!profile.getFname().equals(new_fname)) {
			result = false;
			return "t5: setFname not work correctly.";
		}
		//t6
		profile.setLname(new_lname);
		if (!profile.getLname().equals(new_lname)) {
			result = false;
			return "t6: setLname not work correctly.";
		}
		//t7
		profile.setEmail(new_email);
		if (!profile.getEmail().equals(new_email)) {
			result = false;
			return "t4: setEmail not work correctly.";
		}
		return "checkProfileBean test success!\n";
	}
	
	/**
	 * Test cases for POBean class
	 * @return String with error message
	 */
	public String checkPOBean() {
		
	}
	
	/**
	 * Test cases for POItemBean class
	 * @return String with error message
	 */
	public String checkPOItemBean() {
		if (!result)
			return "";
		String PO_id = "201611111111111";
		String bid = "b100";
		int quantity = 10;
		POItemBean item = new POItemBean(PO_id, bid, quantity);
		//t0
		if (!item.getPO_id().equals(PO_id)) {
			result = false;
			return "t0: getPO_id return wrong answer.";
		}
		//t1
		if (!item.getBid().equals(bid)) {
			result = false;
			return "t1: getBid return wrong answer.";
		}
		//t2
		if (item.getQuantity() != quantity) {
			result = false;
			return "t2: getQuantity return wrong answer.";
		}
		String new_PO_id = "201622222222222";
		String new_bid = "b200";
		int new_quantity = 20;
		//t3
		item.setPO_id(new_PO_id);
		if (!item.getPO_id().equals(new_PO_id)) {
			result = false;
			return "t3: setPO_id not work correctly.";
		}
		//t4
		item.setBid(new_bid);
		if (!item.getBid().equals(new_bid)) {
			result = false;
			return "t4: setBid not work correctly.";
		}
		//t5
		item.setQuantity(new_quantity);
		if (item.getQuantity() != new_quantity) {
			result = false;
			return "t5: setQuantity not work correctly.";
		}
		return "checkPOItemBean test success!\n";
	}
	
	/**
	 * Test cases for CustomerBean class
	 * @return String with error message
	 */
	public String checkCustomerBean() {
		if (!result)
			return "";
		String username = "User";
		String password = "123123";
		ProfileBean profile = new ProfileBean(username);
		CustomerBean customer = new CustomerBean(username, password, profile);
		//t0
		if (!customer.getUsername().equals(username)) {
			result = false;
			return "t0: getUsername return wrong answer.";
		}
		//t1
		if (!customer.getPassword().equals(password)) {
			result = false;
			return "t1: getPassword return wrong answer.";
		}
		//t2
		if (!customer.getProfile().equals(profile)) {
			result = false;
			return "t2: getProfile return wrong answer.";
		}
		String new_username = "New User";
		String new_password = "321321";
		ProfileBean new_profile = new ProfileBean(new_username);
		//t3
		customer.setUsername(new_username);
		if (!customer.getUsername().equals(new_username)) {
			result = false;
			return "t3: setUsername not work correctly.";
		}
		//t4
		customer.setPassword(new_password);
		if (!customer.getPassword().equals(new_password)) {
			result = false;
			return "t4: setPassword not work correctly.";
		}
		//t5
		customer.setProfile(new_profile);
		if (!customer.getProfile().equals(new_profile)) {
			result = false;
			return "t5: setProfile not work correctly.";
		}
		return "checkCustomerBean test success!\n";
	}
	
	/**
	 * Test cases for ReviewBean class
	 * @return String with error message
	 */
	public String checkReviewBean() {
		
	}
	
	/**
	 * Test cases for VisitEventBean class
	 * @return String with error message
	 */
	public String checkVisitEventBean() {
		
	}
	
	
	
	public static void main(String[] args) {
		TestDriver td = new TestDriver();
		String result = td.checkAddressBean();
		result = result + td.checkBookBean();
		result = result + td.checkProfileBean();
		result = result + td.checkPOItemBean();
		result = result + td.checkCustomerBean();
		System.out.println(td.result);
		System.out.println(result);
	}

}
