package model.Customer;

public class Customer {
	private String username;
	private String password;
	private Profile profile;
	private CreditInfo creditInfo;
	/**
	 * @param username
	 * @param password
	 * @param profile
	 * @param creditInfo
	 */
	public Customer(String username, String password, Profile profile, CreditInfo creditInfo) {
		super();
		this.username = username;
		this.password = password;
		this.profile = profile;
		this.creditInfo = creditInfo;
	}
	
	public Customer(String username, String password){
		this(username, password, new Profile(), new CreditInfo());
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the profile
	 */
	public Profile getProfile() {
		return profile;
	}

	/**
	 * @return the creditInfo
	 */
	public CreditInfo getCreditInfo() {
		return creditInfo;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param profile the profile to set
	 */
	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	/**
	 * @param creditInfo the creditInfo to set
	 */
	public void setCreditInfo(CreditInfo creditInfo) {
		this.creditInfo = creditInfo;
	}
	
	
	
}
