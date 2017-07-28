/**
 * Invoice Application accepts a list of prices and a tax rate, and outputs: price of each item, tax due amount, and total amount due
 */
package invoiceapplication;

/**
 * class Product: contains product attributes: price and product description
 * @author Anna Volkova
 */
public class Product {
	
	private double price;
	private String productDescription;
	
	public Product(){	
	}

	public Product(double price, String productDescription){	
		this.price = price;
		this.productDescription = productDescription;
	}
	
	public String getProductDescription() {
		return productDescription;
	}

	/**
	 * @param productDescription
	 */
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public double getPrice() {
		return price;
	}
	
	/**
	 * @param price
	 */
	public void setPrice(double price){
		this.price = price;
	}
	
}
