package model;

import DAO.*;

public class BSData {
	
	private AddressDAO address;
	private BookDAO book;
	private PODAO PO;
	private POItemDAO POItem;
	private VisitEventDAO VisitEvent;

	public BSData() {
		try {
			address = new AddressDAO();
			book = new BookDAO();
			PO = new PODAO();
			POItem = new POItemDAO();
			VisitEvent = new VisitEventDAO();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
