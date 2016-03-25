package bean;

public class CreditInfoBean {
	private static final int VISA = 1;
	private static final int MASTER_CARD = 2;
	private static final int AMERICAN_EXPRESS = 3;
	
	private String username;
	private int cardType;
	private String cardHolder;
	private String cardNumber;
	private int expireM;
	private int expireY;
	private AddressBean bAddress;
	
	/**
	 * @param username
	 * @param cardType
	 * @param cardHolder
	 * @param cardNumber
	 * @param expireM
	 * @param expireY
	 * @param bAddress
	 */
	
	public CreditInfoBean(String username, int type, String holder, String cardNumber, int expireM, int expireY, AddressBean bAddress) {
		super();
		this.setUsername(username);
		this.cardType = type;
		this.cardHolder = holder;
		this.cardNumber = cardNumber;
		this.expireM = expireM;
		this.expireY = expireY;
		this.bAddress = bAddress;
	}
	
	public CreditInfoBean(String username){
		this(username, 1, "default", "default", 1, 1, null);
	}
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @return the type
	 */
	public int getCardType() {
		return cardType;
	}
	/**
	 * @return the holder
	 */
	public String getCardHolder() {
		return cardHolder;
	}
	/**
	 * @return the cardNumber
	 */
	public String getCardNumber() {
		return cardNumber;
	}
	/**
	 * @return the expireM
	 */
	public int getExpireM() {
		return expireM;
	}
	/**
	 * @return the expireY
	 */
	public int getExpireY() {
		return expireY;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @param type the type to set
	 */
	public void setCardType(int type) {
		this.cardType = type;
	}
	/**
	 * @param holder the holder to set
	 */
	public void setCardHolder(String holder) {
		this.cardHolder = holder;
	}
	/**
	 * @param cardNumber the cardNumber to set
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	/**
	 * @param expireM the expireM to set
	 */
	public void setExpireM(int expireM) {
		this.expireM = expireM;
	}
	/**
	 * @param expireY the expireY to set
	 */
	public void setExpireY(int expireY) {
		this.expireY = expireY;
	}
	/**
	 * @return the bAddress
	 */
	public AddressBean getbAddress() {
		return bAddress;
	}

	/**
	 * @param bAddress the bAddress to set
	 */
	public void setbAddress(AddressBean bAddress) {
		this.bAddress = bAddress;
	}

	/**
	 * 
	 */
	public String toString() {
		return "Username: " + username
				+ "\nCard Type: " + cardType
				+ "\nCard Holder: " + cardHolder
				+ "\nCard Number: " + cardNumber
				+ "\nExpire Month: " + expireM
				+ "\nExpire Year: " + expireY;
	}
	
}
