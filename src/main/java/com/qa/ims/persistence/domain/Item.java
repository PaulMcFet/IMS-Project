package com.qa.ims.persistence.domain;

public class Item {

	private Long ProductID;
	private String ItemName;
	private Float Price;
	
	public Item(String ItemName, Float Price) {
		this.setItemName(ItemName);
		this.setPrice(Price);

	}

	public Item(Long ID, String ItemName, Float Price) {
		this.setProductID(ProductID);
		this.setItemName(ItemName);
		this.setPrice(Price);	
}

	public Long getProductID() {
		return ProductID;
	}

	public void setProductID(Long ProductID) {
		this.ProductID = ProductID;
	}

	public String getItemName() {
		return ItemName;
	}

	public void setItemName(String ItemName) {
		this.ItemName = ItemName;
	}

	public Float getPrice() {
		return Price;
	}

	public void setPrice(Float Price) {
		this.Price = Price;
	}

	@Override
	public String toString() {
		return "Product ID:" + ProductID + "Title:" + ItemName + " Price:" + Price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ItemName == null) ? 0 : ItemName.hashCode());
		result = prime * result + ((ProductID == null) ? 0 : ProductID.hashCode());
		result = prime * result + ((Price == null) ? 0 : Price.hashCode());
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
		Item other = (Item) obj;
		if (getItemName() == null) {
			if (other.getItemName() != null)
				return false;
		} else if (!getItemName().equals(other.getItemName()))
			return false;
		if (ProductID == null) {
			if (other.ProductID != null)
				return false;
		} else if (!ProductID.equals(other.ProductID))
			return false;
		if (Price == null) {
			if (other.Price != null)
				return false;
		} else if (!Price.equals(other.Price))
			return false;
		return true;
	}

}