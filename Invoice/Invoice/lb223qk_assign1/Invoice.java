 // A program that a hardware store can use to represent an item sold in the store.
 
package lb223qk_assign1;

class Invoice {
	String partNumber;
	String description;
	int quantity;
	double price;

	Invoice(String partNumber, String description, int quantity, double price) {
		this.partNumber = partNumber;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
	}

	public String getPartNumber() {
		return partNumber;
	}

	public String getDescription() {
		return description;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setPrice(double price) {
		this.price = price;
		if (price > 0)
			this.price = price;
		else
			this.price = 0;

	}

	public double getInvoiceAmount(int price) {

		double invoiceAmount = price * quantity;
		if (invoiceAmount < 0)
			invoiceAmount = 0;
		return invoiceAmount;
	}

}