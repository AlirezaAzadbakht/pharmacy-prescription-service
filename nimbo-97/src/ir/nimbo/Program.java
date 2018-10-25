package ir.nimbo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Program {

	
	public static void main(String[] args) {
		
		DrugRepository repository = DrugRepository.getInstance();
		Drug d1 = new InsuredDrug(500, "Adult Cold");
		Drug d2 = new InsuredDrug(1000, "Losartan");
		Drug d3 = new InsuredDrug(1000, "Zanaflex");
		
		repository.addDrug(d1);
		repository.addDrug(d2);
		repository.addDrug(d3);
		
		PrescriptionItem item = new PrescriptionItem("Adult Cold", 3);
		Set<PrescriptionItem> items = new HashSet<>();
		items.add(item);
		
		Date date = new Date();
		
		Prescription prescription = new Prescription(items, new Location(2, 3), date);
		Pharmacy pharmacy = new Pharmacy("ph", new Location(1, 2));
		pharmacy.addDrug(d1, 3);
		pharmacy.addDrug(d3, 5);
		Set<Pharmacy> pharmacies = new HashSet<>();
		pharmacies.add(pharmacy);
		
		LocationService locationService = new LocationService() {
			@Override
			public double distance(Location loc1, Location loc2) {
				return 1;
			}
		};
		
		System.out.println("Before:");
		System.out.println(pharmacy.getDrugInventory(d1));
		System.out.println(pharmacy.getDrugCount());
		
		PrescriptionService service = new PrescriptionService(locationService, pharmacies);
		System.out.println(service.finalRegisteration(prescription, pharmacy));
		
		System.out.println("After:");
		System.out.println(pharmacy.getDrugInventory(d1));
		System.out.println(pharmacy.getDrugCount());
	}

}
