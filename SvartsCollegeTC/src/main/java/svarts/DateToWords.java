package svarts;



public class DateToWords {
	
	int year,day,month;
	
	
	
	public String print(int i)
	{
		switch(i%10){
			case 1:
				return "ONE ";
				
			case 2:
				return "TWO ";
			case 3:
				return "THREE ";
			case 4:
				return "FOUR";
			case 5:
				return "FIVE";
			case 6:
				return "SIX";
			case 7:
				return "SEVEN";
			case 8:
				return "EIGHT";
			case 9:
				return "NINE";
			default:
				return "ZERO ";
			
		}
	}
	
	public String convert(int m)
	{
		m=reverse(m);
		
		//System.out.println(m);
		String x="";
		
		while(m!=0)
		{
			int r=m%10;
			x+=print(r)+" ";
			//System.out.println(x);
			m/=10;
		}
		
		
		return x;
	}

	int reverse(int ri)
	{
		int sum=0;
		
		while(ri!=0)
		{
		
			sum=(sum*10)+ri%10;
			ri/=10;
		}
		return sum;
	}
	
	
				
		
}