/**
 * 
 * create permute method with 2 arguments prefix,input
 * prefix contains current chosen prefix, and each subsequent call it get's appended untill the input exhuast.
 * input contains the string that needs to be permuted.
 * 
 * 
 * Do this problem using back tracking.
 * 	that is an inplace solution and doesn't require creating a new string each time.
 * 
 */
public class permute {
	public static void main(String args[]){
		
		permute("","132");
		
	}

	private static void permute(String prefix,String str) {
		
		if(str.length()==0){
			if(prefix.length()>0){
				System.out.println(prefix.toString());
			}
			return;
		}
		
		char[] arr=str.toCharArray();
		
		for(int i=0;i<arr.length;i++){
			permute(prefix+arr[i],getRestString(arr,i));
		}
		return;
	}


	private static String getRestString(char[] arr, int i) {
		StringBuilder sb=new StringBuilder();
		int j=0;
		for(char ch:arr){
			if(j!=i)
				sb.append(ch);
			j++;
		}
		return sb.toString();
	}
}