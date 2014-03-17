package Test;

//Big mistake 2 :  p= j-1/2
// 					Above expression should be (j-1)/2
// The below algorithm has n^2log complexity,because you are heapifying after each run.

// Create algo on paper, think about complexity.
// Improvement : Once your heap is constructed you need to just move the top element down at proper place to be able to keep the heap in order.
//Sift down has O(n) complexity
//Sift  up has O(nlogn) complexity

// TODO : Try out the top down ( you start from last parent and move up) approach of heapifying ( you tried bottom to top approach which takes nlog time in heapification


public class heapSort {
	public static void main(String args[]){		
		int a[]={10,9,3,592,53,28754,233};
		heapify(a,a.length);
		heapSort(a,a.length);
		for(int i:a){
			System.out.print(i+" ");
		}
	}
	
	
	public static void heapSort(int[]a, int len){
		while(len > 1){
			heapify(a,len);
//			swap first and last element
			int temp=a[0];
			a[0]=a[len-1];
			a[len-1]=temp;
			len-=1;
		}
	}

	public static void heapify(int []a,int len){
		if(len <= 1)
			return;
		for(int m= len-1;m>=1;m--){
			int j=m;
			int p= (j-1)/2;
			while( p>=0 &&  a[p] < a[j]){
				int temp=a[p];
				a[p]=a[j];
				a[j]=temp;
				j=p;
				p= (j-1)/2;
			}
		}
		
	}
}
