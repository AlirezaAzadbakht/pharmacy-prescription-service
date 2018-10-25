package ir.nimbo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Pharmacy {
	
	private ArrayList<Drug> drugs = new ArrayList<>();
	private String name;
	private Location location;

	public Pharmacy(String name, Location location) {
		this.name = name;
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public Location getLocation() {
		return location;
	}

	public Integer getDrugInventory(Drug drug) {
		//TODO
		for (Drug data : drugs) {
			if (data.getName().equals(drug.getName()))
			{
				return data.getInventory();
			}
		}
		return null;
		
	}

	public int getDrugCount() {
		//TODO
		int count=0;
		for (Drug drug : drugs) {
			count++;
		}
		return count;
	}

	public void addDrug(Drug drug, int inventory) {
		//TODO
		drug.setInventory(inventory);
		drugs.add(drug);
	}

	public void removeDrug(Drug drug) {
		//TODO
		for (Drug drugg : drugs) {
			if(drugg.getName().equals(drug.getName()))
				drugs.remove(drugg);
		}
		
	}
	public void updateMe()
	{
		for (Drug drug : drugs) {
			if(drug.getInventory()==0)
				drugs.remove(drug);
		}
	}
	
	public ArrayList<Drug> getDrugsList(){
		return drugs;
	}

}
