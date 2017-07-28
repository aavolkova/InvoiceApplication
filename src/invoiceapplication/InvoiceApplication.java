/**
 * Invoice Application
 */
package invoiceapplication;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class InvoiceApplication {
	/**
	 * This application accepts a list of prices and a tax rate, and outputs the
	 * following: 1. The price of each item you have added 2. The amount of tax
	 * due 3. The total amount due
	 * 
	 * @author Anna Volkova
	 * 
	 */

	public static void main(String[] args) {

		
		// Declare and initialize an array list variable 
		ArrayList<Product> productList = new ArrayList<Product>();

		
		// Declare variables
		double price;
		String productDescription = "";
		String response = "y";                 // This variable will get the user response if he/she chooses to continue or not
		int counter = 0;                       // This variable will be used to count and display the items number entered by user
		double taxRate;
		double totalPrice = 0;
		double totalTax = 0;
		double totlAmountDue = 0;
		
		
		// Declare format for the tax charged with up to 3 possible decimal places
		DecimalFormat df1 = new DecimalFormat("###.###");
		
		// Use this format before the modifications made for Bonus Points: Format the Item prices as currencies.
		// Declare format for allays showing 2 decimal places
		//DecimalFormat df2 = new DecimalFormat("0.00");
		
		// Declare format for the Item prices as currencies
		NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();
		
		
		// Create a Scanner object
		Scanner input = new Scanner(System.in);
		
		
		// Display the name of application
		System.out.println("     *** Invoice Application ***");
		System.out.println();

		// Prompt user for the tax rate
		System.out.println("Please enter the tax rate in percentage (%): ");
		// System.out.println("Please enter the tax rate (%): ");
		taxRate = input.nextDouble();

		do {

			// Prompt user for the price
			System.out.println("Please enter the product price: ");
			price = input.nextDouble();
			input.nextLine();
			// Prompt user for the product description
			System.out.println("Please enter the product description: ");
			productDescription = input.nextLine();

			productList.add(new Product(price, productDescription));

			// Prompt user to enter another product
			System.out.println("Would you like to enter another product (y/n)?");
			// Receive response from user
			response = input.nextLine();

			// Validate user's input
			while (!(response.equalsIgnoreCase("y") || response.equalsIgnoreCase("n"))) {
				// Display error message
				System.out.println("Error. You need to enter \"y\" or \"n\".");
				// Prompt user to enter another product
				System.out.println("Would you like to enter another product (y/n)?");
				// Receive response from user
				response = input.nextLine();
			}

		} while (response.equalsIgnoreCase("y"));

		// Calculations
		for (Product item : productList) {
			totalPrice += item.getPrice();          // Sum prices of each item to calculate Item Total
		}
		totalTax = totalPrice * taxRate / 100;		// Calculate total tax due
		totlAmountDue = totalPrice + totalTax;      // Calculate total amount due

		// Display Invoice
		System.out.println("Thank you for ordering products with us!");
		System.out.println("The list of items you purchased is below: ");
		System.out.println();
		System.out.println("===================================");
		System.out.println("      *****   Invoice   *****      ");
		System.out.println("===================================");
		
		//System.out.printf("%13s%17s", "DESCRIPTION", "PRICE");
		System.out.printf("%8s%26s", "ITEM", "PRICE");
		System.out.println();
		System.out.println("-----------------------------------");

		for (Product item : productList) {
			System.out.printf("%2d%s %-20s%11s", ++counter, ".", item.getProductDescription(), defaultFormat.format(item.getPrice()));
			System.out.println();
		}		
		
		System.out.println("-----------------------------------");
		
		System.out.printf("%-27s%8d", "Total Items Purchased:", counter);
		System.out.println();
		
		//System.out.println("Tax Rate: " + df1.format(taxRate) + "%");
		System.out.printf("%-27s%7s%s", "Tax Rate:", df1.format(taxRate), "%");
		System.out.println();
		System.out.println("-----------------------------------");
		
		
		//System.out.println("Item Total: $" + df2.format(totalPrice));
		//System.out.println("Tax Charged: $" + df2.format(totalTax));
		//System.out.println("Total Amount Due: $" + df2.format(totlAmountDue));
		//System.out.println();
		
		System.out.printf("%-22s%13s", "Item Total:", defaultFormat.format(totalPrice));
		System.out.println();
		System.out.printf("%-22s%13s", "Tax Charged:", defaultFormat.format(totalTax));
		System.out.println();
		System.out.printf("%-22s%13s", "Total Amount Due: ", defaultFormat.format(totlAmountDue));
		System.out.println();
		System.out.println("===================================");
		input.close();
	}

}

/*
Output:
    *** Invoice Application ***

Please enter the tax rate in percentage (%): 
7
Please enter the product price: 
456
Please enter the product description: 
Jacket 
Would you like to enter another product (y/n)?
y
Please enter the product price: 
456
Please enter the product description: 
Jacket 
Would you like to enter another product (y/n)?
n
Thank you for ordering products with us!
The list of items you purchased is below: 

===================================
      *****   Invoice   *****      
===================================
    ITEM                     PRICE
-----------------------------------
 1. Jacket                  $456.00
 2. Jacket                  $456.00
-----------------------------------
Total Items Purchased:            2
Tax Rate:                        7%
-----------------------------------
Item Total:                 $912.00
Tax Charged:                 $63.84
Total Amount Due:           $975.84
===================================
*/

