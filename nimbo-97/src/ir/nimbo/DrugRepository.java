package ir.nimbo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class DrugRepository {
	
	private static DrugRepository single_instance=null;
	
	private Set<Drug> drugs = new HashSet<>();

	public static DrugRepository getInstance() {
		//TODO
		if (single_instance == null)
			single_instance = new DrugRepository();
		return single_instance;
	}
	private DrugRepository() {
	// TODO Auto-generated constructor stub
	}

	public Set<Drug> getDrugs() {
		return drugs;
	}

	public void addDrug(Drug drug) {
		boolean flag =true;
		for (Drug drugg : drugs) {
			if (drugg.name.equals(drug.name))
				flag=false;
		}
		if (flag)
		{
			drugs.add(drug);
		}
	}

	public Drug findDrugByExactName(String name) {
		//TODO
		for (Drug drug : drugs) {
			if (drug.getName().equals(name))
			{
				return drug;
			}
		}
		return null;
	}

	public List<String> search(String query) {
		//TODO
		List<String> list = new ArrayList<String>(); 
		
		/*for (Drug drug : drugs) {
			boolean flag = true;
			String temp="";
			StringTokenizer mytoken = new StringTokenizer(query, "%");
			while (mytoken.hasMoreTokens())
			{
				temp= mytoken.nextToken();
				if(drug.getName().contains(temp)==false)
				{
					flag=false;
					break;
				}
			}
			if (flag)
			{
				list.add(drug.getName());
			}
		}
		*/
		String temp="";
		StringTokenizer mytoken = new StringTokenizer(query, "%");
		while (mytoken.hasMoreTokens())
		{
			temp= mytoken.nextToken();
			for (Drug drug : drugs) {
				if(drug.getName().toLowerCase().contains(temp.toLowerCase()))
				{
					list.add(drug.name);
				}
				else
				{
					list.remove(drug.name);
				}
			}
			
		}
		
		return list;
		
	}

}
