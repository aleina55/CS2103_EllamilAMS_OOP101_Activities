import java.util.Scanner;

class Canteen{

    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);

    	System.out.println("====   M  E  N  U   ====");
    	System.out.println("1. Burger         - $80.00");
    	System.out.println("2. Pizza          - $120.00");
    	System.out.println("3. Pasta          - $100.00");
    	System.out.println("4. Sandwich       - $70.00");
    	System.out.println("5. Milk Tea       - $90.00\n");

    	double price1 = 80.00;
    	double price2 = 120.00;
    	double price3 = 100.00;
    	double price4 = 70.00;
    	double price5 = 90.00;
    	
    	int totalQuantity = 0;
    	double totalBeforeDiscount = 0.0;
    	double totalDiscount = 0.0;
    	double totalFinalAmount = 0.0;

    	char orderAgain;

    	do {
    		System.out.print("Enter item number: ");
    		int itemNumber = input.nextInt();

    		System.out.print("Enter quantity: ");
    		int quantity = input.nextInt();

    		boolean validItem = (itemNumber >= 1 && itemNumber <= 5);
    		boolean validQuantity = (quantity >= 1 && quantity <= 10);

    		if (!validItem || !validQuantity) {
    			System.out.println("\nInvalid order! Please enter a valid item and quantity.\n");	
    		} else {
    			System.out.print("Are you a student? (Y/N): ");
    			char studentAnswer = input.next().charAt(0);
    			boolean isStudent = (studentAnswer == 'Y' || studentAnswer == 'y');

    			double price = 0.00;
    			if (itemNumber == 1) {
    				price = price1;
    			} else if (itemNumber == 2) {
    				price = price2;
    			} else if (itemNumber == 3) {
    				price = price3;
    			} else if (itemNumber == 4) {
    				price = price4;
    			} else if (itemNumber == 5) {
    				price = price5;
    			}

    			double subtotal = price * quantity;

    			double discountRate;
    			if (isStudent && subtotal >= 500) {
    				discountRate = 0.15;
    			} else if (isStudent) {
    				discountRate = 0.10;
    			} else if (subtotal >= 500) {
    				discountRate = 0.05;
    			} else {
    				discountRate = 0.0;
    			}

    			double discountAmount = subtotal * discountRate;
    			double orderTotal = subtotal - discountAmount;

    			System.out.println();
                System.out.printf("Subtotal: $%.2f%n", subtotal);
                System.out.printf("Discount: $%.2f%n", discountAmount);
                System.out.printf("Order total: $%.2f%n", orderTotal);
                System.out.println();

    			totalQuantity = totalQuantity + quantity;
    			totalBeforeDiscount = totalBeforeDiscount + subtotal;
    			totalDiscount = totalDiscount + discountAmount;
    			totalFinalAmount = totalFinalAmount = totalFinalAmount + orderTotal;
    		}

            System.out.print("Do you want to order again? (Y/N): ");
            orderAgain = input.next().charAt(0);
            System.out.println();

    	} while (orderAgain == 'Y' || orderAgain == 'y');

    	System.out.println("====  ORDER SUMMARY  ====");
    	System.out.println("Total items: " + totalQuantity);
    	System.out.printf("Total before discount: $%.2f%n", totalBeforeDiscount);
    	System.out.printf("Total discount: $%.2f%n", totalDiscount);
    	System.out.printf("Final Amount: $%.2f%n", totalFinalAmount);
    	System.out.println("Thank you for ordering!");

    	input.close();
    }
	
}