
public class kadanes {
	
	public static void main(String args[]){
		
		int[] a={-20,2,4,90,-100,100,0,0,2};
		
		println(maxSubArraySum(a));
		
	}
	
	public static int maxSubArraySum(int[] a){
			int sum=Integer.MIN_VALUE;
			int curr=Integer.MIN_VALUE;

			for(int i=0;i<a.length;i++){
				
				if(curr<0){//if less 0 drop the sum.
					curr=a[i];
				}else{
					curr+=a[i];
				}
								
				if(curr>sum){
					sum=curr;
				}
			}
			return sum;
	}
	
	public static void println(int a){
		System.out.println(a);
	}
	
}
