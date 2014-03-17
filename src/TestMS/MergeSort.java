package TestMS;


public class MergeSort {
	
	public static void main(String args[]){
		
		int a[]={12,1,3,0,-9,-9,3000,0,9,8,100};
//		Integer[] a={5,5,1,0,-9,2};
//		ArrayList<Integer> b=new ArrayList<Integer>();
		mergeSort(a,0,a.length-1);
		System.out.print("Sorted Array : ");
		for(int i:a){
			System.out.print(i+" ");
		}		
	}
	
	static void mergeSort(int[] a,int s,int e){
		if( (e-s) < 1)// it would consider s>e or s==e
			return;
		
		int mid= (e+s) /2;
		
		mergeSort(a,0,mid);
		mergeSort(a,mid+1,e);
		//At this stage we must have array a sorted including index s,e
		merge(a,s,mid,e);
	}
	
	/**
	 * 
	 * @param a .. input array
	 * @param s .. start index
	 * @param mid .. mid index
	 * @param e .. end index
	 */
	//TODO Confirm stability
	public static void merge(int[] a,int s,int mid, int e){
		if(e-s < 1 ) return;
		int[] tempArray=new int[(e-s)+1];
		int i=s;
		int j=mid+1;
		int k=0;
		
		for(;i<=mid && j <=e ;){
			if(a[i]<a[j]){
				tempArray[k]=a[i];
				i++;k++;
			}else{
				tempArray[k]=a[j];
				j++;k++;
			}
		}
		while(j<=e){
			tempArray[k]=a[j];
			k++;j++;
		}
		while(i<=mid){
			tempArray[k]=a[i];
			i++;k++;			
		}
		//Copy merged sorted array back into a.
		for(i=s,k=0;i<=e ;i++,k++ )
		{
			a[i]=tempArray[k];
		}
	}
	
}
