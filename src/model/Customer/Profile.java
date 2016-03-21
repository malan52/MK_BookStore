package model.Customer;

import bean.AddressBean;

public class Profile {
	private String fname;
	private String lname;
	private AddressBean billingAddress;
	private String email;
	/**
	 * @param fname
	 * @param lname
	 * @param billingAddress
	 * @param email
	 */
	public Profile(String fname, String lname, AddressBean billingAddress, String email) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.billingAddress = billingAddress;
		this.email = email;
	}
	
	public Profile(){
		this("", "", null, "");
	}

	/**
	 * @return the first name
	 */
	public String getFname() {
		return fname;
	}

	/**
	 * @return the last name
	 */
	public String getLname() {
		return lname;
	}

	/**
	 * @return the billingAddress
	 */
	public AddressBean getBillingAddress() {
		return billingAddress;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param fname the first name to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}

	/**
	 * @param lname the last name to set
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}

	/**
	 * @param billingAddress the billingAddress to set
	 */
	public void setBillingAddress(AddressBean billingAddress) {
		this.billingAddress = billingAddress;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
}
