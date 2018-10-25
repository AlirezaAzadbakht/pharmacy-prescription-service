package ir.nimbo;

public class InsuredDrug extends Drug {

	public InsuredDrug(int price, String name) {
		super(price, name);
		// TODO Auto-generated constructor stub
		this.basePrice = price;
		this.name = name;
		this.type = true;
	}
	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return this.getBasePrice();
	}

	
	
}
