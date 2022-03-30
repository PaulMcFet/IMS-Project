package com.qa.ims.persistence.domain;

public class Order {

	private Long OrderID;
	private Long ID;
	private Long PurchaseID;

	public Order(Long ID, Long OrderID) {
		this.setPurchaseID(PurchaseID);
	}

	public Order(Long PurchaseID, Long ID, Long OrderID) {
		this.setId(ID);
		this.setOrderID(OrderID);
		this.setPurchaseID(PurchaseID);
	}

	public Long getOrderID() {
		return OrderID;
	}

	public void setOrderID(Long OrderID) {
		OrderID = OrderID;
	}

	public Long getID() {
		return ID;
	}

	public void setId(Long id) {
		this.ID = id;
	}

	public Long getPurchaseID() {
		return PurchaseID;
	}

	public void setPurchaseID(Long PurchaseID) {
		PurchaseID = PurchaseID;
	}

	@Override
	public String toString() {
		return "Order [OrderID=" + getOrderID() + ", ID=" + getID() + ", PurchaseID=" + getPurchaseID() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((PurchaseID == null) ? 0 : PurchaseID.hashCode());
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		result = prime * result + ((OrderID == null) ? 0 : OrderID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (getOrderID() == null) {
			if (other.getOrderID() != null)
				return false;
		} else if (!getOrderID().equals(other.getOrderID()))
			return false;
		if (PurchaseID == null) {
			if (other.PurchaseID != null)
				return false;
		} else if (!PurchaseID.equals(other.PurchaseID))
		return false;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		return true;
	}

}