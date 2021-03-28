public class StockHolding {
	
	//Member Variable
	private String companyName;
	private float purchaseSharePrice;
	private float currentSharePrice;
	private int numberOfShares;
		
	//constructor for  setting the values
	public StockHolding(String companyName, float purchaseSharePrice, float currentSharePrice, int numberOfShares)
	{
		this.companyName = companyName;
		this.purchaseSharePrice = purchaseSharePrice;
		this.currentSharePrice = currentSharePrice;
		this.numberOfShares= numberOfShares;
	}
	
	//get functions
	public float costInDollars()
	{
		return purchaseSharePrice * numberOfShares;
	}
	public float valueInDollars()
	{
		return currentSharePrice * numberOfShares;
	}
	public String companyName()
	{
		return companyName;
	}
	public int getNumberOfShares()
	{
		return numberOfShares;
	}
	
	void display() 
	{
		System.out.println("Company Name: " + companyName());
		System.out.println("Number of Shares: " + getNumberOfShares());
		System.out.println("Cost in Dollars: " + costInDollars());
		System.out.println("Value in Dollars: " + valueInDollars());
		System.out.println();
	}
}
