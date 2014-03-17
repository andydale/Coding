package Default2;

//TODO:: Find the subtelty of oscillations when you are calculating power close to an offset value. 
public class jtest {
	
	public static void main(String args[]){
		
		jtest obj=new jtest();		
		try{
			System.out.println(obj.pow(2.0,2));
		}catch (Exception e){
			System.err.println("Error "+e.getMessage());
		}		
	}

	/*
	 * a - -ve,+ve, int , float , 0
	 * Input types - negative, int , 0, float , positive
	 * 
	 */
	private double pow(double a, int b) throws Exception{
		
		if(a==0 && b!=0){
			return 0;
		}else if(a==0 && b==0){
			throw new Exception("Divide by zero exception !");
		}else if ( a!=0 && b==0){
			return 1.0;
		}else if (b<0){
			a=1/a;
			b*=-1;
			return pow(a,b);
		}else if ( b==1){
			return a;
		}

		if(b%2==0){
			return pow(a,b/2)*pow(a,b/2);		
		}else{
			//return pow a* a b-1;
		}
		return 0.0;
	}
	
	/*
	 * Test cases for the job.
	 * -1,-1
	 * -1,0
	 * 0,-1
	 * 0,0
	 * 1,0
	 * 0,1
	 * 1,1 
	 * 0.09,0.01
	 */
}
