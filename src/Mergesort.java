
public class Mergesort {
	//How does inplace merge sort works ??
	
	public static void main(String args[]){
		int a[]={10,0,1,12,-100};
		mergeSort(a,0,a.length-1);
		
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
		
	}

	private static void mergeSort(int[] a, int i, int j) {
		if(i==j)
			return;
		if(i+1==j){
			if(a[i]>a[j]){
				int temp=a[j];
				a[j]=a[i];
				a[i]=temp;
			}
			return;
		}
		int mid=(i+j)/2;
		mergeSort(a,i,mid);
		mergeSort(a,mid+1,j);
		
		int start1=i;
		int end1=mid;		
		int start2=mid+1;
		int end2=j;
				
		int tempArray[]=new int[j-i+1];
		int index=0;
		
		for(;start1<=end1 && start2<=end2;index++){
			if(a[start1] < a[start2] ){				
				tempArray[index]=a[start1];
				start1++;
			}else{
				tempArray[index]=a[start2];
				start2++;
			}
		}
		
		for(;start1<=end1;index++){
				tempArray[index]=a[start1];
				start1++;
		}
		for(;start2<=end2;index++){
			tempArray[index]=a[start2];
			start2++;
		}
		
		//copy back the array to the original one.
		int m=0;
		for(int p=i;p<=j;p++,m++){
			a[p]=tempArray[m];
		}
	}
}
