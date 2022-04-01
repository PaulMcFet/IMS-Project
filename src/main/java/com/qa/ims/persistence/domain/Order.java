package com.qa.ims.persistence.domain;

public class Order {

	private Long OrderID;
	private Long ID;
	private Long ProductID;

	public Order(Long OrderID, Long ID, Long ProductID) {
		this.setOrderID(OrderID);
	}

	public Order(Long ID, Long ProductID) {
		this.setID(ID);
		this.setProductID(ProductID);
		this.setOrderID(OrderID);
	}

	@Override
	public String toString() {
		return "Order [OrderID=" + getOrderID() + ", ID=" + getID() + ", ProductID=" + getProductID() + "]";
	}

	public Long getOrderID() {
		return OrderID;
	}

	public void setOrderID(Long orderID) {
		this.OrderID = orderID;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long ID) {
		this.ID = ID;
	}

	public Long getProductID() {
		return ProductID;
	}

	public void setProductID(Long productID) {
		this.ProductID = productID;
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
		if (ProductID == null) {
			if (other.ProductID != null)
				return false;
		} else if (!ProductID.equals(other.ProductID))
			return false;
		return true;
	}

}