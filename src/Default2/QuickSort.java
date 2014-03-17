package Default2;

//3 solutions
//Stable solution 2
//Worst case O(n^2)
//Average case O(n)

//Space , Time Complexity
//This is a very easy problem, this is expected of you in no time.
//Quick sort has 2 approaches, one is naive , in naive you are using O(n) space, in in place you are not using external space..
// Which one is stable and which one is not stable it's to be figured out.
//2 way quick sort has 3 type of implementations
// 1. Simple approach uses O(n) space
// 2. StoreIndex keeps track of last greater element in the array.
// 3. Using Partition function to get the partition.

public class QuickSort {
	public static void main(String args[]){
		int []ar={0,0,1,0,0,-2};
		quickSort(ar,0,ar.length-1);
		
		for(int a:ar){
			System.out.print(a+" ");
		}
		
//		quick3waySort(ar,0,ar.length-1);
	}
	
	private static void quick3waySort(int[] ar) {
		// TODO Auto-generated method stub
		
	}

	
	private static void quickSort(int[] a,int i,int j){
		if(i>=j)
			return;
		int p=partition(a,i,j);
		quickSort(a,i,p-1);
		quickSort(a,p+1,j);
	}

	private static int partition(int[] a, int i, int j) {
		//Does performance depends on the selection of the pivot location.
		
		int pivot=a[j]; // pivot element
		int s=i;
		int e=j-1;
		
		while(true){
			
			while(a[s]<pivot) s++;
			
			while(a[e]>=pivot){
				e--;
			   if(e<=s) break;
			}
			
			if(s>=e) break;
			
			swap(a,s,e); s++;e--;
		}
		swap(a,s,j);
		return s;
		
	}

	private static void swap(int[] a, int s, int e) {
		int temp=a[s];
		a[s]=a[e];
		a[e]=temp;
	}
	
	
	
	public void sort(int []a){
		quickSort(a,0,a.length-1);
	}
}
