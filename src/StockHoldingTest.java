import java.util.Scanner;
public class StockHoldingTest {
	private static Scanner input;

	public static void main(String[] args) {
		Question1();
		Question2();
		Question3();
	}

	private static void Question1() {
		//3 instance of StockHolding
		StockHolding []stockHolder = new StockHolding[3];
		System.out.println("Enter 3 companies details");
		
		//loop for data input
		for(int i=0;i<3;i++)
		{
			//prompt for user input
			System.out.println("Enter Company Name, Purchase Price, Current Price and Number of Shares:");
			input = new Scanner(System.in);
			String Name = input.next();
			float purchasePrice = input.nextFloat();
			float currentPrice = input.nextFloat();
			int numberOfShares = input.nextInt();
						
			//call constructor of Stock Holding Class
			stockHolder[i] =new StockHolding(Name, purchasePrice, currentPrice, numberOfShares);
		}
		
		//Bubble Sort for alphabetical order
		LexicographicalSort(stockHolder);
		
		//Displaying Content
		for(StockHolding share:stockHolder)
			share.display();
		
	} //end question1
	
	private static void Question2() {
		//3 instance of StockHolding
		StockHolding []stockHolder = new StockHolding[5];

		stockHolder[0] = new StockHolding("Expedia", 2.30f, 4.50f, 50);
		stockHolder[1] = new StockHolding("Oracle", 12.19f, 10.56f, 90);
		stockHolder[2] = new StockHolding("Adobe", 45.10f, 49.51f, 210);
		stockHolder[3] = new ForeignStockHolding("Microsoft", 45.10f, 49.51f, 210, 1.2f);
		stockHolder[4] = new ForeignStockHolding("Facebook", 2.30f, 4.50f, 40, 0.94f);
				
		//Bubble Sort for alphabetical order
		ReverseLexicographicalSort(stockHolder);
				
		//Displaying Content
		for(StockHolding share:stockHolder)
			share.display();
	} //end Question2

	private static void Question3() {
		int numberOfStocks;
		System.out.println("Enter number of stocks(MAX-8): ");
		numberOfStocks = input.nextInt();
		StockHolding stockHolder[] = new StockHolding[numberOfStocks];
		
		for(int i=0;i<numberOfStocks;i++)
		{
			float conversionRate = 1;
			//prompt for user input
			System.out.println("\nSTOCK " + (i + 1));
			System.out.print("Type(1-Normal, 2-Foreign): ");
			int type = input.nextInt();
			System.out.print("Company Name: ");
			String companyName = input.next();
			System.out.print("Purchase Share Price: ");
			float purchaseSharePrice = input.nextFloat();
			System.out.print("Current Share Price: ");
			float currentSharePrice = input.nextFloat();
			System.out.print("Number of Shares: ");
			int numberOfShares = input.nextInt();
			if (type == 2) {
				System.out.println("Conversion Rate: ");
				conversionRate = input.nextFloat();
			}
			if (type == 1) {
				stockHolder[i] = new StockHolding(companyName, purchaseSharePrice, currentSharePrice, numberOfShares);
			} else if (type == 2) {
				stockHolder[i] = new ForeignStockHolding(companyName, purchaseSharePrice, currentSharePrice, numberOfShares,conversionRate);
			}
		}
		
		Menu();
		System.out.println("Enter Choice: ");
		int choice;
		choice = input.nextInt();
		Choice(choice, stockHolder);		
	}
	
	private static void Choice(int choice, StockHolding[] stockHolder) {
		
		int minValueIndex = 0, maxValueIndex = 0, minProfitIndex = 0, maxProfitIndex = 0;
		for (int i = 0; i < stockHolder.length; i++) 
		{
			if (stockHolder[i].valueInDollars() < stockHolder[minValueIndex].valueInDollars())
				minValueIndex = i;
			if (stockHolder[i].valueInDollars() > stockHolder[maxValueIndex].valueInDollars())
				maxValueIndex = i;
			if (stockHolder[i].valueInDollars() - stockHolder[i].costInDollars() < stockHolder[minProfitIndex].valueInDollars() - stockHolder[minProfitIndex].costInDollars())
				minProfitIndex = i;
			if (stockHolder[i].valueInDollars() - stockHolder[i].costInDollars() > stockHolder[maxProfitIndex].valueInDollars()	- stockHolder[maxProfitIndex].costInDollars())
				maxProfitIndex = i;
		}
		while(choice!=7)
		{
			Menu();
			if (choice == 1) {
			System.out.println("\nStock With Lowest Value: ");
			stockHolder[minValueIndex].display();
			} 
			else if (choice == 2) {
				System.out.println("\nStock with Highest Value: ");
				stockHolder[maxValueIndex].display();
			} 
			else if (choice == 3) {
				System.out.println("\nStock with Least Profit: ");
				stockHolder[minProfitIndex].display();
			} 
			else if (choice == 4) {
				System.out.println("\nStock with Most Profit: ");
				stockHolder[maxProfitIndex].display();
			} 
			else if (choice == 5) {
				LexicographicalSort(stockHolder);
				for(StockHolding share:stockHolder)
					share.display();
			}
			else if(choice == 6) {
				ValueSort(stockHolder);
				for(StockHolding share:stockHolder)
					share.display();
			}
			else if(choice ==7)
				return;
			else
				System.out.println("Invalid choice!");
			choice = input.nextInt();
		}
		
		input.close();	
	}//end Question3

	//Method to display menu
	public static void Menu()
	{
		System.out.println("1. Display stock information with the lowest value");
		System.out.println("2. Display stock with the highest value");
		System.out.println("3. Display the most profitable stock");
		System.out.println("4. Display the least profitable stock");
		System.out.println("5. List all stocks sorted by company name (A-Z)");
		System.out.println("6. List all stocks sorted from the lowest value to the highest value");
		System.out.println("7. Exit");
	}
	
	//Method to sort in alphabetical order
	public static void LexicographicalSort(StockHolding[] stockHolder) {
		int n = stockHolder.length;
		for(int i=0;i<n;i++)
		{
			for(int j = i+1;j<n;j++)
				if(((stockHolder[i].companyName()).compareTo(stockHolder[j].companyName()))>0)
				{
					StockHolding temp = stockHolder[i];
					stockHolder[i] = stockHolder[j];
					stockHolder[j] = temp;
				}
		}
	}
	
	//Method to sort in reverse alphabetical order using bubble sort
	public static void ReverseLexicographicalSort(StockHolding[] stockHolder) {
		int n = stockHolder.length;
		for(int i=0;i<n;i++)
		{
			for(int j = i+1;j<n;j++)
			{
				if(((stockHolder[i].companyName()).compareTo(stockHolder[j].companyName()))<0)
				{
					StockHolding temp = stockHolder[i];
					stockHolder[i] = stockHolder[j];
					stockHolder[j] = temp;
				}
			}
		}
	}
	
	//method to sort stack based on values by using bubble sort
	public static void ValueSort(StockHolding[] stockHolder) {
		int n = stockHolder.length;
		for(int i=0;i<n;i++)
		{
			for(int j = i+1;j<n;j++)
				if(((stockHolder[j].valueInDollars()) > (stockHolder[j +1].valueInDollars())))
				{
					StockHolding temp = stockHolder[i];
					stockHolder[i] = stockHolder[j];
					stockHolder[j] = temp;
				}
		}
	}
}
