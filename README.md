# Stock-Holding

1. Create a class called StockHolding to represent a stock that you have purchased. For instance variables, it will have two floats named purchaseSharePrice and currentSharePrice, one int named numberOfShares and one string named companyName. Create accessor methods for the instance variables. Create two other instance methods:

- (float)costInDollars; // purchaseSharePrice \* numberOfShares

- (float)valueInDollars; // currentSharePrice \* numberOfShares

Populate an array with three instances of StockHolding. Display all the stocks sorted by company name in alphabetical order.

_ **NOTE: Picture below does not show the companyName but you should implement it in your class.** _


![image](https://user-images.githubusercontent.com/25979883/112765049-f21cd700-9028-11eb-8a2c-8a087a79b3f3.png)

2. Create a subclass of StockHolding called ForeignStockHolding. Give ForeignStockHolding an additional instance variable: conversionRate, which will be a float. (The conversion rate is what you need to multiply the local price by to get a price in Canadian dollars. Assume the purchasePrice and currentPrice are in the local currency.) Override costInDollars and valueInDollars to do the right thing.

Add at least two instances of ForeignStockHolding to the existing array from part one.

Display all the stocks sorted by company name in reverse alphabetical order.


![image](https://user-images.githubusercontent.com/25979883/112765055-f77a2180-9028-11eb-8057-80710fafdfe0.png)

3. Modify the application so the user can choose how many stocks they want to enter as well as the type of the stock (maximum 8 stocks). The application should accept user data for every stock and after the data has been entered it should display the following menu:

1. Display stock information with the lowest value
2. Display stock with the highest value
3. Display the most profitable stock
4. Display the least profitable stock
5. List all stocks sorted by company name (A-Z)
6. List all stocks sorted from the lowest value to the highest value
7. Exit
