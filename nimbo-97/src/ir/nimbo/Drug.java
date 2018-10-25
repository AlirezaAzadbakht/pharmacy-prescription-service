package ir.nimbo;

public abstract class Drug {

	protected int basePrice;
	protected String name;
	private int inventory;
	protected boolean type;

	public Drug(int price, String name) {
		this.basePrice = price;
		this.name = name;
		
	}

	public abstract int getPrice();

	public int getBasePrice() {
		return basePrice;
	}

	public String getName() {
		return name;
	}
	
	public int getInventory(){
		return inventory;
	}
	
	public void setInventory(int inventory){
		this.inventory=inventory;
	}

}
