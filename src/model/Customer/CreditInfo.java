package model.Customer;

public class CreditInfo {
	private static final int VISA = 1;
	private static final int MASTER_CARD = 2;
	private static final int AMERICAN_EXPRESS = 3;
	
	private int type;
	private String holder;
	private int cardNumber;
	private int expireM;
	private int expireY;
	
	/**
	 * @param type
	 * @param holder
	 * @param cardNumber
	 * @param expireM
	 * @param expireY
	 */
	
	public CreditInfo(int type, String holder, int cardNumber, int expireM, int expireY) {
		super();
		this.type = type;
		this.holder = holder;
		this.cardNumber = cardNumber;
		this.expireM = expireM;
		this.expireY = expireY;
	}
	
	public CreditInfo(){
		this(1, null, 0, 1, 2017);
	}
	
	/**
	 * 
	 */


	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}
	/**
	 * @return the holder
	 */
	public String getHolder() {
		return holder;
	}
	/**
	 * @return the cardNumber
	 */
	public int getCardNumber() {
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
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}
	/**
	 * @param holder the holder to set
	 */
	public void setHolder(String holder) {
		this.holder = holder;
	}
	/**
	 * @param cardNumber the cardNumber to set
	 */
	public void setCardNumber(int cardNumber) {
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
	
}
