package Default2;
public class HeapSort {
	
	public static void main(String args[]) {
		int a[] = { 4, 3,-10,12,0, 2, 1 };

		sort(a);
		for(int i:a){
			System.out.println(i);
		}
	}

	static void sort(int[] a){
		if(a.length<=1)
			return;
		heapify(a,a.length);
	}
	
	static void heapify(int[] a,int end) {
		if(end==0)
			return;
		
		for(int i=1;i<end;i++){
			int parent=(i-1)/2;
			if(a[i]>a[parent]){
				shiftUp(a,i,parent);
			}
		}
		swap(a,0,end-1);
		heapify(a,end-1);
	}
	
	static void shiftUp(int[] a,int i,int parent){
		swap(a,i,parent);
		i=parent;
		parent=(i-1)/2;
		if(parent >=0 ){
			if(a[i]>a[parent])
			{
			shiftUp(a, i, parent);
			}
		}
	}
	
	static void shiftDown(int []a,int i,int parent){
		
	}
	
	static void swap(int[] a, int i, int j){
		if(i==j)
			return;
		int temp;
		temp=a[j];
		a[j]=a[i];
		a[i]=temp;
	}
}
