package broker;

public class StockInfo {

	protected String stockName;
	protected double buyPrice;
	protected int quantity;
	
	public StockInfo(String stockName, double buyPrice, int quantity) {
		this.stockName = stockName;
		this.buyPrice = buyPrice;
		this.quantity = quantity;
	}
	
	public String getName(){
		return this.stockName;
	}
	public double getBuyPrice() {
		return this.buyPrice;
	}
	public int getQuantity() {
		return this.quantity;
	}
	public void setName(String name){
		this.stockName = name;
	}
	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
