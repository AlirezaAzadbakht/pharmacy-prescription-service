package ir.nimbo;

public class PrescriptionItem {
	
	private String name;
	private int number;

	public PrescriptionItem(String name, int number) {
		this.name = name;
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public int getNumber() {
		return number;
	}

}
