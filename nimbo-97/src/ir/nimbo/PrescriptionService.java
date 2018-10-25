package ir.nimbo;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class PrescriptionService {

	private LocationService locationService;
	private Set<Pharmacy> pharmacies = new HashSet<>();
	private DrugRepository drugRepository = DrugRepository.getInstance();

	public PrescriptionService(LocationService locationService, Set<Pharmacy> pharmacies) {
		this.locationService = locationService;
		this.pharmacies = pharmacies;
	}
	
	public Pharmacy primaryRegisteration(Prescription prescription) {
		//TODO
		
		 Instant dbInstant = prescription.getDate().toInstant();
		 Instant aMonthAgo = ZonedDateTime.now().minusDays(30).toInstant();
		 boolean withinLast30Days = dbInstant.isAfter(aMonthAgo);		
		
		 if (withinLast30Days==false)
			 {
				 throw new ArithmeticException("Prescription is expired.");
			 }
		
		 
		Pharmacy bestPH = null;
		
		 for (Pharmacy pharmacy : pharmacies) {
				boolean flag = true;
				
				for (PrescriptionItem item : prescription.getItems()) {
					for (Drug drug : pharmacy.getDrugsList()) {
						if (drug.getName().equals(item.getName())==false || pharmacy.getDrugInventory(drug)< item.getNumber())
						{
							flag = false;
							break;
						}
					}
					if (flag==false)
						break;
				}
				
				if (flag)
				{
					if (bestPH==null)
					{
						bestPH=pharmacy;
					}
					else if (locationService.distance(pharmacy.getLocation(), prescription.getLocation()) < locationService.distance(bestPH.getLocation(), prescription.getLocation()))
					{
						bestPH=pharmacy;
					}
				}
			}
			
		 	
		 	if ( bestPH==null)
		 	{
		 		throw new ArithmeticException("No Pharmacy Found. Try Later...");
			}
			else
			{
				return bestPH;
			}
		 
	}
	
	public int finalRegisteration(Prescription prescription, Pharmacy pharmacy) {
		//TODO
		int totalcost=0;
		for (PrescriptionItem item : prescription.getItems()) {
			for (Drug drug : pharmacy.getDrugsList()){
				if (drug.getName().equals(item.getName()))
				{
					if(drug.type)
					{
						int temp=(int) Math.ceil(drug.getBasePrice()*0.7);
						totalcost=  totalcost + temp*item.getNumber();
					}
					else
					{
						totalcost=  totalcost + (drug.getBasePrice()*item.getNumber());
					}
					
					drug.setInventory(drug.getInventory()-item.getNumber());
					pharmacy.updateMe();
				}
			}
			
		}
		return totalcost;
		
	}

	
}
