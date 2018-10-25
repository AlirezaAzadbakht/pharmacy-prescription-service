package ir.nimbo;

public class UninsurdDrug extends Drug{
	public UninsurdDrug(int price, String name) {
		super(price, name);
		this.basePrice = price;
		this.name = name;
		this.type=false;
	}

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return this.getBasePrice();
	}
	

}
