import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Stringtestsearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str= "alireza";
		if( str.contains("a l"))
			System.out.println("yup");
		else 
			System.out.println("nope");
		
		String base = "Alireza heell";
		String stt = "%Ali%%reza%hell";
		StringTokenizer mytoken = new StringTokenizer(stt, "%");
		
		while (mytoken.hasMoreTokens())
		{
			String temp= mytoken.nextToken();
			if(base.contains(temp)==false)
			{
				System.out.println(temp);
			}
		}
		ArrayList<Integer> availableP= new ArrayList<>();
		availableP.add(1);
		System.err.println(availableP.size());
		
		
		   LocalDateTime now = LocalDateTime.now();  
		   System.out.println(now.getDayOfYear());  
		   LocalDateTime date = now;
		   
		  // b bb = new b();
	}
	
	 
	class a{
		public  a(){
			System.out.println("hell");
		}
	}
	class b extends a{
		
	}
	
}
