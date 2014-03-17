public class maxMinSumInRange {
	//Kadane's Algorithm for max and min sums in given range in an array.
	//Google Interview Question
	//Kadane's + small DP appraoch.
	public static void main(String args[]) {
		int[] a = { 2, -1, -2, 1, -4, 2, 8 };
		findMaxSubarray(a,2,2).print();		
		findMinSubarray(a,0,a.length-1).print();
		int n=a.length;
		int max=Integer.MIN_VALUE;
		for(int i=0;i<n-1;i++){ //splitting range
			int s1=0;
			int e1=i;
			int s2=i+1;
			int e2=n-1;
			int temp=max(findMaxSubarray(a,s1,e1).absSub(findMinSubarray(a,s2,e2)),findMinSubarray(a,s1,e1).absSub(findMaxSubarray(a,s2,e2)));
			if(max < temp){
				max=temp;
			}
		}
		System.out.println(max);
	}
	private static int max(int a,int b){
		return a>b ? a : b;
	}
	
	
	private static Element findMinSubarray(int[] a, int i, int j) {
		int curSum=Integer.MAX_VALUE;
		int sum=Integer.MAX_VALUE;
		int start=-1;
		int min=-1;
		int end=-1;
		
		for(;i<=j;i++){
			if(curSum > 0){ //We don't want any trailing +values to the next one. As we must switch range when we see a positive  value from past.
				curSum=0;
				start=i;
			}
			curSum+=a[i];				
			
			if(sum > curSum){
				min=start;	//Preserve the start corresponding to each win.
				end=i;
				sum=curSum;
			}	
		}		
		return new Element(min,end,sum);
	}

	private static Element findMaxSubarray(int[] a, int i, int j) {
		int sum=Integer.MIN_VALUE; // I used 0 here initially but it requires to be min value as the result can be a negative value.
		int cursum=-1;
		int maxStart=-1;
		int start=-1;
		int end=-1;
		
		for(;i<=j;i++){			
			if(cursum<0) // Switch range at positive value from previous sum.
			{
				cursum=0;
				start=i;
			}
			cursum+=a[i];		
			if(cursum>sum){ 
				maxStart=start; //preserver start position.
				end=i;
				sum=cursum;
			}
		}			
	return new Element(maxStart,end,sum);
	}
	
	public static class Element{
		int start;
		int end;
		int val;
		public Element(int s,int e,int v){
			start=s;
			end=e;
			val=v;
		}
		public void print(){
			System.out.println(val+" ["+start+","+end+"]");
		}
		public int absSub(Element e){
			int v=val-e.val;
			return v >0 ? v : -1*v;
		}
	}
	
}
