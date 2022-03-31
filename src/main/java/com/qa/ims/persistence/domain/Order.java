package com.qa.ims.persistence.domain;

public class Order {

	private Long OrderID;
	private Long ID;


	public Order(Long OrderID, Long ID) {
		this.setOrderID(OrderID);
	}

	public Order(Long ID) {
		this.setId(ID);
		this.setOrderID(OrderID);
	}
//TASK, When generating Getters/Setters, the "this." command was not included. Find out why.

	public Long getOrderID() {
		return OrderID;
	}

	public void setOrderID(Long OrderID) {
		this.OrderID = OrderID;
	}

	public Long getID() {
		return ID;
	}

	public void setId(Long ID) {
		this.ID = ID;
	}

	@Override
	public String toString() {
		return "Order [OrderID=" + getOrderID() + ", ID=" + getID() + ", OrderID=" + getOrderID() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((OrderID == null) ? 0 : OrderID.hashCode());
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
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
		if (OrderID == null) {
			if (other.OrderID != null)
				return false;
		} else if (!OrderID.equals(other.OrderID))
		return false;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		return true;
	}

}