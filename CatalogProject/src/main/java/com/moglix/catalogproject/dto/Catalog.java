package com.moglix.catalogproject.dto;

public class Catalog {
	//
	public Catalog(String productId, String productName, String catId, String productDescription, String productImage) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.catId = catId;
		this.productDescription = productDescription;
		this.productImage = productImage;
	}
	private String productId;
	private String productName;
	private String catId;
	private String productDescription;
	private String productImage;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCatId() {
		return catId;
	}
	public void setCatId(String catId) {
		this.catId = catId;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
public  Catalog() {
	
	
	
}
@Override      //generate hashcode and equals.
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((catId == null) ? 0 : catId.hashCode());
	result = prime * result + ((productDescription == null) ? 0 : productDescription.hashCode());
	result = prime * result + ((productId == null) ? 0 : productId.hashCode());
	result = prime * result + ((productImage == null) ? 0 : productImage.hashCode());
	result = prime * result + ((productName == null) ? 0 : productName.hashCode());
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
	Catalog other = (Catalog) obj;
	if (catId == null) {
		if (other.catId != null)
			return false;
	} else if (!catId.equals(other.catId))
		return false;
	if (productDescription == null) {
		if (other.productDescription != null)
			return false;
	} else if (!productDescription.equals(other.productDescription))
		return false;
	if (productId == null) {
		if (other.productId != null)
			return false;
	} else if (!productId.equals(other.productId))
		return false;
	if (productImage == null) {
		if (other.productImage != null)
			return false;
	} else if (!productImage.equals(other.productImage))
		return false;
	if (productName == null) {
		if (other.productName != null)
			return false;
	} else if (!productName.equals(other.productName))
		return false;
	return true;
}
@Override
public String toString() {
	return "Catalog [productId=" + productId + ", productName=" + productName + ", catId=" + catId
			+ ", productDescription=" + productDescription + ", productImage=" + productImage + "]";
}

}

