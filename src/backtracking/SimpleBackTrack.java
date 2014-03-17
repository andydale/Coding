package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;


//Tug of War 
//Back Tracking Problem

public class SimpleBackTrack {
	
	static int minDiff=Integer.MAX_VALUE;
	
	public static void main(String args[]){
		
		HashSet<Integer> set=new HashSet<Integer>();
		ArrayList<Integer> set1=new ArrayList<Integer>(set.size()/2);
		
		set.add(3);set.add(4);set.add(5);set.add(-3);set.add(100);set.add(1);set.add(89);set.add(54);set.add(23);set.add(20);
		
		backTrack(set1,set);
		
	}
	
	public static void backTrack(ArrayList<Integer> set1,HashSet<Integer> set){
		
		if(Math.abs(set1.size()-set.size())<=1){
			
			int diff=currDiff(set1,set);
			
			if(minDiff>diff)
				minDiff=diff;
			
			
		}
	}
	
	//Sometimes sums can overflow, we need to avoid calculations that causes overflow.
	private static int currDiff(ArrayList<Integer> set1, HashSet<Integer> set) {
		
		int diff=0;
		Iterator<Integer> ir=set.iterator();
		
		int i=0;
	
		while(ir.hasNext()){
			diff+=ir.next();
			if(i<set1.size())
				diff-=set1.get(i++);
		}
		
		for( int i=0;i<set1.size();i++){
			
			diff+=set1.get(i);
			
			if(!set.isEmpty()){
				
			}
		
		}
		return 0;
	}
	
}
