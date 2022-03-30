package com.qa.ims.persistence.domain;

public class Order {

	private Long ProductID;
	private Long ID;
	private Long OrderID;

	public Order(Long ID, Long ProductID) {
		this.setOrderID(OrderID);
	}

	public Order(Long OrderID, Long ID, Long ProductID) {
		this.setId(ID);
		this.setProductID(ProductID);
		this.setOrderID(OrderID);
	}

	public Long getProductID() {
		return ProductID;
	}

	public void setProductID(Long ProductID) {
		ProductID = ProductID;
	}

	public Long getID() {
		return ID;
	}

	public void setId(Long id) {
		this.ID = id;
	}

	public Long getOrderID() {
		return OrderID;
	}

	public void setOrderID(Long orderID) {
		OrderID = orderID;
	}

	@Override
	public String toString() {
		return "Order [ProductID=" + getProductID() + ", ID=" + getID() + ", OrderID=" + getOrderID() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((OrderID == null) ? 0 : OrderID.hashCode());
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		result = prime * result + ((ProductID == null) ? 0 : ProductID.hashCode());
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
		if (getProductID() == null) {
			if (other.getProductID() != null)
				return false;
		} else if (!getProductID().equals(other.getProductID()))
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