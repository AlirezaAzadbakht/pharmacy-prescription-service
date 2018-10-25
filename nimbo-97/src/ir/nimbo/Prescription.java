package ir.nimbo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class Prescription {

	private Set<PrescriptionItem> items = new HashSet<>();
	private Location location;
	private Date date;
	
	public Prescription(Set<PrescriptionItem> items, Location location, Date date) {
		this.items = items;
		this.location = location;
		this.date = date;
	}

	public Set<PrescriptionItem> getItems() {
		return items;
	}

	public Location getLocation() {
		return location;
	}
	public Date getDate(){
		return date;
	}

}
