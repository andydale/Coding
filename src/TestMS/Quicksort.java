package TestMS;

import java.util.ArrayList;
/*
 * TODO:
 * 	Space , time complexity
 * 	Optimizations possible
 * 	
 */
public class Quicksort {
	
	public static void main(String args[]){
		int[] a={25,13,5};
		
		quickSortSimple(a,0,a.length-1);
		System.out.print("Sorted Array : ");
		for(int x:a){
			System.out.print(x+" ");
		}
		quickSortInPlace(a,0,a.length-1);		
	}
	
	public static void quickSortInPlace(int[] a,int s,int e){
		int pvt=s;//logic to select pivot
		
		swap(a,s,e);//move pivot to end.
		pvt=a[e];
		
		
		
	}
	
	//Note, all generic recursive functions needs to make sure they use the values between the range.
	public static void quickSortSimple(int[] a,int s,int e){
		if( (e-s) < 1)
			return;
		//select a pivot element, shuffle elements and recurse
		int pvt=s+(e-s)/2; // Mistake here, (e-s)/2 gets you the value out of s,e range, you need to make sure you are always in s,e.		
		//Slightly better solution does this in in-place.
		//Slightly faster algorithm would do a 3 way quick sort.
		//Easy solution you just create two new arrays and partition elements of the main array into it.
		ArrayList<Integer> left=new ArrayList<Integer>();
		ArrayList<Integer> right=new ArrayList<Integer>();
		swap(a,e,pvt);//move pivot to the end.
		for(int i=s;i<e;i++){
			if(a[i]<=a[e]){
				left.add(a[i]);
			}else{
				right.add(a[i]);
			}
		}
		int i=s;
		for(int l:left){
			a[i]=l; i++;
		}
		pvt=i;
		a[i]=a[e];i++;  
		for(int r:right){
			a[i]=r; i++;
		}
		quickSortSimple(a,s,pvt-1);//mistake you don't include pvt in either of the next requests.
		quickSortSimple(a,pvt+1,e);
	}
	
	public static void swap(int[] a,int l,int r){
		int tmp=a[l];
		a[l]=a[r];
		a[r]=tmp;
	}
	
}
