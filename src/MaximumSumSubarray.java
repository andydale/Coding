public class MaximumSumSubarray {
	public static void main(String args[]){
		int arr[]={-9,10,-5,19,-20,500};
		System.out.println(maxsum(arr));
	}

	//cursum  is responsible for carrying the current baggage
	//it should be checked against each a[i] so that we can change the start position
	//maxsum maintains the maximum sum seen so far.
	// as long as you have sth positive from the backlog use it. as soon as it becomes zero move on.

	/**
	 * @param arr .. input array.
	 * @return .. maximum sum value is returned.
	 */
	private static int maxsum(int[] a) {
		int maxsum=a[0];
		int cursum=a[0];
		int startindex=0;
		int endindex=0;
		int maxindex=0;
		int minindex=0;
		for(int i=1;i<a.length;i++)
		{
			if(cursum<=0){
				startindex=i;
			    endindex=i;
			    cursum=a[i];
			}else{
				endindex++;
				cursum=cursum+a[i];
			}
			
			if(cursum>maxsum){
				maxsum=cursum;
				maxindex=endindex;
				minindex=startindex;
			}
		}
		System.out.println(minindex+" "+maxindex);
		return maxsum;
	}
}
