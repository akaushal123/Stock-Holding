public class ForeignStockHolding extends StockHolding
{
	private float conversionRate;
	
	public ForeignStockHolding(String companyName, float purchaseSharePrice, float currentSharePrice,
			int numberOfShares, float conversionRate) {
		super(companyName, purchaseSharePrice, currentSharePrice, numberOfShares);
		this.conversionRate = conversionRate;
	}
	 
	@Override
	public float costInDollars()
	{
		//return cost by converting to exchange rate
		return conversionRate * super.costInDollars();
	}
	@Override
	public float valueInDollars()
	{
		//return value by converting to exchange rate
		return conversionRate * super.valueInDollars();
	}
}
