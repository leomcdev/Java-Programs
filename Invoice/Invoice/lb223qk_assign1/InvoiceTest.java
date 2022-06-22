package lb223qk_assign1;

public class InvoiceTest {

	public static void main(String[] args) {

		int price = 0;
		Invoice invoice1 = new Invoice("15", "Drill(s)", 3, 9.9);
		Invoice invoice2 = new Invoice("10", "Hammer(s)", 5, 6.6);

		System.out.println("Invoice for the Item(s) Sold: " + "\n");
		System.out.println(invoice1.getPartNumber() + "\t" + invoice1.getDescription() + "\t" + invoice1.getQuantity()
				+ "\t" + invoice1.getPrice() + "\t" + invoice1.getInvoiceAmount(price) + "\n");

		System.out.println("Invoice for the Item(s) Sold: " + "\n");
		System.out.println(invoice2.getPartNumber() + "\t" + invoice2.getDescription() + "\t" + invoice2.getQuantity()
				+ "\t" + invoice2.getPrice() + "\t" + invoice2.getInvoiceAmount(price));

	}
}