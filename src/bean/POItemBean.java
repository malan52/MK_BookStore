package bean;

//import javax.xml.bind.annotation.XmlRootElement;
//import javax.xml.bind.annotation.XmlType;

//@XmlRootElement(name="sisReport")
//@XmlType(propOrder={"id", "bid", "price"})
public class POItemBean {

	private int id;
	private String bid;
	private int price;
	
	public POItemBean(int id, String bid, int price) {
		this.setId(id);
		this.setBid(bid);
		this.setPrice(price);
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the bid
	 */
	public String getBid() {
		return bid;
	}

	/**
	 * @param bid the bid to set
	 */
	public void setBid(String bid) {
		this.bid = bid;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

}