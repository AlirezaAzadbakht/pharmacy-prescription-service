package ir.nimbo;

public class tesat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrescriptionService p = new PrescriptionService(new LocationService() {
			
			@Override
			public double distance(Location loc1, Location loc2) {
				// TODO Auto-generated method stub
				return 0;
			}
		},  null);
		UninsurdDrug d=new UninsurdDrug(2212, "kir") ;
		InsuredDrug dd=new InsuredDrug(2212, "kir") ;
		
		try {
			throw new Exception("hell") ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


