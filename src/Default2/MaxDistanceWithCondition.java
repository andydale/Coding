package Default2;


// Note: One way to distinguish between data structures provide length or the size method can be found by the type of datastructure. 
// Java Observations::
// DS whose size doesn't change after definition they have length variable associated. Examaple, array, string
// DS whose size changes dynamically have the size funciton to get their length; they typically store the latest value, the implementatio of size funciton is public int size(){return size};
// Good Observation :: (x+y) / 2 can cause overflow, so it's smarter to use left + ( right - left )/2 as to find the middle of the array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MaxDistanceWithCondition {

	
	public static void main(String args[]){
		//int a[]=Utils.genArray(10,10); //size, maxValue
		int a[]={4,3,5,2,1,3,2,3};
		
		//Missed 1 part::
		//Need to skip the equals, as they don't satisfy the condition, a[i] < a[j] 
		System.out.println(maxDistance(a));	
		
	}

	private static int maxDistance(int[] a) {
		
		int d=0;
		
		ArrayList<Pair> ar=new ArrayList<Pair>(a.length);
		for(int i=0;i<a.length;i++){
			ar.add(new Pair(a[i],i));
		}
		
		//Must Know
		Collections.sort(ar, new Comparator<Pair>(){
			@Override
			public int compare(Pair arg0, Pair arg1) {
				if(arg0.val>arg1.val) return 1;
				else if(arg0.val<arg1.val) return -1;
				else return 0;
			}			
		});
		int j=ar.size()-1;
		a[j]=ar.get(j).index;
		int maxSeenRight=a[j];
		j-=1;
		for(;j>=0;j--){
			int cur=ar.get(j).index;
			if(cur > maxSeenRight){
				maxSeenRight= cur;
			}
			a[j]=maxSeenRight;
			if((a[j]-cur) > d){
				d=a[j]-cur;
			}
		}
		return d;
	}
	
	private static class Pair{
		public int val;
		public int index;
		public Pair(int val,int index){
			this.val=val;
			this.index=index;
		}
	}
	
}

//I could have done the same thing using Hashmap but didn't do that ....
//Generate an array with positive and negative numbers in given range.