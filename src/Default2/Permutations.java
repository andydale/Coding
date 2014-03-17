package Default2;

public class Permutations {
	public static int count = 0;
	public static void main(String args[]){
		String input="012012";
		char[] arr=input.toCharArray();
		permute(arr,0,input.length()-1);
	}
	
	private static void allsubset(String input){
		
	}
	
	public static void permute(String left,String center,String right) {
		
		
	}
	
	static void permute(char[] input, int i, int n)
	{
	   int j; 
	   if (i == n){
		   System.out.print(++count+" : ");
		   System.out.println(input);
	    }
	   else
	   {
	        for (j = i; j <= n; j++)
	       {
	          swap(input,i,j);
	          permute(input, i+1, n);
	          swap(input,i,j); //backtrack
	       }
	   }
	} 
	
	
	
	private static void swap(char[] ar, int i, int j) {
		char temp=ar[i];
		ar[i]=ar[j];
		ar[j]=temp;
	}

	public static void getAllPairs(String input, int n){
		
	}
	
	public static void permute(String soFar, String strLeft) {
	    if(strLeft.length() == 1) {
	        soFar += strLeft;
	        System.out.println(++count + " :: " + soFar);
	    }
	    for(int i=0; i<strLeft.length(); i++) {
	        permute(soFar + strLeft.charAt(i), strLeft.substring(0,i) + strLeft.substring(i+1));
	    }
	}
}
