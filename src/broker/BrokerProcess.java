package broker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BrokerProcess{

	
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		ArrayList<StockInfo> stockList = getStocks();

		for(StockInfo stock: stockList){
			WatchThread runner = new WatchThread(stock);
			runner.start();
		}
	}
	
	public static ArrayList<StockInfo> getStocks() throws IOException{
		ArrayList<StockInfo> stocks = new ArrayList<StockInfo>();
		
		String filePath = "C:\\Temp\\stockFile";
		Scanner contents = new Scanner(new BufferedReader(new FileReader(filePath)));
		
		while(contents.hasNextLine()) {
			String line = contents.nextLine();
			String[] items = line.split(",");
			stocks.add(new StockInfo(items[0], Double.parseDouble(items[1]), Integer.parseInt(items[2])));
		}
		contents.close();
		
		return stocks;
	}

}
