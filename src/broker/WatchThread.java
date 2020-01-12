package broker;

import java.io.*;
import java.net.*;

public class WatchThread extends Thread{

	StockInfo stock;
	
	public void run() {
			System.out.println("Inside thread "+ stock.stockName);
			try {
				while(true) {
					Double price = getPrice(stock.stockName);
					
					printResults(price);
				
					Thread.sleep(120000);
				}
			}catch(Exception e) {
				
			}
			
	}

	WatchThread(StockInfo stock){
		this.stock = stock;
	}
	
	
	public Double getPrice(String name) throws IOException {
		String html = "https://www.alphavantage.co/query?function=BATCH_STOCK_QUOTES&symbols="+name+"&apikey=MSXZ3X1PAPZY9QRF";
		URL url = new URL(html);
		InputStreamReader reader = new InputStreamReader(url.openStream());
		BufferedReader page = new BufferedReader(reader);
		
		String inputLine;
        while ((inputLine = page.readLine()) != null) { 
        	//System.out.println(inputLine);
        	if(inputLine.contains("2. price")) {
        		//System.out.println((inputLine.split("\"")[3]));
        		return Double.valueOf(inputLine.split("\"")[3]);
        	}
        }
        return null;
	
	}
	
	public void printResults(Double price) {
		double diff =price - stock.buyPrice;

		System.out.println(stock.stockName+" stock price is now " + price);
		System.out.println(stock.stockName+" bought price was " + stock.buyPrice);
		System.out.printf(stock.stockName +" difference of %.2f or %.2f percent\n", diff, diff/price);

		System.out.printf(stock.stockName +" gain/loss of $%.2f\n", diff *stock.quantity);

	}
}
